package mainPackage;

public class LoanObject {
	private String id;
	private String userId;
	private String bookId;
	private String dueDate;
	private String loanDate;
	private String returnDate;
	private String status;
	
	//Constructor
	public LoanObject(Integer id, Integer userId, Integer bookId, String dueDate, String loanDate, 
			String returnDate, String status) {
		this.id = Integer.toString(id);
		this.userId = Integer.toString(userId);
		this.bookId = Integer.toString(bookId);
		this.dueDate = dueDate;
		this.loanDate = loanDate;
		this.returnDate = returnDate;
		this.status = status;
	}
	
	//Methods
	public String getId() {
		return id;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public String getBookId() {
		return bookId;
	}
	
	public String getDueDate() {
		return dueDate;
	}
	
	public String getLoanDate() {
		return loanDate;
	}
	
	public String getReturnDate() {
		return returnDate;
	}
	
	public String getStatus() {
		return status;
	}
}
