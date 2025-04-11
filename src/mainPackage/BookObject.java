package mainPackage;

class BookObject{
	//Fields
	
    private String title;
    private String author;
    private String ISBN;
    private String genre;
    private String publisher;
    private String location;
    private int year;
    private String isAvailable;
    
    //constructor
    public BookObject(String title, String author, String ISBN, String genre, String publisher, String location, int year, String isAvailable) {
    	
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
    
    public String getAuthor() {
    	return author;
    }
    
    public String getISBN() {
    	return ISBN;
    }
    
    public String getGenre() {
    	return genre;
    }
    
    public String getPublisher() {
    	return publisher;
    }
    
    public String getLocation() {
    	return location;
    }
    
    public Integer getYear() {
    	return year;
    }
    
    public String getAvailability() {
    	return isAvailable;
    }
}