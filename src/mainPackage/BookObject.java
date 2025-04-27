package mainPackage;

public class BookObject {
	//Fields
	
	private String id;
    private String title;
    private String author;
    private String genre;
    private String publisher;
    private String ISBN;
    private String shelfLocation;
    private String releaseDate;
    private String status;
    
    //constructor
    public BookObject(Integer id, String title, String author, String genre, String publisher, String ISBN,
    		String shelfLocation, String releaseDate, String status) {
    	
    	this.id = Integer.toString(id);
    	this.title = title;
    	this.author = author;
    	this.ISBN = ISBN;
    	this.genre = genre;
    	this.publisher = publisher;
    	this.shelfLocation = shelfLocation;
    	this.releaseDate = releaseDate;
    	this.status = status;
    }
    
    //Methods
    public String getId() {
    	return id;
    }
    
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
    	return shelfLocation;
    }
    
    public String getReleaseDate() {
    	return releaseDate;
    }
    
    public String getStatus() {
    	return status;
    }
}