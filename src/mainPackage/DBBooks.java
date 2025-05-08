package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;

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
    
    
    public static BookObject bookDataList(ResultSet rs) throws SQLException {
 		BookObject book = null;
		 int id = rs.getInt("id");
         String title = rs.getString("title");
         String author = rs.getString("author");
         String genre = rs.getString("genre");
         String publisher = rs.getString("publisher");
         String ISBN = rs.getString("ISBN");
         String shelfLocation = rs.getString("shelfLocation");
         String releaseDate = rs.getString("releaseDate");
         String status = rs.getString("status");
            
 
             System.out.println("");
         System.out.println("Title: " + title);
         System.out.println("Author: " + author);
         System.out.println("Genre: " + genre);
         System.out.println("Shelf Location: " + shelfLocation);
         System.out.println("ISBN: " + ISBN);
         System.out.println("Status: " + status);
         System.out.println();
         
         book = new BookObject(id, title, author, genre, publisher, ISBN, shelfLocation, releaseDate, status);
 		return book;
 	}

    public static BookObject getBookDetails(String title) {
        BookObject book = null;
        try {
            Connection conn = connect();
            String sql = "SELECT * FROM books WHERE title = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                book = new BookObject(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("genre"),
                    rs.getString("publisher"),
                    rs.getString("ISBN"),
                    rs.getString("shelfLocation"),
                    rs.getString("releaseDate"),
                    rs.getString("status")
                );
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
	            ISBN TEXT UNIQUE NOT NULL,
	            shelfLocation TEXT NOT NULL,
	            releaseDate TEXT NOT NULL,
	            status TEXT NOT NULL DEFAULT 'Available' -- Unavailable, Available
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
    		String ISBN, String shelfLocation, String releaseDate) {
	    String sql = "INSERT INTO books(title, author, genre, publisher, ISBN, shelfLocation, "
	    		+ "releaseDate) "
	    		+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
	
	    try (Connection conn = connect();
	        var pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, title);
	        pstmt.setString(2, author);
	        pstmt.setString(3, genre);
	        pstmt.setString(4, publisher);
	        pstmt.setString(5, ISBN);
	        pstmt.setString(6, shelfLocation);
	        pstmt.setString(7, releaseDate);
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
    	String sql = "SELECT * FROM books WHERE title = ?";

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
 	                               rs.getString("status"));
 	        }
 	    } catch (SQLException e) {
 	        e.printStackTrace();
 	    }
 	}
    
    // Partially matches keyword entered into the search bar.
    // Also considers the genre selected. 
    // Pressing the search button calls this and returns the whole list of books.
    public static List<BookObject> bookSearch(String keyword, String genre) {
    	List<BookObject> bookList = new ArrayList<>();
	    String sql;
	    if (genre.isEmpty()) {
	    	sql = "SELECT * FROM books"
	    			+ " WHERE LOWER(title) LIKE LOWER(?);";
	    } else {
	    	sql = "SELECT * FROM books"
	    			+ " WHERE genre = ?"
	    			+ " AND LOWER(title) LIKE LOWER(?);";
	    }

	    try (Connection conn = connect();
	         var pstmt = conn.prepareStatement(sql)) {
	        
	    	if (genre.isEmpty()) {
	    		pstmt.setString(1, "%" + keyword + "%");
	    	} else {
	    		pstmt.setString(1, genre);
	    		pstmt.setString(2, "%" + keyword + "%");
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