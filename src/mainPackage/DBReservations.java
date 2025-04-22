package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBReservations {
    private static final String DB_URL = "jdbc:sqlite:db/reservations.db";

    
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
	        CREATE TABLE IF NOT EXISTS reservations (
	            id INTEGER PRIMARY KEY AUTOINCREMENT,
	            UserID INTEGER UNIQUE NOT NULL,
	            BookID INTEGER UNIQUE NOT NULL,
	            ResDate TEXT NOT NULL,
	            Status TEXT NOT NULL DEFAULT 'Active' -- Active, Cancelled, Completed
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
		String sql = "Drop table if exists reservations";
		
		try(Connection conn = connect();
	    		Statement stmt = conn.createStatement()) {
	    		
	    		stmt.execute(sql);
	    		System.out.println("Table 'reservations' has been dropped (if it existed).");
	    		
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	}
	}
	
	
	
	public static void addReservations(int userID, int bookID, String ResDate, String status) {
		String sql = "INSERT INTO reservations (UserID, bookID, ResDate, Status)" 
				+ "VALUES(? , ? , ? , ?)";
		
		
		
		try (Connection conn = connect();
		        var pstmt = conn.prepareStatement(sql)) {
		        pstmt.setLong(1, userID);
		        pstmt.setLong(2, bookID);
		        pstmt.setString(3, ResDate);
		        pstmt.setString(4, status);
		       

		        pstmt.executeUpdate();
		        System.out.println("Reservation added.");
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	}
	
	
	
	public static void deleteReservationByUserId(Integer id) {
		String sql = "DELETE FROM reservations WHERE UserID = ?";
		
		try (Connection conn = connect();
			 var stmt = conn.prepareStatement(sql)) {
			
			stmt.setInt(1,  id);
			
			int rowsDeleted = stmt.executeUpdate();
			
			if(rowsDeleted > 0) {
				System.out.println("Reservation with User ID: " + id + " was deleted.");
			} else {
				System.out.println("No reservations with User ID: " + id + " found.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void deleteReservationByBookId(Integer id) {
		String sql = "DELETE FROM reservations where BookID = ?";
		
		try (Connection conn = connect();
			 var stmt = conn.prepareStatement(sql)) {
			
			stmt.setInt(1,  id);
			
			int rowsDeleted = stmt.executeUpdate();
			
			if(rowsDeleted > 0) {
				System.out.println("Reservation with Book ID: " + id + " was deleted.");
			} else {
				System.out.println("No reservations with Book ID: " + id + " found.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public static void userDataList(ResultSet rs) throws SQLException {
			
			if (rs.next()) {
	            int UserID = rs.getInt("UserID");
	            int BookID = rs.getInt("BookID");
	            String ResDate = rs.getString("ResDate");
	            String status = rs.getString("status");
	
	
	            System.out.println("Reservation found:");
	            System.out.println("User ID: " + UserID);
	            System.out.println("Book ID: " + BookID);
	            System.out.println("Reservation Date: " + ResDate);
	            System.out.println("Status: " + status);
	        } else {
	            System.out.println("No reservation found.");
	        }
	
		}
	
	
	
	public static void searchReservationByUserId(int userId) {
		String sql = "SELECT * FROM reservations where UserID = ?";
		
		try (Connection conn = connect();
		         PreparedStatement pstmt = conn.prepareStatement(sql)) {

		        pstmt.setLong(1, userId);
		        ResultSet rs = pstmt.executeQuery();

		        userDataList(rs);
		        
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }		
	}
	
	public static void searchReservationByBookId(int BookId) {
		String sql = "SELECT * FROM reservations where BookID = ?";
		
		try (Connection conn = connect();
		         PreparedStatement pstmt = conn.prepareStatement(sql)) {

		        pstmt.setLong(1, BookId);
		        ResultSet rs = pstmt.executeQuery();

		        userDataList(rs);
		        
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }		
	}
	
	/*public static List<Reservation> getUserReservations(int userId) { ... }
	public static void cancelReservation(int reservationId) { ... }
	public static void completeReservation(int reservationId) { ... }
	public static List<Reservation> getAllActiveReservations() { ... }
	*/


	
	public static void showAllReservations() {
	    String sql = "SELECT * FROM reservations";

	    try (Connection conn = connect();
	         var stmt = conn.createStatement();
	         var rs = stmt.executeQuery(sql)) {
	        while (rs.next()) {
	            System.out.println(rs.getInt("id") + ": " +
	                               rs.getInt("UserID") + " - " +
	                               rs.getInt("BookID") + " - " +
	                               rs.getString("ResDate") + " - " +
	                               rs.getString("Status"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}