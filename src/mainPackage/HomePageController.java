package mainPackage;
import java.io.IOException;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
public class HomePageController
{
	private Stage stage;
	private Scene scene;
	private Parent root;

	
	//search bar in the home page
	@FXML
	TextField searchBar;
	
	//Images boxes in the home page
	@FXML
	ImageView genreImage1;
	@FXML
	ImageView genreImage2;	
	@FXML
	ImageView genreImage3;
	@FXML
	ImageView genreImage4;
	
	//Actual images to be imported
	int imageRange = 2;
	Image myImage1 = new Image(getClass().getResourceAsStream("/EchoLibrary.png"));
	Image myImage2 = new Image(getClass().getResourceAsStream("/gabriel.png"));
	
	
	
	//Buttons
	Button rightButton;
	Button leftButton;
	Button searchBarButton;
	
	//Text boxes(not actual text )under the images in the home page
	@FXML
	Label genreLabel1;
	@FXML
	Label genreLabel2;
	@FXML
	Label genreLabel3;
	@FXML
	Label genreLabel4;
	@FXML
	Label errorLabel;
	
	//Text for under the Images
	
	//Control varible
	int current1 = 1;
	int current2 = 2;
	int current3 = 3;
	int current4 = 4;
	@FXML
	TextField searchBar1;
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
	
	//SOCIAL MEDIA PARTS
		public void faceBookAccess(ActionEvent event) throws IOException
		{
			try
			{
				FXMLLoader loader = new FXMLLoader(getClass().getResource("SocialMedia.fxml"));
				root = loader.load();
				SocialMediaController socialMedia = loader.getController();
				socialMedia.loadFaceBook();
				
				
				//root = FXMLLoader.load(getClass().getResource("SocialMedia.fxml"));
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
				FXMLLoader loader = new FXMLLoader(getClass().getResource("SocialMedia.fxml"));
				root = loader.load();
				SocialMediaController socialMedia = loader.getController();
				socialMedia.loadInstaGram();
				
				
				//root = FXMLLoader.load(getClass().getResource("SocialMedia.fxml"));
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
				FXMLLoader loader = new FXMLLoader(getClass().getResource("SocialMedia.fxml"));
				root = loader.load();
				SocialMediaController socialMedia = loader.getController();
				socialMedia.loadTwitter();
				
				
				//root = FXMLLoader.load(getClass().getResource("SocialMedia.fxml"));
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
		public void linkedInAccess(ActionEvent event) throws IOException
		{
			try
			{
				FXMLLoader loader = new FXMLLoader(getClass().getResource("SocialMedia.fxml"));
				root = loader.load();
				SocialMediaController socialMedia = loader.getController();
				socialMedia.loadLinkedIn();
				
				
				//root = FXMLLoader.load(getClass().getResource("SocialMedia.fxml"));
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

	
	
	//THESE NEXT METHODS AREN"T ENTIRELY SET UP YET
	public void rightButton(ActionEvent event)
	{

			genreImage1.setImage(myImage1);
			genreImage2.setImage(myImage2);
			genreImage3.setImage(myImage1);
			genreImage4.setImage(myImage2);
		
			current1++;
			current2++;
			current3++;
			current4++;
			
			genreLabel1.setText("Genre " + current1 + ":");
			genreLabel2.setText("Genre " + current2 + ":");
			genreLabel3.setText("Genre " + current3 + ":");
			genreLabel4.setText("Genre " + current4 + ":");
		
	}
	public void leftButton(ActionEvent event)
	{
		
		genreImage1.setImage(myImage2);
		genreImage2.setImage(myImage1);
		genreImage3.setImage(myImage2);
		genreImage4.setImage(myImage1);
		
		current1--;
		current2--;
		current3--;
		current4--;
		
		genreLabel1.setText("Genre " + current1 + ":");
		genreLabel2.setText("Genre " + current2 + ":");
		genreLabel3.setText("Genre " + current3 + ":");
		genreLabel4.setText("Genre " + current4 + ":");

	}
	
	public void searchBarToSearch(ActionEvent event) throws IOException
	{
		try 
		{
			String search = searchBar.getText();
			if(DBBooks.searchBook(search)) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchBook.fxml"));
			root = loader.load();
			SearchBookController profileController = loader.getController();
			profileController.searchForBook(search);
			
			root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			}
			
		}
		
		catch(Exception e2)
		{
			System.out.println(e2);
		}
		
	}

	

	





}