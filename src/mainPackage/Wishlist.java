package mainPackage;
public class Wishlist
{
	//instance varibles
	private int wishId;
	private int userId;
	private int bookId;
	private String addedDate;
	
	
	//constructor method
	public Wishlist(int wishId, int userId, int bookId, String addedDate)
	{
		this.wishId = wishId;
		this.userId = userId;
		this.bookId = bookId;
		this.addedDate = addedDate;
	}

	//getter methods
	public int getWishId()
	{
		return this.wishId;
	}
	public int getUserId()
	{
		return userId;
	}
	public int getBookId()
	{
		return this.bookId;
	}
	public String getAddedDate()
	{
		return this.addedDate;
	}
	
	
	//setter methods
	public void setWishId(int newWishId)
	{
		this.wishId = newWishId;
	}
	public void setUserId(int newUserId)
	{
		this.userId = newUserId;
	}
	public void setBookId(int newBookId)
	{
		this.bookId = newBookId;
	}
	public void setDateAdded(String newAddedDate)
	{
		this.addedDate = newAddedDate;
	}
	//toString method that creates a String of all the information
	public String toString()
	{
		String s = "";
		s = s + "Wish Id: " + getWishId() + "\n";
		s = s + "User Id: " + getUserId() + "\n";
		s = s + "Book Id: " + getBookId() + "\n";
		s = s + "Added date: " + getAddedDate() + "\n";
		
		return s;
	}
}

