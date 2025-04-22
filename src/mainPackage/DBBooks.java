package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBBooks {
    private static final String DB_URL = "jdbc:sqlite:db/books.db";

    
    public static Connection connect() {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }
    
    
    public static void createTable() {
	    String sql = """
	        CREATE TABLE IF NOT EXISTS books (
	            id INTEGER PRIMARY KEY AUTOINCREMENT,
	            Title TEXT NOT NULL,
	            Author TEXT NOT NULL,
	            Genre TEXT NOT NULL,
	            ShelfLocation TEXT NOT NULL,
	            ISBN INTEGER NOT NULL,
	            status TEXT NOT NULL
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
    
    
    public static void insertBook(String title, String author, String genre, String shelfLocation, int ISBN, String status) {
	    String sql = "INSERT INTO users(title, author, genre, shelfLocation"
	    		+ " ISBN, status) "
	    		+ "VALUES(?, ?, ?, ?, ?, ?)";
	
	    try (Connection conn = connect();
	        var pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, title);
	        pstmt.setString(2, author);
	        pstmt.setString(3, genre);
	        pstmt.setString(4, shelfLocation);
	        pstmt.setInt(5, ISBN);
	        pstmt.setString(6, status);
	       
	        pstmt.executeUpdate();
	        System.out.println("Book added.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
    
    
    
    public static void deleteBook(int id) {
		String sql = "DELETE FROM book WHERE id = ?;";
		
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
    
    public static void bookDataList(ResultSet rs) throws SQLException {
		
		if (rs.next()) {
            String title = rs.getString("title");
            String author = rs.getString("author");
            String genre = rs.getString("genre");
            String shelfLocation = rs.getString("shelfLocation");
            int ISBN = rs.getInt("ISBN");
            String status = rs.getString("status");
           

            System.out.println("User found:");
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Genre: " + genre);
            System.out.println("Shelf Location: " + shelfLocation);
            System.out.println("ISBN: " + ISBN);
            System.out.println("Status: " + status);
        } else {
            System.out.println("No book found with that ID.");
        }

	}
    
    
    public static void searchBookByID(int bookid) {
	    String sql = "SELECT * FROM book WHERE id = ?";

	    try (Connection conn = DBUserMethods.connect();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setLong(1, bookid);
	        ResultSet rs = pstmt.executeQuery();

	        bookDataList(rs);
	        
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
	                               rs.getString("shelfLocation") + " - " +
	                               rs.getString("ISBN") + " - " +
	                               rs.getString("status"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
    
    
    
    
}