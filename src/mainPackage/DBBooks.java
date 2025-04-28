package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBBooks {
    private static final String DB_URL = "jdbc:sqlite:db/books.db";

    
    private static Connection connect() {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }
    
    
    public static void bookDataList(ResultSet rs) throws SQLException {
 		
 		if (rs.next()) {
             String title = rs.getString("title");
             String author = rs.getString("author");
             String genre = rs.getString("genre");
             String shelfLocation = rs.getString("shelfLocation");
             int ISBN = rs.getInt("ISBN");
             String status = rs.getString("status");
            
 
             System.out.println("");
             System.out.println("Title: " + title);
             System.out.println("Author: " + author);
             System.out.println("Genre: " + genre);
             System.out.println("Shelf Location: " + shelfLocation);
             System.out.println("ISBN: " + ISBN);
             System.out.println("Status: " + status);
             System.out.println();
         } else {
             System.out.println("No book found with that ID.");
         }
 
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
	            amount INTEGER NOT NULL,
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
    		String ISBN, String shelfLocation, String releaseDate, String status, int amount) {
	    String sql = "INSERT INTO books(title, author, genre, publisher, ISBN, shelfLocation, "
	    		+ "releaseDate, amount, status) "
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
	        pstmt.setInt(8, amount);
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
    
    public static boolean searchBook(String search)
    {
    	String sql = "SELECT * FROM books WHERE books = ?";

	    try (Connection conn = connect();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setString(1, search);
	        
	        ResultSet rs = pstmt.executeQuery();
	        return rs.next();
	        
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
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
	    String sql = "SELECT * FROM books WHERE id = ?";

	    try (Connection conn = connect();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setInt(1, bookid);
	        ResultSet rs = pstmt.executeQuery();
	        System.out.println("Book Found:");
	        bookDataList(rs);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return book;
	}
    
    public static void listAllBooks() {
    	 String sql = "SELECT * FROM books";

 	    try (Connection conn = connect();
 	        var stmt = conn.createStatement();
 	        var rs = stmt.executeQuery(sql)) {
 	    	
 	        while (rs.next()) {
 	        	bookDataList(rs);
 	        }
 	    } catch (SQLException e) {
 	        e.printStackTrace();
 	    }
 	    
    }
    
    public static void showAllBooks() {
 	    String sql = "SELECT * FROM books";
 
 	    try (Connection conn = connect();
 	         var stmt = conn.createStatement();
 	         var rs = stmt.executeQuery(sql)) {
 	        while (rs.next()) {
 	            System.out.println(rs.getInt("id") + ": " +
 	                               rs.getString("title") + " - " +
 	                               rs.getString("author") + " - " +
 	                               rs.getString("genre") + " - " +
 	                               rs.getString("publisher") + " - " +
 	                               rs.getString("ISBN") + " - " +
 	                               rs.getString("shelfLocation") + " - " +
 	                               rs.getString("amount") + " - " +
 	                               rs.getString("status"));
 	        }
 	    } catch (SQLException e) {
 	        e.printStackTrace();
 	    }
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
	            //bookList.add(bookDataList(rs));
	        	bookDataList(rs);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return bookList;
	}
}