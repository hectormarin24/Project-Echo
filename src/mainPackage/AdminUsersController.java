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

public class AdminUsersController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	//Text boxes(not actual text )under the images in the home page
	@FXML
	Label userIdLabel1;
	@FXML
	Label userIdLabel2;
	@FXML
	Label namesLabel1;
	@FXML
	Label namesLabel2;
	@FXML
	Label emailLabel1;
	@FXML
	Label emailLabel2;
	@FXML
	Label phoneNumber1;
	@FXML
	Label phoneNumber2;
	@FXML
	Label memberShipStatusLabel1;
	@FXML
	Label memberShipStatusLabel2;
	@FXML
	Label overdueFeesLabel1;
	@FXML
	Label overdueFeesLabel2;
	@FXML
	Label booksBorrowedLabel1;
	@FXML
	Label booksBorrowedLabel2;
	@FXML
	Label adminId1;
	
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

	
	public void displayAdminUsersInfo(String userID1, String userID2, String Name1, String Name2, String email1, String email2,
	String phone1, String phone2, String membership1, String membership2, String fees1, String fees2, String borrowedBook1, String borrowedBook2, String adminId)
	{
		userIdLabel1.setText("USERID: " + userID1);
		userIdLabel2.setText("USERID: " + userID2);
		namesLabel1.setText("Name: " +  Name1);
		namesLabel2.setText("Name: " +  Name2);
		emailLabel1.setText("Email: " +  email1);
		emailLabel2.setText("Email: " +  email2);
		phoneNumber1.setText("Phone Number: " +  phone1);
		phoneNumber2.setText("Phone Number: " +  phone2);
		memberShipStatusLabel1.setText("Membership Status: " +  membership1);
		memberShipStatusLabel2.setText("Membership Status: " +  membership2);
		overdueFeesLabel1.setText("Overdue Fees: " +  fees1);
		overdueFeesLabel2.setText("Overdue Fees: " +  fees2);
		booksBorrowedLabel1.setText("Books Borrowed: " +  borrowedBook1);
		booksBorrowedLabel2.setText("Books Borrowed: " +  borrowedBook2);
		adminId1.setText("ADMINID: " +  adminId);
		
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
