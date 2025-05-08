package mainPackage;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SearchBookController implements Initializable
{
	

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	TextField searchBar;
	@FXML
	private Button signOut;
	@FXML
	private AnchorPane scenePane;
	
	@FXML
	private ListView<BookObject> bookList;
	
	@FXML private Label title;
    @FXML private Label author;
    @FXML private Label genre;
    @FXML private Label publisher;
    @FXML private Label ISBN;
    @FXML private Label shelfLocation;
    @FXML private Label releaseDate;
    @FXML private Label status;
    
	
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

	
	public void setBook(BookObject book) {
        title.setText(book.getTitle());
        author.setText(book.getAuthor());
        genre.setText(book.getGenre());
        //publisher.setText(book.getPublisher());
        //ISBN.setText(book.getISBN());
        shelfLocation.setText(book.getLocation());
        //releaseDate.setText(book.getReleaseDate());
        //status.setText(book.getStatus());
    }
	
	public void setBookList(ObservableList<BookObject> bookListParam) {
		bookList.setCellFactory(param -> new BookObjectCell());
		
		bookList.setItems(bookListParam);
	}
	
	public void searchForBook(String s)
	{
		searchBar.setText(s);
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
	
	public void bookWindowAccess(ActionEvent event) throws IOException
	{
		try 
		{
			root = FXMLLoader.load(getClass().getResource("BookWindow.fxml"));
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
	public void myAccountAccess(ActionEvent event) throws IOException
	{
		try 
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Profile.fxml"));
			root = loader.load();
			ProfileController profileController = loader.getController();
			profileController.displayInfo("1", "2", "3", "4", "5", "6");
			
			
			/*FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminAccount.fxml"));
			root = loader.load();
			AdminAccountController adminAccountController = loader.getController();
			adminAccountController.displayAdminAccountInfo("1","2","3","4","5","6");*/
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
			public void searchBarToSearch(ActionEvent event) throws IOException {
			    try {
			        String search = searchBar.getText().toLowerCase();
			        System.out.println(search);

	/* @SuppressWarnings("deprecation")
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
			public void searchBarToSearch(ActionEvent event) throws IOException
			{
				try 
				{
					String search = searchBar.getText();
					if(DBBooks.searchBook(search)) {
						root = FXMLLoader.load(getClass().getResource("SearchBook.fxml"));
						SearchBookController searchBookController = new SearchBookController();
						searchBookController.searchForBook(search);
						stage = (Stage)((Node)event.getSource()).getScene().getWindow();
						scene = new Scene(root);
						stage.setScene(scene);
						stage.show(); */


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

			@Override
			public void initialize(URL arg0, ResourceBundle arg1) {
			}

}