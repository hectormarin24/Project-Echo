package mainPackage;
//import java.util.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;*/


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
		
		
		
		
		
		
		
		
		
		
		
		
	   /*Class.forName("com.mysql.cj.jdbc.Driver");
	       
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Echo215555$");
       System.out.println("Connection created");*/
	}
}

