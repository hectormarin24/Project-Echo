package mainPackage;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;

import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
			boolean adminStatus = false;
			if(adminStatus==true)
			{
				/*FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminPage.fxml"));
				root = loader.load();
				AdminAccountController adminControl = loader.getController();
				adminControl.displayInfo(CurrentUser.get().getFname() + " " + CurrentUser.get().getMinitial() + " " + CurrentUser.get().getLname()
						, CurrentUser.get().getUsername(), CurrentUser.get().getEmail()
						, CurrentUser.get().getNumber(), CurrentUser.get().getMembershipStatus(), "6");
				
				//root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
				*/
			}
				else
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
	
	public void searchBarToSearch(ActionEvent event) throws IOException {
	    try {
	        String search = searchBar.getText().toLowerCase();
	        System.out.println(search);

	        FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchBook.fxml"));
            Parent root = loader.load();

            // Get actual book object
            //BookObject book = DBBooks.getBookDetails(search);
            
            // Get book list
            ObservableList<BookObject> bookList = FXCollections.observableArrayList(DBBooks.bookSearch(search, ""));
            
            // Pass to controller
            SearchBookController controller = loader.getController();
            controller.setBookList(bookList);
            
            //controller.setBook(book);

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	

	





}