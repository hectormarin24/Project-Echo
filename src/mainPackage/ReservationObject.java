package mainPackage;

public class ReservationObject {
	private String id;
	private String userId;
	private String bookId;
	private String resDate;
	private String status;
	
	//Constructor
	public ReservationObject(Integer id, Integer userId, Integer bookId, String resDate, String status) {
		this.id = Integer.toString(id);
		this.userId = Integer.toString(userId);
		this.bookId = Integer.toString(bookId);
		this.resDate = resDate;
		this.status = status;
	}
	
	//Getters
	public String getId() {
		return id;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public String getBookId() {
		return bookId;
	}
	
	public String getResDate() {
		return resDate;
	}
	
	public String getStatus() {
		return status;
	}
}
