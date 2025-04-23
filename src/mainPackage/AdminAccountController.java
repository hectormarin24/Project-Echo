package mainPackage;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AdminAccountController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	//Text boxes(not actual text )under the images in the home page
	@FXML
	Label nameLabel1;
	@FXML
	Label userNameLabel1;
	@FXML
	Label emailLabel1;
	@FXML
	Label phoneNumberLabel1;
	@FXML
	Label membershipLabel1;
	@FXML
	Label adminIdLabel1;
	
	public void displayAdminAccountInfo(String title1, String username, String email, String phoneNumber, String membership, String adminID)
	{
		nameLabel1.setText("Title: " + title1);
		userNameLabel1.setText("UserName: " + username);
		emailLabel1.setText("Email: " +  email);
		phoneNumberLabel1.setText("Phone Number: " +  phoneNumber);
		membershipLabel1.setText("Membership Statu: " +  membership);
		adminIdLabel1.setText("ADMINID: " +  adminID);
		
	}
	
	
	public void adminAccountAccess(ActionEvent event) throws IOException
	{
		try 
		{	
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountAccount.fxml"));
			root = loader.load();
			AdminAccountController adminAccountController = loader.getController();
			adminAccountController.displayAdminAccountInfo("1","2","3","4","5","6");
			
			//root = FXMLLoader.load(getClass().getResource("AdminAccount.fxml"));
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
	public void adminBooksAccess(ActionEvent event) throws IOException
	{
		try 
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountBooks.fxml"));
			root = loader.load();
			AdminBooksController adminBooksController = loader.getController();
			adminBooksController.displayAdminBooksInfo("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17");
			
			//root = FXMLLoader.load(getClass().getResource("AdminBooks.fxml"));
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
	public void adminFeesAccess(ActionEvent event) throws IOException
	{
		try 
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountFees.fxml"));
			root = loader.load();
			AdminFeesController adminFeesController = loader.getController();
			adminFeesController.displayAdminFeesInfo("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17", "18", "19");
			
			//root = FXMLLoader.load(getClass().getResource("AdminFees.fxml"));
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
	public void adminUsersAccess(ActionEvent event) throws IOException
	{
		try 
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountUsers.fxml"));
			root = loader.load();
			AdminUsersController adminUsersController = loader.getController();
			adminUsersController.displayAdminUsersInfo("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15");
			
			//root = FXMLLoader.load(getClass().getResource("AdminUsers.fxml"));
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
	public void adminLoanssAccess(ActionEvent event) throws IOException
	{
		try 
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountLoans.fxml"));
			root = loader.load();
			AdminLoansController adminLoansController = loader.getController();
			adminLoansController.displayAdminLoansInfo("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15");
			
			//root = FXMLLoader.load(getClass().getResource("AdminLoans.fxml"));
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
	public void homeAccess(ActionEvent event) throws IOException
	{
		try 
		{
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
	public void locationAccess(ActionEvent event) throws IOException
	{
		try 
		{
			root = FXMLLoader.load(getClass().getResource("filler.fxml"));
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
	public void searchAccess(ActionEvent event) throws IOException
	{
		try 
		{
			root = FXMLLoader.load(getClass().getResource("filler.fxml"));
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
	public void faceBookAccess(ActionEvent event) throws IOException
	{
		try 
		{
			root = FXMLLoader.load(getClass().getResource("SocialMedia.fxml"));
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
	public void twitterAccess(ActionEvent event) throws IOException
	{
		try 
		{
			root = FXMLLoader.load(getClass().getResource("SocialMedia.fxml"));
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
	public void instagramAccess(ActionEvent event) throws IOException
	{
		try 
		{
			root = FXMLLoader.load(getClass().getResource("SocialMedia.fxml"));
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
	public void contactAccess(ActionEvent event) throws IOException
	{
		try 
		{
			root = FXMLLoader.load(getClass().getResource("filler.fxml"));
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
	public void aboutAccess(ActionEvent event) throws IOException
	{
		try 
		{
			root = FXMLLoader.load(getClass().getResource("filler.fxml"));
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
	public void creditAccess(ActionEvent event) throws IOException
	{
		try 
		{
			root = FXMLLoader.load(getClass().getResource("filler.fxml"));
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
