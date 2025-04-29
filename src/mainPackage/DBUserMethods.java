package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBUserMethods {
	
	/*String sql = "INSERT INTO actions_log (user_id, action, timestamp) VALUES (?, ?, CURRENT_TIMESTAMP)";

	try (Connection conn = DBUserMethods.connect();
	     PreparedStatement pstmt = conn.prepareStatement(sql)) {
	
	    pstmt.setInt(1, Session.currentUser.getId()); // get user ID
	    pstmt.setString(2, "borrowed 'Moby Dick'");
	    pstmt.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	*/
    private static final String DB_URL = "jdbc:sqlite:db/echo.db";
    public static UserObject currentUser = null;
    
    private static Connection connect() {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }
    
    
    private static UserObject userDataList(ResultSet rs) throws SQLException {
		UserObject user = null;
		
		Integer id = rs.getInt("id");
        String Fname = rs.getString("Fname");
        String Lname = rs.getString("Lname");
        String Minitial = rs.getString("Minitial");
        String email = rs.getString("email");
        String number = rs.getString("number");
        String address = rs.getString("address");
        String password = rs.getString("password");
        String username = rs.getString("username");
        String dob = rs.getString("dob");
        String membershipStatus = rs.getString("membershipStatus");
        Integer dues = rs.getInt("dues");
        String type = rs.getString("type");

        pn("id " + id);
        pn("fname " +Fname);
        pn("lname " +Lname);
        pn("minit " +Minitial);
        pn("email " +email);
        pn("num " +number);
        pn("addr " +address);
        pn("username " +username);
        pn("password " + password);
        pn("dob " + dob);
        pn("Membership " + membershipStatus);
        pn("dues " + dues);
        pn("");
        pn("");
        
        user = new UserObject(id, Fname, Lname, Minitial, email, number, address, password, username, dob, dues, membershipStatus, type);


		return user;
	}
    
    
    public static void createTable() {
	    String sql = """
	        CREATE TABLE IF NOT EXISTS users (
	            id INTEGER PRIMARY KEY AUTOINCREMENT,
	            Fname TEXT NOT NULL,
	            Lname TEXT NOT NULL,
	            Minitial TEXT,
	            email TEXT UNIQUE NOT NULL,
	            number TEXT NOT NULL,
	            address TEXT NOT NULL,
	            password TEXT UNIQUE NOT NULL,
	            username TEXT UNIQUE NOT NULL,
	            dob TEXT,
	            dues INTEGER,
	            membershipStatus TEXT NOT NULL DEFAULT 'Inactive', -- Inactive, Active
	            type TEXT NOT NULL DEFAULT 'User' -- User, Admin
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
    	String sql = "DROP TABLE IF EXISTS users";
    	
    	try(Connection conn = connect();
    		Statement stmt = conn.createStatement()) {
    		
    		stmt.execute(sql);
    		System.out.println("Table 'users' has been dropped (if it existed).");
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
	
	
	public static void insertUser(String Fname, String Lname, String Minitial, String email, String number, 
			String address, String password, String username, String dob, String type) {
	    String sql = "INSERT INTO users(Fname, Lname, Minitial, email,"
	    		+ " number, address, password, username, dob, type) "
	    		+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	    try (Connection conn = connect();
	        var pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, Fname);
	        pstmt.setString(2, Lname);
	        pstmt.setString(3, Minitial);
	        pstmt.setString(4, email);
	        pstmt.setString(5, number);
	        pstmt.setString(6, address);
	        pstmt.setString(7, password);
	        pstmt.setString(8, username);
	        pstmt.setString(9, dob);
	        pstmt.setString(10, type);

	        pstmt.executeUpdate();
	        System.out.println("User added.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	
	// For developers only! Insert admin account separate from the app.
	// 
	public static void insertCustomAdmin() {
		String Fname = "admin";
		String Lname = "123";
		String Minitial = "test";
		String email = "gsnyriusbg@eniubeiugbsiugbs.com";
		String number = "null";
		String address = "null";
		String password = "qwerty";
		String username = "admin";
		String dob = "null";
		String type = "Admin";
		
		insertUser(Fname, Lname, Minitial, email, number, address, password, username, dob, type);
	}
	
	
	public static void deleteUser(Integer id) {
		String sql = "DELETE FROM users WHERE id = ?;";
		
		try (Connection conn = connect();
			 var stmt = conn.prepareStatement(sql)) {
			
			stmt.setInt(1,  id);
			
			int rowsDeleted = stmt.executeUpdate();
			
			if(rowsDeleted > 0) {
				System.out.println("User with ID: " + id + " was deleted.");
			} else {
				System.out.println("No user with ID: " + id + " found.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static UserObject searchUserByID(int userid) {
		UserObject user = null;
	    String sql = "SELECT * FROM users WHERE id = ?";

	    try (Connection conn = DBUserMethods.connect();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setInt(1, userid);
	        ResultSet rs = pstmt.executeQuery();

	        user = userDataList(rs);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return user;
	}
	
	public static boolean checkUserExist(String username, String password) {

	    String sql = "SELECT * FROM users WHERE username = ? AND password = ?";


	    try (Connection conn = DBUserMethods.connect();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setString(1, username);
	        pstmt.setString(2, password);
	        ResultSet rs = pstmt.executeQuery();

	        if(rs.next()) {
	        	loadUser(rs);
	        	return true;
	        }
	        return rs.next();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return false;
	}
	
	   

	
	private static UserObject loadUser (ResultSet rs) throws SQLException {
		
		Integer id = rs.getInt("id");
        String Fname = rs.getString("Fname");
        String Lname = rs.getString("Lname");
        String Minitial = rs.getString("Minitial");
        String email = rs.getString("email");
        String number = rs.getString("number");
        String address = rs.getString("address");
        String password = rs.getString("password");
        String username = rs.getString("username");
        String dob = rs.getString("dob");
        Integer dues = rs.getInt("dues");
        String membershipStatus = rs.getString("membershipStatus");
        String type = rs.getString("type");

        pn("id " + id);
        pn("fname " +Fname);
        pn("lname " +Lname);
        pn("minit " +Minitial);
        pn("email " +email);
        pn("num " +number);
        pn("addr " +address);
        pn("username " +username);
        pn("password " + password);
        pn("dob" +dob);
        pn("dues " +dues);
        pn("");
        pn("");
        
        currentUser = new UserObject(id, Fname, Lname, Minitial, email, number, address, password, username, dob, dues, membershipStatus, type);
        
        
		return currentUser;
	}
	
	/*public static UserObject searchUserByName(String firstname, String lastname, String middleInitial) {

	}*/

	public static UserObject searchUserByUsername(String username) {

		UserObject user = null;
		String sql = "SELECT * FROM users "
				+ "WHERE username = ?;";
		
		try(Connection conn = DBUserMethods.connect();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, username);
			
			ResultSet rs = pstmt.executeQuery();
			user = userDataList(rs);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public static Integer searchUserForId(String username, String password)
	{
		String sql = "SELECT id FROM users "
				+ "WHERE username = ? AND password = ?;";
		
		try(Connection conn = DBUserMethods.connect();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
	            int id = rs.getInt("id");
	            return id;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void chargeUser(int userId, int dues) {
		String sql = "UPDATE users SET dues = dues + ? "
				+ "WHERE id = ?;";
		
		try (Connection conn = connect();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setInt(1, dues);
			pstmt.setInt(2, userId);
			
			pstmt.executeUpdate();
			
			UserObject user = DBUserMethods.searchUserByID(userId);
			String email = user.getEmail();
			String name = user.getFname();
			String subject = "[Echo Library] New Fees";
			String message = "Hello " + name + ",\n\nYou have new fees of " + dues
					+ " posted to your account.";
			EmailSender emailSend = new EmailSender(email, subject, message);
			emailSend.send();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void payDues(int userId) {
		String sql = "UPDATE users SET dues = 0 "
				+ "WHERE id = ?;";
		
		try (Connection conn = connect();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setInt(1, userId);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static ArrayList<UserObject> showAllUsers() {
		ArrayList<UserObject> userList = new ArrayList<>();
	    String sql = "SELECT * FROM users";

	    try (Connection conn = connect();
	        var stmt = conn.createStatement();
	        var rs = stmt.executeQuery(sql)) {
	    	
	        while (rs.next()) {
	        	userDataList(rs);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return userList;
	}
	
	
	/* Helper method for easy printing on same line */
	public static <E> void p(E item){
		System.out.print(item + " ");
	}
	
	/* Helper method for easy printing with line return */
	public static <E> void pn(E item){
		System.out.println(item);
	}
	
	
}
