package mainPackage;

class Book{
	//Fields
	
    private String title;
    private String author;
    private String ISBN;
    private String genre;
    private String publisher;
    private String location;
    private int year;
    private boolean isAvailable;
    
    //constructor
    public Book(String title, String author, String ISBN, String genre, String publisher, String location, int year, boolean isAvailable) {
    	
    	this.title = title;
    	this.author = author;
    	this.ISBN = ISBN;
    	this.genre = genre;
    	this.publisher = publisher;
    	this.location = location;
    	this.year = year;
    	this.isAvailable = isAvailable;
    }
    
    //Methods
    public String getTitle() {
    	return title;
    }
    
    public String author() {
    	return author;
    }
    
    public String ISBN() {
    	return ISBN;
    }
    
    public String genre() {
    	return genre;
    }
    
    public String publisher() {
    	return publisher;
    }
    
    public String location() {
    	return location;
    }
    
    public int year() {
    	return year;
    }
    
    public boolean availability() {
    	return isAvailable;
    }
}