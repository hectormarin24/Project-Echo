package mainPackage;

import java.sql.*;
import java.util.*;

public class UserDao {
    public List<UserObject> getAllUsers() {
        List<UserObject> users = new ArrayList<>();
        try (Connection conn = DBUserMethods.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {

            while (rs.next()) {
                users.add(new UserObject(rs.getString("Fname"),rs.getString("Lname"),rs.getString("Minitial"),
                		rs.getString("email"), rs.getInt("number"), rs.getString("address"), rs.getString("password"), 
                		rs.getString("username"), rs.getString("dob"), rs.getString("isMember"), rs.getInt("dues")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static void addUser(String Fname, String Lname, String Minitial, String email, String number, 
    		String address, String password, String username, String dob ) {
    	String sql = "INSERT INTO users(Fname, Lname, Minitial, email,"
	    		+ " number, address, password, username, dob) "
	    		+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	    try (Connection conn = DBUserMethods.connect();
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

	        pstmt.executeUpdate();
	        System.out.println("User added.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
    }
}
