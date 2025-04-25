package mainPackage;

public class UserObject{
	//Fields 
	private String id;
	private String Fname;
    private String Lname;
    private String Minitial;
    private String email;
    private String number;
    private String address;
    private String password;
    private String username;
    private String dob;
    private String dues;
    
    //Constructor
    public UserObject(int id, String Fname, String Lname, String Minitial, String email, String number, String address, String password, String username, String dob, int dues) {
    	
    	this.id = Integer.toString(id);
    	this.Fname = Fname;
    	this.Lname = Lname;
    	this.Minitial = Minitial;
    	this.email = email;
    	this.number = number;
    	this.address = address;
    	this.password = password;
    	this.username = username;
    	this.dob = dob;
    	this.dues = Integer.toString(dues);
    }
    
    //Methods
    public String getID() {
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
    
    public String getDues() {
    	return dues;
    }
}