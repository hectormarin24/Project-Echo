package mainPackage;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class DBUtil {
//    private static final String DB_URL = "jdbc:sqlite:db/echo.db";
//
//    
//    public static Connection connect() {
//        try {
//            return DriverManager.getConnection(DB_URL);
//        } catch (SQLException e) {
//            System.out.println("Connection failed: " + e.getMessage());
//            return null;
//        }
//    }
//    
//    
//    public static void createTable() {
//	    String sql = """
//	        CREATE TABLE IF NOT EXISTS users (
//	            id INTEGER PRIMARY KEY AUTOINCREMENT,
//	            Fname TEXT NOT NULL,
//	            Lname TEXT NOT NULL,
//	            Minitial TEXT,
//	            email TEXT UNIQUE NOT NULL,
//	            number INTEGER NOT NULL,
//	            address TEXT NOT NULL,
//	            password TEXT UNIQUE NOT NULL,
//	            username TEXT UNIQUE NOT NULL,
//	            dob TEXT,
//	            isMember Text,
//	            dues INTEGER
//	        );
//	        """;
//	
//	    try (Connection conn = connect();
//	         var stmt = conn.createStatement()) {
//	        stmt.execute(sql);
//	        System.out.println("Table created or already exists.");
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	}
//    
//    
//    
//    public static void deleteTable() {
//    	String sql = "DROP TABLE IF EXISTS users";
//    	
//    	try(Connection conn = connect();
//    		Statement stmt = conn.createStatement()) {
//    		
//    		stmt.execute(sql);
//    		System.out.println("Table 'users' has been dropped (if it existed).");
//    		
//    	} catch (SQLException e) {
//    		e.printStackTrace();
//    	}
//    }
//	
//    
//	
//	public static void insertUser(String Fname, String Lname, String Minitial, String email, String number, String address, String password, String username, String dob ) {
//	    String sql = "INSERT INTO users(Fname, Lname, Minitial, email,"
//	    		+ " number, address, password, username, dob) "
//	    		+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
//	
//	    try (Connection conn = connect();
//	        var pstmt = conn.prepareStatement(sql)) {
//	        pstmt.setString(1, Fname);
//	        pstmt.setString(2, Lname);
//	        pstmt.setString(3, Minitial);
//	        pstmt.setString(4, email);
//	        pstmt.setString(5, number);
//	        pstmt.setString(6, address);
//	        pstmt.setString(7, password);
//	        pstmt.setString(8, username);
//	        pstmt.setString(9, dob);
//
//	        pstmt.executeUpdate();
//	        System.out.println("User added.");
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	}
//	
//	
//	
//	public static void deleteUser(Integer id) {
//		String sql = "DELETE FROM users WHERE id = ?;";
//		
//		try (Connection conn = connect();
//			 var stmt = conn.prepareStatement(sql)) {
//			
//			stmt.setInt(1,  id);
//			
//			int rowsDeleted = stmt.executeUpdate();
//			
//			if(rowsDeleted > 0) {
//				System.out.println("User with ID: " + id + " was deleted.");
//			} else {
//				System.out.println("No user with ID: " + id + " found.");
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//	
//	public static void userDataList(ResultSet rs) throws SQLException {
//		
//		if (rs.next()) {
//            String Fname = rs.getString("Fname");
//            String Lname = rs.getString("Lname");
//            String Minitial = rs.getString("Minitial");
//            String email = rs.getString("email");
//            String number = rs.getString("number");
//            String address = rs.getString("address");
//            String password = rs.getString("password");
//            String username = rs.getString("username");
//            String dob = rs.getString("dob");
//
//
//            System.out.println("User found:");
//            System.out.println("First Name: " + Fname);
//            System.out.println("Middle Initial: " + Minitial);
//            System.out.println("Last Name: " + Lname);
//            System.out.println("Email: " + email);
//            System.out.println("Number: " + number);
//            System.out.println("Address: " + address);
//            System.out.println("Password: " + password);
//            System.out.println("Username: " + username);
//            System.out.println("Date of Birth: " + dob);
//        } else {
//            System.out.println("No user found with that email.");
//        }
//
//	}
//	
//	
//	
//	public static void searchUserByID(int userid) {
//	    String sql = "SELECT * FROM users WHERE id = ?";
//
//	    try (Connection conn = DBUtil.connect();
//	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//	        pstmt.setLong(1, userid);
//	        ResultSet rs = pstmt.executeQuery();
//
//	        userDataList(rs);
//	        
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	}
//	
//	
//	public static void searchUserByName(String firstname, String lastname, String middleInitial) {
//		String Fnamesql = "SELECT * FROM users where Fname = ?";
//		String Lnamesql = "SELECT * FROM users where Lname = ?";
//		String Minitial = "SELECT * FROM users where Minitial = ?";
//		
//		try(Connection conn = DBUtil.connect();
//			PreparedStatement pstmt = conn.prepareStatement(Fnamesql)) {
//			
//			pstmt.setString(1, firstname);			
//			
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void searchUserByName(String name) {
//		String Fnamesql = "SELECT * FROM users where Fname = ?";
//		String Lnamesql = "SELECT * FROM users where Lname = ?";
//		
//		try(Connection conn = DBUtil.connect();
//				PreparedStatement pstmt = conn.prepareStatement(Fnamesql)) {
//				
//				pstmt.setString(1, name);			
//				
//			} catch(SQLException e) {
//				e.printStackTrace();
//			}
//		
//	}
//	
//	
//
//	
//	
//	public static void showAllUsers() {
//	    String sql = "SELECT * FROM users";
//
//	    try (Connection conn = connect();
//	         var stmt = conn.createStatement();
//	         var rs = stmt.executeQuery(sql)) {
//	        while (rs.next()) {
//	            System.out.println(rs.getInt("id") + ": " +
//	                               rs.getString("Fname") + " - " +
//	                               rs.getString("Lname") + " - " +
//	                               rs.getString("Minitial") + " - " +
//	                               rs.getString("email") + " - " +
//	                               rs.getString("number") + " - " +
//	                               rs.getString("address") + " - " +
//	                               rs.getString("password") + " - " +
//	                               rs.getString("username") + " - " +
//	                               rs.getString("dob"));
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	}
//
//}
