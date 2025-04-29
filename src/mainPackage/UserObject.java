package mainPackage;

public class UserObject{
	//Fields 
	private int id;
	private String Fname;
    private String Lname;
    private String Minitial;
    private String email;
    private String number;
    private String address;
    private String password;
    private String username;
    private String dob;
    private String membershipStatus;
    private int dues;
    private String isAdmin;
    
    //Constructor
    public UserObject(int id, String Fname, String Lname, String Minitial, String email, String number, String address, String password, String username, String dob, int dues, String membershipStatus, String isAdmin) {
    	
    	this.id = id;
    	this.Fname = Fname;
    	this.Lname = Lname;
    	this.Minitial = Minitial;
    	this.email = email;
    	this.number = number;
    	this.address = address;
    	this.password = password;
    	this.username = username;
    	this.dob = dob;
    	this.dues = dues;
    	this.membershipStatus = membershipStatus;
    	this.isAdmin = isAdmin;
    }
    
    //Methods
    public int getID() {
    	return id;
    }
    
    public String getFname() {
    	return Fname;
    }
    
    public String getLname() {
    	return Lname;
    }
    
    public String getMinitial() {
    	return Minitial;
    }
    
    public String getEmail() {
    	return email;
    }
    
    public String getNumber() {
    	return number;
    }
    
    public String getAddress() {
    	return address;
    }
    
    public String getPassword() {
    	return password;
    }
    
    public String getUsername() {
    	return username;
    }
    
    public String getDob() {
    	return dob;
    }
    
    public int getDues() {
    	return dues;
    }
    
    public String getMembershipStatus() {
    	return membershipStatus;
    }
    
    public String getAdminStatus() {
    	return isAdmin;
    }
}