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
import javafx.stage.Stage;

public class LoginController {

	@FXML
	TextField usernameBox;
	@FXML
	TextField passwordBox;
	@FXML
	Label errorLabel;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	public void ifH()
	{
		System.out.println("H has been pressed");
	}
	public void ifF()
	{
		System.out.println("H has been pressed");
	}
	public void ifI()
	{
		System.out.println("H has been pressed");
	}
	public void ifL()
	{
		System.out.println("H has been pressed");
	}
	public void ifEsc()
	{
		System.out.println("H has been pressed");
	}

	
	public void login(ActionEvent event) throws IOException
	{
		try 
		{
			String username = usernameBox.getText();
			String password = passwordBox.getText();

			
			if(username.isEmpty() || password.isEmpty()) {
				errorLabel.setText("Please fill out all required fields.");
		    	errorLabel.setTextFill(Color.RED);
		    	return;
			}
			
			
			
					root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
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
	public void createAccount(ActionEvent event) throws IOException
	{
		try 
		{
			root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
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
