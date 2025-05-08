package mainPackage;

import java.time.LocalDate;
import java.util.Locale;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class DatePickerSample {
	private static LocalDate datePicked = null;
	
    public static LocalDate showCalendar(Stage owner) {
    	Stage stage = new Stage();
    	stage.initOwner(owner);
    	stage.setTitle("Reserve");
        VBox vbox = new VBox(20);
        vbox.setStyle("-fx-padding: 10;");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        DatePicker pick = new DatePicker();
        // prevent picking old dates
        pick.setDayCellFactory(picker -> new javafx.scene.control.DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if (date.isBefore(LocalDate.now())) {
                    setDisable(true);
                    setStyle("-fx-background-color: #808080;");
                }
            }
        });
        
        Label checkInlabel = new Label("Reserve Date:");
        gridPane.add(checkInlabel, 0, 0);
        gridPane.add(pick, 0, 1);

        GridPane.setHalignment(checkInlabel, HPos.LEFT);
        vbox.getChildren().add(gridPane);

        pick.setOnAction(e -> {
            datePicked = pick.getValue();
            if (datePicked != null) {
                stage.close();
            }
        });
        Scene scene = new Scene(vbox, 300, 120);
        stage.setScene(scene);

        stage.showAndWait();

        return datePicked;
        
    }
}