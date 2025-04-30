package mainPackage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;







public class SocialMediaController implements Initializable
{
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private WebView webView;
	
	@FXML
	private TextField newLink;
	
	private WebEngine engine;
	private WebHistory history;
	
	private double webZoom = 1;
	
	private String s = "https://www.google.com/";
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg)
	{
		engine = webView.getEngine();
		loadPage();
	}
	public void loadPage()
	{
		engine.load(newLink.getText());
	}
	
	
	//Socialmedia links
	//MAKE SURE TO REPLACE THE LINKS WITH THE ACTUAL PAGES
	public void loadTwitter()
	{
		engine.load("https://x.com/Echo_Library");
		
	}
	public void loadFaceBook()
	{
		engine.load("https://www.facebook.com/profile.php?id=61575188941914");
		
	}
	public void loadInstaGram()
	{
		engine.load("https://www.instagram.com/echo_library_unlocknewworlds/");
		
	}
	public void loadLinkedIn()
	{
		engine.load("https://www.linkedin.com/in/echo-library-0546b3361/");
		
	}
	public void loadGitHub()
	{
		engine.load("https://www.linkedin.com/in/echo-library-0546b3361/");
		
	}
	public void loadBlueSky()
	{
		engine.load("https://www.linkedin.com/in/echo-library-0546b3361/");
		
	}
	public void refreshPage()
	{
		engine.reload();
	}
	
	public void zoomIn()
	{
		webZoom = webZoom + .25;
		webView.setZoom(webZoom);
	}
	public void ZoomOut()
	{
		webZoom = webZoom - .25;
		webView.setZoom(webZoom);
	}
	public void displayHistory()
	{
		history=engine.getHistory();
		ObservableList<WebHistory.Entry> entries = history.getEntries();
		for (WebHistory.Entry entry : entries)
		{
			System.out.println(entry.getUrl() + " " + entry.getLastVisitedDate());
		}
	}
	public void back()
	{
		history=engine.getHistory();
		ObservableList<WebHistory.Entry> entries = history.getEntries();		
		history.go(-1);
		newLink.setText(entries.get(history.getCurrentIndex()).getUrl());
	}
	public void forward()
	{
		history=engine.getHistory();
		ObservableList<WebHistory.Entry> entries = history.getEntries();
		history.go(1);
		newLink.setText(entries.get(history.getCurrentIndex()).getUrl());
	}
	
	public void returnHomePage(ActionEvent event) throws IOException
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
}
