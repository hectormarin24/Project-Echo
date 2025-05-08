package mainPackage;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
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
	
	@FXML
	private Button signOut;
	@FXML
	private AnchorPane scenePane;
	public void SignOut(ActionEvent event)
	{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Sign Out");
		alert.setHeaderText("You are about to sign out!");
		alert.setContentText("Do you want to save before exiting?");
		
		if(alert.showAndWait().get() == ButtonType.OK)
		{
			stage = (Stage) scenePane.getScene().getWindow();
			stage.close();	
		}
	}
	
	
	
	
	
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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminAccount.fxml"));
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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminBooks.fxml"));
			root = loader.load();
			AdminBooksController adminBooksController = loader.getController();
			adminBooksController.displayAdminBooksInfo("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15");
			
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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminFees.fxml"));
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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminUsers.fxml"));
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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminLoans.fxml"));
			root = loader.load();
			AdminLoansController adminLoansController = loader.getController();
			adminLoansController.displayAdminLoansInfo("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17", "18", "19");
			
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
	public void searchAccess(ActionEvent event) throws IOException
	{
		try 
		{
			root = FXMLLoader.load(getClass().getResource("SearchBook.fxml"));
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
	//SOCIAL MEDIA PARTS
	@SuppressWarnings("deprecation")
	public void faceBookAccess(ActionEvent event) throws IOException
	{
		try {
			Desktop.getDesktop().browse(new URL("https://www.facebook.com/people/Echo-Library/61575188941914/").toURI());
		} catch (Exception e) {}
	}
	
	@SuppressWarnings("deprecation")
	public void instagramAccess(ActionEvent event) throws IOException
	{
		try {
			Desktop.getDesktop().browse(new URL("https://www.instagram.com/echo_library_unlocknewworlds/").toURI());
		} catch (Exception e) {}		
	}
	
	@SuppressWarnings("deprecation")
	public void twitterAccess(ActionEvent event) throws IOException
	{
		try {
			Desktop.getDesktop().browse(new URL("https://x.com/Echo_Library").toURI());
		} catch (Exception e) {}
	}
	
	@SuppressWarnings("deprecation")
	public void linkedInAccess(ActionEvent event) throws IOException
	{
		try {
			Desktop.getDesktop().browse(new URL("https://www.linkedin.com/in/echo-library-0546b3361/").toURI());
		} catch (Exception e) {}
	}

	@SuppressWarnings("deprecation")
	public void blueskyAccess(ActionEvent event) throws IOException {
		try {
			Desktop.getDesktop().browse(new URL("https://bsky.app/profile/echolibrary.bsky.social").toURI());
		} catch (Exception e) {}
	}
			public void contactAccess(ActionEvent event) throws IOException
			{
				try 
				{
					root = FXMLLoader.load(getClass().getResource("ContactPage.fxml"));
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
					root = FXMLLoader.load(getClass().getResource("AboutPage.fxml"));
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
					root = FXMLLoader.load(getClass().getResource("CreditProxy.fxml"));
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
