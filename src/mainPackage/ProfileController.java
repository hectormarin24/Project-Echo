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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ProfileController {
	

	private Stage stage;
	private Scene scene;
	private Parent root;
	
		//Text boxes(not actual text )under the images in the home page
		@FXML
		Label nameLabel1;
		@FXML
		Label usernameLabel1;
		@FXML
		Label emailLabel1;
		@FXML
		Label phoneNumberLabel1;
		@FXML
		Label membershipStatusLabel1;
		@FXML
		Label userIdLabel;

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

		
		public void displayInfo(String name, String username, String email, String phoneNumber, String membership, String userID)
		{
			nameLabel1.setText("Name: " + name);
			usernameLabel1.setText("Username: " + username);
			emailLabel1.setText("Email: " +  email);
			phoneNumberLabel1.setText("Phone Number: " +  phoneNumber);
			membershipStatusLabel1.setText("Membership Status: " +  membership);
			userIdLabel.setText("USERID: " +  userID);
		}
		
	public void profileAccess(ActionEvent event) throws IOException
	{
		try 
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Profile.fxml"));
			root = loader.load();
			ProfileController profileController = loader.getController();
			profileController.displayInfo(CurrentUser.get().getFname() + " " + CurrentUser.get().getMinitial() + " " + CurrentUser.get().getLname()
					, CurrentUser.get().getUsername(), CurrentUser.get().getEmail()
					, CurrentUser.get().getNumber(), CurrentUser.get().getMembershipStatus(), "6");
			
			//root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
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
	public void reserveBooksAccesss(ActionEvent event) throws IOException
	{
		try 
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ReserveBooks.fxml"));
			root = loader.load();
			ReserveBooksController reserveBooksController = loader.getController();
			reserveBooksController.displayReserveBooksInfo("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15");
			
			//root = FXMLLoader.load(getClass().getResource("ReserveBooks.fxml"));
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
	public void wishListAccess(ActionEvent event) throws IOException
	{
		try 
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("WishList.fxml"));
			root = loader.load();
			WishListController wishListController = loader.getController();
			wishListController.displayWishListInfo("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15");
			
			//root = FXMLLoader.load(getClass().getResource("WishList.fxml"));
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
	public void borrowHistoryAccess(ActionEvent event) throws IOException
	{
		try 
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("BorrowHistory.fxml"));
			root = loader.load();
			BorrowHistoryController borrowHistoryController = loader.getController();
			borrowHistoryController.displayBorrowHistoryInfo("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15");
			
			//root = FXMLLoader.load(getClass().getResource("BorrowHistory.fxml"));
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