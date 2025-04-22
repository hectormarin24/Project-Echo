package mainPackage;
//import java.util.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
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
			primaryStage.setTitle("Styled JavaFX App");
			Button button = new Button("Contact");
			button.getStyleClass().add("contact-button");
			
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		launch(args);
		
		//DBLoans.createTable();
		//DBLoans.createLoan(45, 40, "4/30/2025");
		//DBLoans.createLoan(55, 60, "10/20/2009");
		DBLoans.deleteLoan(45);
		DBLoans.showAllLoans();
		//DBLoans.searchLoansByUserId(45);
		
	}


	

}

