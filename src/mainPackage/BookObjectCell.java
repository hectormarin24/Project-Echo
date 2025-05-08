package mainPackage;

import java.time.LocalDate;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BookObjectCell extends ListCell<BookObject> {
	
	@Override
	public void updateItem(BookObject book, boolean empty) {
		super.updateItem(book, empty);
		if (empty || book == null) {
	         setText(null);
	         setGraphic(null);
	     } else {
	         Text bookInfo = new Text(book.toString());
	         HBox listCell = new HBox(15);
	         
             Button loan = new Button("Loan");
             Button reserve = new Button("Reserve");
             Button wishlist = new Button("Wishlist");
             loan.setAlignment(Pos.CENTER_RIGHT);
             reserve.setAlignment(Pos.CENTER_RIGHT);
             wishlist.setAlignment(Pos.CENTER_RIGHT);
             
             loan.setOnAction(event -> {
                 DBLoans.createLoan(CurrentUser.get().getID(), Integer.parseInt(book.getId()));
                 System.out.println(CurrentUser.get().getUsername() + " loaned book: " + book.getTitle());
                 String loanDate = LocalDate.now().toString();
             	 String dueDate = LocalDate.parse(loanDate).plusDays(21).toString();
                 System.out.println("Loan due: " + dueDate);
             });
             reserve.setOnAction(event -> {
            	 Stage owner = (Stage) reserve.getScene().getWindow();
                 reserve(book, owner);
             });
             wishlist.setOnAction(event -> {
                 DBWishlist.addWishlist(CurrentUser.get().getID(), Integer.parseInt(book.getId()));
                 System.out.println(CurrentUser.get().getUsername() + " wishlisted book: " + book.getTitle());
             });

             listCell.getChildren().addAll(bookInfo, loan, reserve, wishlist);
             setGraphic(listCell);
	     }
	}
	
	private void reserve(BookObject book, Stage owner) {
	    LocalDate enteredDate = DatePickerSample.showCalendar(owner);

	    if (enteredDate == null) {
	        return;
	    }
	    
	    DBReservations.addReservations(CurrentUser.get().getID(), Integer.parseInt(book.getId()), enteredDate.toString(), "Active");
	    System.out.println(CurrentUser.get().getUsername() + " reserved book: " + book.getTitle());
	    System.out.println("Reservation date: " + enteredDate.toString());
	}
}
