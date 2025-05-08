package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.time.LocalDate;

public class DBReservations {
    private static final String DB_URL = "jdbc:sqlite:db/echo.db";
    
    
    private static Connection connect() {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }

    
    private static ReservationObject reservationDataList(ResultSet rs) throws SQLException {
		ReservationObject res = null;
		if (rs.next()) {
			int ID = rs.getInt("id");
	        int userId = rs.getInt("userId");
	        int bookId = rs.getInt("bookId");
	        String resDate = rs.getString("resDate");
	        String status = rs.getString("status");
	        
	        res = new ReservationObject(ID, userId, bookId, resDate, status);
	    } else {
	        System.out.println("No reservation found.");
	    }
		return res;
	}
    

	public static void createTable() {
	    String sql = """
	        CREATE TABLE IF NOT EXISTS reservations (
	            userId INTEGER NOT NULL,
	            bookId INTEGER NOT NULL,
	            resDate TEXT NOT NULL,
	            status TEXT NOT NULL DEFAULT 'Active', -- Active, Cancelled, Completed
	            PRIMARY KEY (userId, bookId)
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
		String sql = "Drop table if exists reservations;";
		
		try(Connection conn = connect();
	    		Statement stmt = conn.createStatement()) {
	    		
	    		stmt.execute(sql);
	    		System.out.println("Table 'reservations' has been dropped (if it existed).");
	    		
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	}
	}
	
	
	// Use with "DatePicker" from JavaFX, converting the Date object to String using toString().
	public static void addReservations(int userId, int bookId, String resDate, String status) {
		String sql = "INSERT INTO reservations (userId, bookId, resDate, status) " 
				+ "VALUES(? , ? , ? , ?);";
		
		try (Connection conn = connect();
	        var pstmt = conn.prepareStatement(sql)) {
		        pstmt.setInt(1, userId);
		        pstmt.setInt(2, bookId);
		        pstmt.setString(3, resDate);
		        pstmt.setString(4, status);
		
		        pstmt.executeUpdate();
		
		        // Decrease book availability due to reservation
		        //DBBooks.changeBookAvailability(bookId, '0'); // decrement book availability
		        
		        // Send email notification to user
		        UserObject user = DBUserMethods.searchUserByID(userId);
		        String subject = "[Echo Library] Reservation Details";
		        String message = "You have a reservation for: \n" + resDate;
		        EmailSender sendEmail = new EmailSender(user.getEmail(), subject, message);
		        sendEmail.send();
		        
		        System.out.println(CurrentUser.get().getUsername() + " reserved book.");
		    } catch (SQLException e) {
		    	e.printStackTrace();
	    }
	}
	
	
	public static void deleteReservationByUserId(Integer id) {
		String sql = "DELETE FROM reservations WHERE userId = ?;";
		
		try (Connection conn = connect();
			 var pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setInt(1,  id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				deleteReservationByBookId(rs.getInt("bookId"), id);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void deleteReservationByBookId(Integer bookId, Integer userId) {
		String sql = "DELETE FROM reservations WHERE bookId = ?"
				+ "AND userId = ?;";
		
		try (Connection conn = connect();
			 var pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setInt(1, bookId);
			pstmt.setInt(2, userId);
			
			int rowsDeleted = pstmt.executeUpdate();
			
			if(rowsDeleted > 0) {
		        //DBBooks.changeBookAvailability(bookId, '1'); // increment book availability
				System.out.println("Reservation with Book ID: " + bookId + " was deleted.");
			} else {
				System.out.println("No reservations with Book ID: " + bookId + " found.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static ArrayList<ReservationObject> searchReservationByUserId(int userId) {
		ArrayList<ReservationObject> resList = new ArrayList<>();
		String sql = "SELECT * FROM reservations where userId = ?;";
		
		try (Connection conn = connect();
		         PreparedStatement pstmt = conn.prepareStatement(sql)) {

		        pstmt.setInt(1, userId);
		        ResultSet rs = pstmt.executeQuery();
		        
		        while (rs.next()) {
		        	resList.add(reservationDataList(rs));
		        }
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resList;
	}
	
	
	public static ArrayList<ReservationObject> searchReservationByBookId(int bookId) {
		ArrayList<ReservationObject> resList = new ArrayList<>();
		String sql = "SELECT * FROM reservations where bookId = ?;";
		
		try (Connection conn = connect();
		         PreparedStatement pstmt = conn.prepareStatement(sql)) {

		        pstmt.setInt(1, bookId);
		        ResultSet rs = pstmt.executeQuery();
		        while (rs.next()) {
		        	resList.add(reservationDataList(rs));
		        }
		        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return resList;
	}
	
	// Admins will use this to update reservations together with "searchReservationByUserId" method.
	// Also called from within the "updateAllReservations" method.
	public static void updateReservationStatus(int id, String status) {
		String sql = "UPDATE reservations SET status = ? "
				+ "WHERE id = ?;";
		
		try(Connection conn = connect();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, status);
			pstmt.setInt(2, id);
			
			pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	
	// Call this at the start of the program. 
	// Updates every reservation entry and sets expired entries to "Completed".
	public static void updateAllReservations() {
		LocalDate todayDate = LocalDate.now();
		
		String sql = "Select * FROM reservations "
				+ "WHERE status = 'Active';";
		
		try(Connection conn = connect();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				LocalDate resDate = LocalDate.parse(rs.getString("resDate"));
				resDate = resDate.plusDays(1);
				if (todayDate.isAfter(resDate)) {
			        //DBBooks.changeBookAvailability(rs.getInt("id"), '1'); // increment book availability
			        
			        updateReservationStatus(rs.getInt("id"), "Completed");
				}
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	
	public static ArrayList<ReservationObject> showAllReservations() {
		ArrayList<ReservationObject> resList = new ArrayList<>();
	    String sql = "SELECT * FROM reservations;";

	    try (Connection conn = connect();
	         var stmt = conn.createStatement();
	         var rs = stmt.executeQuery(sql)) {
	        while (rs.next()) {
	            resList.add(reservationDataList(rs));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return resList;
	}
}