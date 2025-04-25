package application;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ContactPageController {
	
	@FXML
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchToAbout(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AboutPage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToHome(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToContact(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ContactPage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToCredit(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("CreditProxy.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@SuppressWarnings("deprecation")
	public void openFB(ActionEvent event) {
		try {
			Desktop.getDesktop().browse(new URL("https://www.facebook.com/people/Echo-Library/61575188941914/").toURI());
		} catch (Exception e) {}
	}
	
	@SuppressWarnings("deprecation")
	public void openX(ActionEvent event) {
		try {
			Desktop.getDesktop().browse(new URL("https://x.com/Echo_Library").toURI());
		} catch (Exception e) {}
	}
	
	@SuppressWarnings("deprecation")
	public void openIG(ActionEvent event) {
		try {
			Desktop.getDesktop().browse(new URL("https://www.instagram.com/echo_library_unlocknewworlds/").toURI());
		} catch (Exception e) {}
	}
	
	@SuppressWarnings("deprecation")
	public void openLI(ActionEvent event) {
		try {
			Desktop.getDesktop().browse(new URL("https://www.linkedin.com/in/echo-library-0546b3361/").toURI());
		} catch (Exception e) {}
	}
	
	@SuppressWarnings("deprecation")
	public void openGH(ActionEvent event) {
		try {
			Desktop.getDesktop().browse(new URL("https://github.com/hectormarin24/ProjectEcho").toURI());
		} catch (Exception e) {}
	}
	
}
