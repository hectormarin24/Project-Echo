package mainPackage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BookWindowController implements Initializable
{

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	//choice boc
	@FXML
	ChoiceBox<String> keywordChoice;
	String[] keywords = {"Choice1","Choice2","Choice3","Choice4"};
	
	
	@FXML
	TextField searchBar;
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
	public void ifEsc()
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

	public void wishlistTrigger(ActionEvent event)
	{
		
	}
	
	public void reserveTrigger(ActionEvent event)
	{
		
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
			public void searchBarToSearch(ActionEvent event)
			{
				try 
				{
					String search = searchBar.getText();
					FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchBook.fxml"));
					root = loader.load();
					SearchBookController profileController = loader.getController();
					profileController.searchForBook(search);
					
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
			@Override
			public void initialize(URL arg0, ResourceBundle arg1) {
				keywordChoice.getItems().addAll(keywords);
			
			}

}
