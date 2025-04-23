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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	
	//Text for under the Images
	
	//Control varible
	int current1 = 1;
	int current2 = 2;
	int current3 = 3;
	int current4 = 4;

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
	public void contact(ActionEvent event) throws IOException
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
	public void home(ActionEvent event) throws IOException
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
	public void credit(ActionEvent event) throws IOException
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
	public void about(ActionEvent event) throws IOException
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
	public void search(ActionEvent event) throws IOException
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
	public void location(ActionEvent event) throws IOException
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
	public void myAccount(ActionEvent event) throws IOException
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
	public void facebook(ActionEvent event) throws IOException
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
	public void instagram(ActionEvent event) throws IOException
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
	public void twitter(ActionEvent event) throws IOException
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
	public void searchBarToString(ActionEvent event)
	{
		String search = searchBar.getText();
		
	}
	





}