package mainPackage;

public class UserObject{
	//Fields 
	private String Fname;
    private String Lname;
    private String Minitial;
    private String email;
    private int number;
    private String address;
    private String password;
    private String username;
    private String dob;
    private String isMember;
    private int dues;
    
    //Constructor
    public UserObject(String Fname, String Lname, String Minitial, String email, int number, String address, String password, String username, String dob, String isMember, int dues) {
    
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
    }
    
    //Methods
    
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
    
    public Integer getNumber() {
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
    
    public String getIsMember() {
    	return isMember;
    }
    
    public int getDues() {
    	return dues;
    }
}