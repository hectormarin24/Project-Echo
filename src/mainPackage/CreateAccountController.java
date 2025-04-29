package mainPackage;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreateAccountController {

	@FXML
	TextField usernameBox;
	
	@FXML
	TextField passwordBox;
	
	@FXML
	TextField firstNameBox;
	
	@FXML
	TextField lastNameBox;
	
	@FXML
	TextField phoneNumberBox;
	
	@FXML
	TextField emailBox;
	@FXML
	TextField middleInitialBox;
	
	@FXML
	Label errorLabel;
	
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void createNewAcount(ActionEvent event)
	{
		String username = usernameBox.getText();
		String password = passwordBox.getText();
		String firstName = firstNameBox.getText();
		String lastName = lastNameBox.getText();
		String phoneNumber = phoneNumberBox.getText();
		String email = emailBox.getText();
		String middleName = middleInitialBox.getText();
		
		//UserObject newUser = new UserObject(firstName, lastName, middleName, email, 0, "", password, username, "", "", 0);
		//Some sort of if statement to make sure they don't have the same names, email, usernames, ect.
		/*if(usnername.equals(otherUsername))
		{
			errorLabel.setText("Error! Usernmae already taken!");
		}
		String firstLast = firstName + " " + lastname;
		/*if(firstLast.equals(otherfirstLast))
		{
			errorLabel.setText("Error! This name is already in the syatem already taken!");
		}		
		*/
	}
	
	public void backToLogin(ActionEvent event) throws IOException
	{
		try {
		root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		}
		catch(IOException e)
		{
			System.out.println(e);	
		}
	}
	
	public void returnLogin(ActionEvent event) throws IOException
	{
		try 
		{
				String username = usernameBox.getText().trim();
			    String password = passwordBox.getText().trim();
			    String firstName = firstNameBox.getText().trim();
			    String lastName = lastNameBox.getText().trim();
			    String phoneNumber = phoneNumberBox.getText().trim();
			    String email = emailBox.getText().trim();
	
			    // Optional fields
			    String middleInitial = middleInitialBox.getText().trim();
			    String address = "";
			    String dob = "";
			    String type = "User";
	
			    // Basic validation
			    if (firstName.isEmpty() || lastName.isEmpty() || username.isEmpty()
			        || password.isEmpty() || email.isEmpty() || phoneNumber.isEmpty()) {
			    	errorLabel.setText("Please fill out all required fields.");
			    	errorLabel.setTextFill(Color.RED);
			        
			        return; // Don't proceed
			    }
	
			    // You could add more specific validation like email format, password strength, etc.
	
			    //DBUserMethods dao = new DBUserMethods();
			    DBUserMethods.insertUser(firstName, lastName, middleInitial, email, phoneNumber, address, password, username, dob, type);
			    errorLabel.setText("Account created successfully!");
			    
			
				root = FXMLLoader.load(getClass().getResource("Login.fxml"));
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		catch(Exception e2)
		{
			System.out.println(e2);
		}
	
	}
}
