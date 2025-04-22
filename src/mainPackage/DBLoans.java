package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBLoans {
    private static final String DB_URL = "jdbc:sqlite:db/loans.db";

    
    public static Connection connect() {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }
    
    
    public static void createTable() {
	    //issue date is date loan was given
	    String sql = """
	        CREATE TABLE IF NOT EXISTS loans (
		    	id INTEGER PRIMARY KEY AUTOINCREMENT,
			    userId INTEGER NOT NULL,
			    bookId INTEGER NOT NULL,
			    dueDate DATE NOT NULL,
			    loanDate DATE DEFAULT CURRENT_DATE, 
			    returnDate DATE,
			    status TEXT NOT NULL DEFAULT 'On Loan'  -- 'On Loan', 'Returned', 'Overdue'
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
		String sql = "Drop table if exists loans";
		
		try(Connection conn = connect();
	    		Statement stmt = conn.createStatement()) {
	    		
	    		stmt.execute(sql);
	    		System.out.println("Table 'loans' has been dropped (if it existed).");
	    		
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	}
	}
    
    
    
    public static void createLoan(int userId, int bookId, String dueDate) {
    	
    	String sql = "INSERT INTO loans (userId, bookId, dueDate, loanDate, returnDate, status )"
    			+ "VALUES (? , ? , ? , ? , ? , ?)";
    	
    	String status = "On Loan";
    	
    	try(Connection conn = connect();
	    		var pstmt = conn.prepareStatement(sql)) {
	    		pstmt.setInt(1, userId);
	    		pstmt.setInt(2, bookId);
	    		pstmt.setString(3, dueDate);
	    		//pstmt.setString(4, loanDate);
	    		//pstmt.setString(5, returnDate);
	    		pstmt.setString(6, status);
	    		
	    		pstmt.executeUpdate();
	    		System.out.println("Loan added.");
	    		
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	}
    }
    
    
    public static void deleteLoan(int userId)
    {
    	String sql = "DELETE FROM loans WHERE UserID = ?";
		
		try (Connection conn = connect();
			 var stmt = conn.prepareStatement(sql)) {
			
			stmt.setInt(1,  userId);
			
			int rowsDeleted = stmt.executeUpdate();
			
			if(rowsDeleted > 0) {
				System.out.println("Loan with User ID: " + userId + " was deleted.");
			} else {
				System.out.println("No loan with User ID: " + userId + " found.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public static void userDataList(ResultSet rs) throws SQLException {
		
		if (rs.next()) {
            int UserID = rs.getInt("userId");
            int BookID = rs.getInt("bookId");
            String dueDate = rs.getString("dueDate");
            String loanDate = rs.getString("loanDate");
            String returnDate = rs.getString("returnDate");
            String status = rs.getString("Status");

            System.out.println("Reservation found:");
            System.out.println("User ID: " + UserID);
            System.out.println("Book ID: " + BookID);
            System.out.println("Issued: " + loanDate);
            System.out.println("Due Date: " + dueDate);
            System.out.println("Returned: " + returnDate);
            System.out.println("Status: " + status);
            
        } else {
            System.out.println("No loans found.");
        }

	}
    
    
    public static void searchLoansByUserId(int userId) {
		String sql = "SELECT * FROM loans where userId = ?";
		
		try (Connection conn = connect();
		         PreparedStatement pstmt = conn.prepareStatement(sql)) {

		        pstmt.setLong(1, userId);
		        ResultSet rs = pstmt.executeQuery();

		        userDataList(rs);
		        
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }		
	}
    
    /*public static void checkOverdueLoans() { ... }
    getUserLoanHistory(int userId)
    getActiveLoans()
    getLoanByBook(int bookId)*/
    
    
    public static void showAllLoans() {
	    String sql = "SELECT * FROM loans";

	    try (Connection conn = connect();
	         var stmt = conn.createStatement();
	         var rs = stmt.executeQuery(sql)) {
	        while (rs.next()) {
	            System.out.println(rs.getInt("id") + ": " +
	                               rs.getInt("userId") + " - " +
	                               rs.getInt("bookId") + " - " +
	                               rs.getString("dueDate") + " - " +
	                               rs.getString("loanDate") + " - " +
	                               rs.getString("returnDate") + " - " + 
	                               rs.getString("status"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
    
    
    
    
    
}
    
