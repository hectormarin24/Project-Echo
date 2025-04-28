package mainPackage;
//import java.util.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;


//Image stuff imported
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;

import javafx.scene.control.Button;

import javafx.scene.layout.BorderPane;


//YOU CAN IMPORT MANY DIFFERENT THINGS HERE FOR GRAPHICS
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;


public class Main extends Application {
	@Override
	public void start(Stage stage) throws Exception
	{
		try {

			//To get this to work either put a "/" in front of the file; or you take the fxml file to the application process.
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		launch(args);
		
		
			
		

	   /*Class.forName("com.mysql.cj.jdbc.Driver");
	      
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Echo215555$");
      System.out.println("Connection created");*/

	}


	

}
