package mainPackage;

import java.io.IOException;

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

public class AdminFeesController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	//Images boxes in the home page
	@FXML
	ImageView bookPicture1;
	@FXML
	ImageView bookPicture2;	

	//Actual images to be imported
	//int imageRange = 2;
	//Image myImage1 = new Image(getClass().getResourceAsStream("/EchoLibrary.png"));
	//Image myImage2 = new Image(getClass().getResourceAsStream("/gabriel.png"));
	
	//Text boxes(not actual text )under the images in the home page
	@FXML
	Label titleLabel1;
	@FXML
	Label titleLabel2;
	@FXML
	Label authorIsbnLabel1;
	@FXML
	Label authorIsbnLabel2;
	@FXML
	Label bookTypeLabel1;
	@FXML
	Label bookTypeLabel2;
	@FXML
	Label genreLabel1;
	@FXML
	Label genreLabel2;
	@FXML
	Label promptLabel1;
	@FXML
	Label promptLabel2;
	@FXML
	Label statusLabel1;
	@FXML
	Label statusLabel2;
	@FXML
	Label bookIdLabel1;
	@FXML
	Label bookIdLabel2;
	@FXML
	Label adminIdLabel1;
	@FXML
	Label typeLabelBox1;
	@FXML
	Label typeLabelBox2;
	@FXML
	Label userId1;
	@FXML
	Label userId2;	
	//Actual images to be imported
	//int imageRange = 2;
	//Image myImage1 = new Image(getClass().getResourceAsStream("/EchoLibrary.png"));
	//Image myImage2 = new Image(getClass().getResourceAsStream("/gabriel.png"));
	
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

	public void displayAdminFeesInfo(String title1, String title2, String authorLabel1, String authorLabel2, String bookLabel1, String bookLabel2,
	String genreLab1, String genreLab2, String prompt1, String prompt2, String status1, String status2, String IDBook1, String IDBook2, String admin, String Type1, String Type2, String user1, String user2)
	{
		titleLabel1.setText("Title: " + title1);
		titleLabel2.setText("Title: " + title2);
		authorIsbnLabel1.setText("Author and ISBN: " +  authorLabel1);
		authorIsbnLabel2.setText("Author and ISBN: " +  authorLabel2);
		bookTypeLabel1.setText("Book type: " +  bookLabel1);
		bookTypeLabel2.setText("Book type: " +  bookLabel2);
		genreLabel1.setText("Genre: " +  genreLab1);
		genreLabel2.setText("Genre: " +  genreLab2);
		promptLabel1.setText("Prompt: " +  prompt1);
		promptLabel2.setText("Prompt: " +  prompt2);
		statusLabel1.setText("Status: " +  status1);
		statusLabel2.setText("Status: " +  status2);
		bookIdLabel1.setText("BookID: " +  IDBook1);
		bookIdLabel2.setText("BookID: " +  IDBook2);
		adminIdLabel1.setText("ADMINID: " +  admin);
		typeLabelBox1.setText("Type: " +  Type1);
		typeLabelBox2.setText("Type: " +  Type2);
		userId1.setText("USERID: " +  user1);
		userId2.setText("USERID: " +  user2);
		
		//bookPicture1.setImage(myImage2);
		//bookPicture2.setImage(myImage1);

		
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
