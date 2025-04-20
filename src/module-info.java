module ProjectEcho {
	
	 requires javafx.controls;
	 requires javafx.base;
	 requires javafx.graphics;
	 requires javafx.fxml;
	requires javafx.web;
	 
	// requires jdbc
	 //requires java.sql;
	 
	 exports mainPackage;
	 
	 // this is change able base on the name of your packages	 
	 opens mainPackage to javafx.graphics, javafx.fxml;
	 //opens application to javafx.graphics, javafx.fxml;
	}