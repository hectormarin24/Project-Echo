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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;


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
	
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// Program startup methods
		/*ArrayList<UserObject> users = DBUserMethods.showAllUsers();
		for (int i = 0; i < users.size(); i++) {
			UserObject user = users.get(i);
			System.out.println(user.getFname() + " " + user.getMinitial() + " " + user.getLname());
			System.out.println(user.getUsername() + " " + user.getPassword() + "\n");
		}*/
		
		// Emulate server at start of program
		DBWishlist.pingWishlists();
		//DBUserMethods.insertCustomAdmin();
		DBReservations.updateAllReservations();
		DBLoans.checkForOverdueLoans();
		DBUserMethods.createTable();
		DBBooks.createTable();
		//title, author, genre, publisher, isbn, shelflocation, release date
		
		DBBooks.showAllBooks();
		launch(args);

	}

}
	

