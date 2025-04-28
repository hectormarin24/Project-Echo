package mainPackage;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	TextField usernameBox;
	@FXML
	TextField passwordBox;
	
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	public void login(ActionEvent event) throws IOException
	{
		try 
		{
			String username = usernameBox.getText();
			String password = passwordBox.getText();

			//if(username.equals("Jimmy"))
			//{
				//if(password.equals("Jimmy"))
				//{
					root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
					stage = (Stage)((Node)event.getSource()).getScene().getWindow();
					scene = new Scene(root);
					stage.setScene(scene);
					stage.show();
				//}
			//}
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
