package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBWishlist {
	private static final String DB_URL = "jdbc:sqlite:db/echo.db";
    
    
    private static Connection connect() {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }
	
	public static void createTable() {
		String sql = "CREATE TABLE IF NOT EXISTS wishlists ("
	            + "	userID INTEGER,"
	            + "	bookID INTEGER,"
	            + " PRIMARY KEY (userID, bookID)"
	            + ");";
		
		try (Connection conn = connect();
	         Statement stmt = conn.createStatement()) {
	            stmt.execute(sql);
	            System.out.println("Table created or already exists.");
	    } catch (SQLException e) {
	            System.out.println(e.getMessage());
	    }
	}
	
	public static void deleteTable() {
    	String sql = "DROP TABLE IF EXISTS wishlists";
    	
    	try(Connection conn = connect();
    		Statement stmt = conn.createStatement()) {
    		
    		stmt.execute(sql);
    		System.out.println("Table 'wishlists' has been dropped (if it existed).");
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
	
	// Find all books that are connected to the user account within the database 
	// and return the data via an ArrayList. This data will be loaded by the front end.
	public static ArrayList<Integer> getWishlistedBookIDs(int userID) {
		ArrayList<Integer> bookIDs = new ArrayList<>();
		String sql = "SELECT bookID"
				+ " FROM wishlists"
                + " WHERE userID = ?;";
		
		try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setInt(1, userID);
				
				ResultSet rs = pstmt.executeQuery();

            	while (rs.next()) {
	                bookIDs.add(rs.getInt("bookID"));
	            }
	    } catch (SQLException e) {
	            System.err.println(e.getMessage());
	    }
		return bookIDs;
	}
	
	// Check if the user already wish listed a book.
	// Call this together with "checkAvailability" when loading the wish list window/tab.
	// Return value: true = the user CAN wish list the book since they haven't wish listed it yet.
	// Return value: false = the user CANNOT wish list the book since they have wish listed it already.
	public static boolean canWishlist(int userID, int bookID) {
		String sql = "SELECT userID, bookID"
				+ " FROM wishlists"
				+ " WHERE userID = ?"
				+ " AND bookID = ?;";
		
		try (Connection conn = connect();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	            pstmt.setInt(1, userID);
	            pstmt.setInt(2, bookID);
	            
	            ResultSet rs = pstmt.executeQuery();
	            if (rs.next()) {
	            	// Already has a wish list for this book.
	            	return false;
	            }

	    } catch (SQLException e) {
	            System.err.println(e.getMessage());
	    }
		return true;
	}
	
	// A user has just clicked on "Wish List" after searching for a book and it was not available.
	// Front end calls this function providing the userID and bookID.
	// Note: front end should only show the "Wish List" button when physical availability is zero!
	// Use the "checkAvailability" function from the BookDatabase class.
	public static void addWishlist(int userID, int bookID) {
		String sql = "INSERT INTO wishlists"
				+ " (userID, bookID)"
				+ " VALUES"
				+ " (?, ?);";
		
		try (Connection conn = connect();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	            pstmt.setInt(1, userID);
	            pstmt.setInt(2, bookID);
	            
	            pstmt.executeUpdate();

	    } catch (SQLException e) {
	            System.err.println(e.getMessage());
	    }
		System.out.println(CurrentUser.get().getUsername() + " wishlisted book");
	}
	
	// A user has just clicked on the "Remove" button on the wish list page on the book they want to remove.
	// The front end should call this function, providing the user's ID and the book's ID.
	public static void removeWishlist(int userID, int bookID) {	
		String sql = "DELETE FROM wishlists"
				+ " WHERE userID = ?"
				+ " AND bookID = ?;";
		
		try (Connection conn = connect();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	            pstmt.setInt(1, userID);
	            pstmt.setInt(2, bookID);
	            
	            pstmt.executeUpdate();

	    } catch (SQLException e) {
	            System.err.println(e.getMessage());
	    }
	}
	
	// Call at the start of the program.
	public static void pingWishlists() {
		String sql = "SELECT * FROM wishlists;";
		
		try (Connection conn = connect();
	         Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
            	BookObject book = DBBooks.searchBookByID(rs.getInt("bookID"));
            	if (book != null && book.getStatus() == "Available") {
            		UserObject user = DBUserMethods.searchUserByID(rs.getInt("userID"));
                	String email = user.getEmail();
                	String bookTitle = book.getTitle();
                	String subject = "[Echo Library] " + bookTitle + " is now available";
                	String message = bookTitle + " is now available to reserve or loan from the library.";
                	EmailSender emailSend = new EmailSender(email, subject, message);
                	emailSend.send();
            	}
            }

	    } catch (SQLException e) {
	            System.err.println(e.getMessage());
	    }
	}
}
