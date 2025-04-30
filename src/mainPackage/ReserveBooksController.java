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

public class ReserveBooksController 
{
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
		Label userIdLabel;
		
		
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

		
		public void displayReserveBooksInfo(String title1, String title2, String authorLabel1, String authorLabel2, String bookLabel1, String bookLabel2,
				String genreLab1, String genreLab2, String prompt1, String prompt2, String status1, String status2, String IDBook1, String IDBook2, String userId)
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
					userIdLabel.setText("USERID: " +  userId);

					//bookPicture1.setImage(myImage2);
					//bookPicture2.setImage(myImage1);
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

		public void borrowTrigger(ActionEvent event) throws IOException
		{
			/*try 
			{
				
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			catch(Exception e2)
			{
				System.out.println(e2);
			}*/
		}

		public void wishListTrigger(ActionEvent event) throws IOException
		{
			/*try 
			{
				
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			catch(Exception e2)
			{
				System.out.println(e2);
			}*/
		}	

		public void removeTrigger(ActionEvent event) throws IOException
		{
			/*try 
			{
				
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			catch(Exception e2)
			{
				System.out.println(e2);
			}*/
		}

		
	public void profileAccess(ActionEvent event) throws IOException
	{
		try 
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Profile.fxml"));
			root = loader.load();
			ProfileController profileController = loader.getController();
			profileController.displayInfo("1", "2", "3", "4", "5", "6");
			
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
			public void blueSkyAccess(ActionEvent event) throws IOException
			{
				try
				{
					FXMLLoader loader = new FXMLLoader(getClass().getResource("SocialMedia.fxml"));
					root = loader.load();
					SocialMediaController socialMedia = loader.getController();
					socialMedia.loadBlueSky();
					
					
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
