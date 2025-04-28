package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBBooks {
    private static final String DB_URL = "jdbc:sqlite:db/echo.db";

    
    private static Connection connect() {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }
    
    
    private static BookObject bookDataList(ResultSet rs) throws SQLException {
		BookObject book = null;
		if (rs.next()) {
			int id = rs.getInt("id");
            String title = rs.getString("title");
            String author = rs.getString("author");
            String genre = rs.getString("genre");
            String publisher = rs.getString("publisher");
            String ISBN = rs.getString("ISBN");
            String shelfLocation = rs.getString("shelfLocation");
            String releaseDate = rs.getString("releaseDate");
            String status = rs.getString("status");
           
            book = new BookObject(id, title, author, genre, publisher, ISBN, shelfLocation, releaseDate, status);
        } else {
            System.out.println("No book found with that ID.");
        }
		return book;
	}

    
    public static void createTable() {
	    String sql = """
	        CREATE TABLE IF NOT EXISTS books (
	            id INTEGER PRIMARY KEY AUTOINCREMENT,
	            title TEXT NOT NULL, 
	            author TEXT NOT NULL, 
	            genre TEXT NOT NULL, 
	            publisher TEXT NOT NULL, 
	            ISBN TEXT NOT NULL, 
	            shelfLocation TEXT NOT NULL, 
	            releaseDate TEXT NOT NULL, 
	            count INTEGER NOT NULL,
	            status TEXT NOT NULL DEFAULT 'Unavailable' -- Unavailable, Available
	        );
	        """;
	
	    try (Connection conn = connect();
	         var stmt = conn.createStatement()) {
	        stmt.execute(sql);
	        System.out.println("Table created or already exists.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
    
    
    public static void deleteTable() {
    	String sql = "DROP TABLE IF EXISTS books";
    	
    	try(Connection conn = connect();
    		Statement stmt = conn.createStatement()) {
    		
    		stmt.execute(sql);
    		System.out.println("Table 'books' has been dropped (if it existed).");
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    
    public static void insertBook(String title, String author, String genre, String publisher, 
    		String ISBN, String shelfLocation, String releaseDate, int count, String status) {
	    String sql = "INSERT INTO users(title, author, genre, publisher, ISBN, shelfLocation, "
	    		+ "releaseDate, count, status) "
	    		+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	    try (Connection conn = connect();
	        var pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, title);
	        pstmt.setString(2, author);
	        pstmt.setString(3, genre);
	        pstmt.setString(4, publisher);
	        pstmt.setString(5, ISBN);
	        pstmt.setString(6, shelfLocation);
	        pstmt.setString(7, releaseDate);
	        pstmt.setInt(8, count);
	        pstmt.setString(9, status);
	       
	        pstmt.executeUpdate();
	        System.out.println("Book added.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
    
    
    public static void deleteBook(int id) {
		String sql = "DELETE FROM books WHERE id = ?;";
		
		try (Connection conn = connect();
			 var stmt = conn.prepareStatement(sql)) {
			
			stmt.setInt(1,  id);
			
			int rowsDeleted = stmt.executeUpdate();
			
			if(rowsDeleted > 0) {
				System.out.println("Book with ID: " + id + " was deleted.");
			} else {
				System.out.println("No book with ID: " + id + " found.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
    public static int getBookAvailability(int bookid) {
    	int count = 0;
    	String sql = "SELECT count FROM books"
    			+ "WHERE id = ?;";
    	try (Connection conn = connect();
   	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
    			
    			pstmt.setInt(1, bookid);
    			
	   	        ResultSet rs = pstmt.executeQuery();
	   	        if (rs.next()) {
	   	        	count = rs.getInt("count");
	   	        }
   	    } catch (SQLException e) {
   	        e.printStackTrace();
   	    }
    	return count;
    }
    
    
    public static void changeBookStatus(int bookId, String status) {
    	String sql = "UPDATE books SET status = ? "
    			+ "WHERE id = ?;";
    	
    	try (Connection conn = connect();
       		 PreparedStatement pstmt = conn.prepareStatement(sql)) {
       		
    		pstmt.setString(1, status);
    		pstmt.setInt(2, bookId);
    		
    		pstmt.executeUpdate();
  	    } catch (SQLException e) {
  	        e.printStackTrace();
  	    }
    }
    
    
    public static void changeBookAvailability(int bookid, char type) {
    	
    	// If type == '0': decrement book availability
    	// If type == '1': increment book availability
    	
    	int currCount = getBookAvailability(bookid);
    	String sql = "UPDATE books SET count = ?"
    			+ " WHERE id = ?;";
    	
    	try (Connection conn = connect();
    		 PreparedStatement pstmt = conn.prepareStatement(sql)) {
    		if (type == '0') {
    			pstmt.setInt(1, currCount - 1);
    			
    			if (currCount - 1 == 0) {
    				changeBookStatus(bookid, "Unavailable");
    			}
    		} else {
    			pstmt.setInt(1, currCount + 1);
    			
    			if (currCount + 1 == 0) {
    				changeBookStatus(bookid, "Available");
    			}
    		}
    		pstmt.setInt(2,  bookid);
   	        
    		pstmt.executeUpdate();
   	    } catch (SQLException e) {
   	        e.printStackTrace();
   	    }
    }
    
    
    public static BookObject searchBookByID(int bookid) {
    	BookObject book = null;
	    String sql = "SELECT * FROM book WHERE id = ?";

	    try (Connection conn = connect();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setInt(1, bookid);
	        ResultSet rs = pstmt.executeQuery();

	        book = bookDataList(rs);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return book;
	}
    
    
    // Partially matches keyword entered into the search bar.
    // Also considers the genre selected. 
    // Pressing the search button calls this and returns the whole list of books.
    public static ArrayList<BookObject> bookSearch(String keyword, String genre) {
    	ArrayList<BookObject> bookList = new ArrayList<>();
	    String sql;
	    if (genre.isEmpty()) {
	    	sql = "SELECT * FROM books"
	    			+ " WHERE title LIKE ?;";
	    } else {
	    	sql = "SELECT * FROM books"
	    			+ " WHERE genre = ?"
	    			+ " AND title LIKE ?;";
	    }

	    try (Connection conn = connect();
	         var pstmt = conn.prepareStatement(sql)) {
	        
	    	if (genre.isEmpty()) {
	    		pstmt.setString(1, '%' + keyword + '%');
	    	} else {
	    		pstmt.setString(1, genre);
	    		pstmt.setString(2, '%' + keyword + '%');
	    	}
	    	ResultSet rs = pstmt.executeQuery();
	    	
	        while (rs.next()) {
	            bookList.add(bookDataList(rs));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return bookList;
	}
}