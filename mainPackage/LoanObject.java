package mainPackage;

public class LoanObject{
	private String LoanID;
	private String UserID;
	private String BookID;
	private String IssueDate;
	private String DueDate;
	private String ReturnDate;
	private double Fees;
	private String Status;
	
	//Object constructor
	public LoanObject(String LoanID, String UserID, String BookID, String IssueDate, String DueDate, String Status){
		this.LoanID = LoanID;
		this.UserID = UserID;
		this.BookID = BookID;
		this.IssueDate = IssueDate;
		this.DueDate = DueDate;
		this.ReturnDate = ReturnDate;
		this.Fees = Fees;
		this.Status = Status;
	}
	
	//Methods
	public String getLoanID() {
		return LoanID;
	}
	
	public String getUserID() {
		return UserID;
	}
	
	public String getBookID() {
		return BookID;
	}
	
	public String getIssueDate() {
		return IssueDate;
	}
	
	public String getDueDate() {
		return DueDate;
	}
	
	public String getReturnDate() {
		return ReturnDate;
	}
	
	public double getFees() {
		return Fees;
	}
	
	public String getStatus() {
		return Status;
	}
	
	public void setReturnDate(String i) {
		ReturnDate = i;
	}
	
	public void setFees(int dayslate) {
		double dayfee = 0.1;
		Fees = dayfee * dayslate;
	}
	
	public void setStatus(String k) {
		Status = k;
	}
}