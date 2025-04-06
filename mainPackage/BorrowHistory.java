package mainPackage;
class BorrowHistory
{
	
	//Instance variables
	private String loanId;
	private String bookId;
	private String userId;
	private int fees;
	private String returnDate;
	private String dueDate;
	private String issueDate;
	private String status;
	
	//Constructor method
	public BorrowHistory(String loanId, String bookId, String userId, int fees, String returnDate, String dueDate, String issueDate, String status)
   {
   	this.loanId = loanId;
   	this.bookId = bookId;
   	this.userId = userId;
   	this.fees = fees;
   	this.returnDate = returnDate;
   	this.dueDate = dueDate;
   	this.issueDate = issueDate;
   	this.status = status;
   	
	}
   
   //getter methods
   public String getLoanId()
   {
   	return this.loanId;
   }
   public String getBookId()
   {
   	return this.bookId;
   }
   public String getUserId()
   {
   	return this.userId;
   }
   public int getFees()
   {
   	return this.fees;
   }
   public String getIssueDate()
   {
   	return this.issueDate;
   }
   public String getDueDate()
   {
   	return this.dueDate;
   }
   public String getReturnDate()
   {
   	return this.returnDate;
   }
   public String getStatus()
   {
   	return this.status;
   }
   
   //setter methods
   public void setLoanId(String newLoanId)
   {
   	this.loanId = newLoanId;
   }
   public void setBookId(String newBookId)
   {
   	this.bookId = newBookId;
   }
   public void setUserId(String newUserId)
   {
   	this.userId = newUserId;
   }
   public void setFees(int newFees)
   {
   	this.fees = newFees;
   }
   public void setIssueDate(String newIssueDate)
   {
   	this.issueDate = newIssueDate;
   }
   public void setDueDate(String newDueDate)
   {
   	this.dueDate = newDueDate;
   }
   public void setReturnDate(String newReturnDate)
   {
   	this.returnDate = newReturnDate;
   }
   public void setStatus(String newStatus)
   {
   	this.status = newStatus;
   }
   
   
   
   //Will create a string of all the information, and then return it to the calling method.
   public String toString()
   {
   	String s = "";
   	s = s + "The loan Id: " + getLoanId() + "\n";
   	s = s + "The book's id: " + getBookId() + "\n";
   	s = s + "The user's Id: " + getUserId() + "\n";
   	s = s + "The fees thatare due: " + getFees() + "\n";
   	s = s + "The issue date: " + getIssueDate() + "\n";
   	s = s + "the due date: " + getDueDate() + "\n";
   	s = s + "The return date: " + getReturnDate() + "\n";
   	s = s + "The status is: " + getStatus() + "\n";
   	
   	return s;
   }
   


}



//Version that includes DateNumbered as an object. Just replaces the instance varibles with dates into DateNumbered objects instead of Strings.
/*class BorrowHistory
{
	
	//Instance variables
	private String loanId;
	private String bookId;
	private String userId;
	private int fees;
	private DateNumber returnDate;
	private DateNumber dueDate;
	private DateNumber issueDate;
	private String status;
	
	//Constructor method
	public BorrowHistory(String loadId, String bookId, String userId, int fees, DateNumber returnDate, DateNumber dueDate, DateNumber issueDate, String status)
    {
    	this. loanId = loanId;
    	this.bookId = bookId;
    	this.userId = userId;
    	this.fees = fees;
    	this.returnDate = returnDate;
    	this.dueDate = dueDate;
    	this.issueDate = issueDate;
    	this.status = status;
    	
	}
    
    //getter methods
    public String getLoanId()
    {
    	return this.loanId;
    }
    public String getBookId()
    {
    	return this.bookId;
    }
    public String getUserId()
    {
    	return this.userId;
    }
    public int getFees()
    {
    	return this.fees;
    }
    public DateNumber getIssueDate()
    {
    	return this.issueDate;
    }
    public DateNumber getDueDate()
    {
    	return this.dueDate;
    }
    public DateNumber getReturnDate()
    {
    	return this.returnDate;
    }
    public String getStatus()
    {
    	return this.status;
    }
    
    //setter methods
    public void setLoanId(String newLoanId)
    {
    	this.loanId = newLoanId;
    }
    public void setBookId(String newBookId)
    {
    	this.bookId = newBookId;
    }
    public void setUserId(String newUserId)
    {
    	this.userId = newUserId;
    }
    public void setFees(int newFees)
    {
    	this.fees = newFees;
    }
    public void setIssueDate(DateNumber newIssueDate)
    {
    	this.issueDate = newIssueDate;
    }
    public void setDueDate(DateNumber newDueDate)
    {
    	this.dueDate = newDueDate;
    }
    public void setReturnDate(DateNumber newReturnDate)
    {
    	this.returnDate = newReturnDate;
    }
    public void setStatus(String newStatus)
    {
    	this.status = newStatus;
    }
    
    
    
    //Will create a string of all the information, and then return it to the calling method.
    public String toString()
    {
    	String s = "";
    	s = s + "The loan Id: " + getLoanId() + "\n";
    	s = s + "The book's id: " + getBookId() + "\n";
    	s = s + "The user's Id: " + getUserId() + "\n";
    	s = s + "The fees thatare due: " + getFees() + "\n";
    	s = s + "The issue date: " + getIssueDate() + "\n";
    	s = s + "the due date: " + getDueDate() + "\n";
    	s = s + "The return date: " + getReturnDate() + "\n";
    	s = s + "The status is: " + getStatus() + "\n";
    	
    	return s;
    }
    


}*/


