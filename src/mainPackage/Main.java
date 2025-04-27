package mainPackage;
//import java.util.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
//Image stuff imported
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
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

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;*/


public class Main extends Application {
	@Override
	public void start(Stage stage) throws Exception
	{
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root);	
			stage.setScene(scene);
			stage.show();
	
			
			
			stage.setOnCloseRequest(event ->
			{ event.consume();
			SignOut(stage);
			});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	private Button signOut;
	@FXML
	private AnchorPane scenePane;
	public void SignOut(Stage stage)
	{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Sign Out");
		alert.setHeaderText("You are about to sign out!");
		alert.setContentText("Do you want to save before exiting?");
		
		if(alert.showAndWait().get() == ButtonType.OK)
		{

			stage.close();	
		}
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException{
		launch(args);
		
		
		
		
		
		
		
		
		
		
		
		
	   /*Class.forName("com.mysql.cj.jdbc.Driver");
	      
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Echo215555$");
      System.out.println("Connection created");*/
	}
}
