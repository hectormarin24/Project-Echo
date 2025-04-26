package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.time.LocalDate;
import java.util.ArrayList;

public class DBLoans {
    private static final String DB_URL = "jdbc:sqlite:db/echo.db";

    
    private static Connection connect() {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }
    
    
    private static LoanObject loanDataList(ResultSet rs) throws SQLException {
		LoanObject loan = null;
		if (rs.next()) {
			int ID = rs.getInt("id");
            int UserID = rs.getInt("userId");
            int BookID = rs.getInt("bookId");
            String dueDate = rs.getString("dueDate");
            String loanDate = rs.getString("loanDate");
            String returnDate = rs.getString("returnDate");
            String status = rs.getString("Status");

            loan = new LoanObject(ID, UserID, BookID, dueDate, loanDate, returnDate, status);
        } else {
            System.out.println("No loans found.");
        }
		return loan;
	}
    
    
    public static void createTable() {
	    //issue date is date loan was given
	    String sql = """
	        CREATE TABLE IF NOT EXISTS loans (
		    	id INTEGER PRIMARY KEY AUTOINCREMENT,
			    userId INTEGER NOT NULL,
			    bookId INTEGER NOT NULL,
			    dueDate TEXT NOT NULL,
			    loanDate TEXT NOT NULL,
			    returnDate TEXT,
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
    
    
    public static void createLoan(int userId, int bookId) {
    	
    	String sql = "INSERT INTO loans (userId, bookId, dueDate, loanDate, returnDate, status)"
    			+ "VALUES (? , ? , ? , ? , ? , ?)";
    	
    	String status = "On Loan";
    	String loanDate = LocalDate.now().toString();
    	String dueDate = LocalDate.parse(loanDate).plusDays(21).toString();
    	
    	try(Connection conn = connect();
	    		var pstmt = conn.prepareStatement(sql)) {
	    		pstmt.setInt(1, userId);
	    		pstmt.setInt(2, bookId);
	    		pstmt.setString(3, dueDate);
	    		pstmt.setString(4, loanDate);
	    		pstmt.setString(5, null);
	    		pstmt.setString(6, status);
	    		
	    		pstmt.executeUpdate();
	    		System.out.println("Loan added.");
	    		
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	}
    }
    
    
    public static void deleteLoan(int userId) {
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
    
    
    public static LoanObject searchLoansByUserId(int userId) {
    	LoanObject loan = null;
		String sql = "SELECT * FROM loans where userId = ?";
		
		try (Connection conn = connect();
		     PreparedStatement pstmt = conn.prepareStatement(sql)) {

		        pstmt.setInt(1, userId);
		        ResultSet rs = pstmt.executeQuery();

		        loan = loanDataList(rs);
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}

    	return loan;
	}
    
    /*public static void checkOverdueLoans() { ... }
    getUserLoanHistory(int userId)
    getActiveLoans()
    getLoanByBook(int bookId)*/
    
    
    public static ArrayList<LoanObject> showAllLoans() {
    	ArrayList<LoanObject> loanList = new ArrayList<>();
	    String sql = "SELECT * FROM loans";

	    try (Connection conn = connect();
	         var stmt = conn.createStatement();
	         var rs = stmt.executeQuery(sql)) {
	        while (rs.next()) {
	            loanList.add(loanDataList(rs));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return loanList;
    }
}