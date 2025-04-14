package mainPackage;
//import java.util.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException{
		launch(args);
		
		
	
	    createTable();
	    insertUser("Alice", "alice@example.com");
	    insertUser("Bob", "bob@example.com");
	    showAllUsers();
	

		
		
		
		
		
		
		
		
		
		
		
			
	}


	public static void createTable() {
	    String sql = """
	        CREATE TABLE IF NOT EXISTS users (
	            id INTEGER PRIMARY KEY AUTOINCREMENT,
	            name TEXT NOT NULL,
	            email TEXT UNIQUE NOT NULL
	        );
	        """;
	
	    try (Connection conn = DBUtil.connect();
	         var stmt = conn.createStatement()) {
	        stmt.execute(sql);
	        System.out.println("Table created or already exists.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	
	public static void insertUser(String name, String email) {
	    String sql = "INSERT INTO users(name, email) VALUES(?, ?)";
	
	    try (Connection conn = DBUtil.connect();
	         var pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, name);
	        pstmt.setString(2, email);
	        pstmt.executeUpdate();
	        System.out.println("User added.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void showAllUsers() {
	    String sql = "SELECT * FROM users";

	    try (Connection conn = DBUtil.connect();
	         var stmt = conn.createStatement();
	         var rs = stmt.executeQuery(sql)) {
	        while (rs.next()) {
	            System.out.println(rs.getInt("id") + ": " +
	                               rs.getString("name") + " - " +
	                               rs.getString("email"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


}

