module ProjectEcho {
	
	requires jakarta.mail;
	
	requires javafx.controls;
	requires javafx.base;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.web;
	
	requires java.sql;
	 
	// requires jdbc
	 
	exports mainPackage;
	 
	// this is change able base on the name of your packages	 
	opens mainPackage to javafx.graphics, javafx.fxml;
	//opens application to javafx.graphics, javafx.fxml;
}