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
			    userId INTEGER NOT NULL,
			    bookId INTEGER NOT NULL,
			    dueDate TEXT NOT NULL,
			    loanDate TEXT NOT NULL,
			    returnDate TEXT,
			    status TEXT NOT NULL DEFAULT 'On Loan',  -- 'On Loan', 'Returned', 'Overdue'
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
	    		
	    		// Decrease book availability
	    		//DBBooks.changeBookAvailability(bookId, '0');
	    		System.out.println(CurrentUser.get().getUsername() + " loaned book.");
	    		
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
    
    
    // Admin function: person brings book back to counter.
    // Admin clicks on button or enters fields which calls this.
    public static void returnBook(int userId, int bookId) {
    	String sql = "UPDATE loans SET status = 'Returned' "
    			+ "AND SET returnDate = ? "
    			+ "WHERE userId = ? AND bookId = ?;";
    	
    	try (Connection conn = connect();
   		     PreparedStatement pstmt = conn.prepareStatement(sql)) {
    			
    			pstmt.setString(1,  LocalDate.now().toString());
   		        pstmt.setInt(2, userId);
   		        pstmt.setInt(3, bookId);
   		        pstmt.executeUpdate();
   		        
   		        // Increase book availability
   		        //DBBooks.changeBookAvailability(bookId, '1');
   		} catch (SQLException e) {
   			e.printStackTrace();
   		}
    }
    
    
    // Brings up all of a person's loans. Can be used for loan history.
    public static ArrayList<LoanObject> searchLoansByUserId(int userId) {
    	ArrayList<LoanObject> loans = new ArrayList<>();
		String sql = "SELECT * FROM loans where userId = ?;";
		
		try (Connection conn = connect();
		     PreparedStatement pstmt = conn.prepareStatement(sql)) {

		        pstmt.setInt(1, userId);
		        ResultSet rs = pstmt.executeQuery();
		        
		        while (rs.next()) {
		        	loans.add(loanDataList(rs));
		        }
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}

    	return loans;
	}
    
    
    public static ArrayList<LoanObject> showAllLoans() {
    	ArrayList<LoanObject> loanList = new ArrayList<>();
	    String sql = "SELECT * FROM loans;";

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
    
    
    // Call this at the start of the program
    public static void checkForOverdueLoans() {
    	LocalDate todayDate = LocalDate.now();
    	
    	String sql = "UPDATE loans SET status = 'Overdue' "
    			+ "WHERE userId = ?;";
    	
    	ArrayList<LoanObject> loans = showAllLoans();
    	for (int l = 0; l < loans.size(); l++ ) {
    		LoanObject loan = loans.get(l);
    		if (loan != null && todayDate.isAfter(LocalDate.parse(loan.getDueDate()))) {
    			try (Connection conn = connect();
			         var pstmt = conn.prepareStatement(sql)) {
			         
    				int userId = Integer.parseInt(loan.getUserId());
    				pstmt.setInt(1, userId);
    				pstmt.executeUpdate();
    				
    				// Send email notification
    				int bookId = Integer.parseInt(loan.getBookId());
    				String email = DBUserMethods.searchUserByID(userId).getEmail();
    				String bookTitle = DBBooks.searchBookByID(bookId).getTitle();
    				String subject = "[Echo Library] Your loan is now due";
    				String message = "Your loan of " + bookTitle + " " + bookId + " is now due. "
    						+ "Fees may be incurred following long overdue periods.";
    				EmailSender emailSend = new EmailSender(email, subject, message);
    				emailSend.send();
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
    		}
    	}
    }
}