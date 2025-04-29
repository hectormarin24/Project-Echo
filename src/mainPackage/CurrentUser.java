package mainPackage;


public class CurrentUser{

	private static UserObject currentUser;
	
	
	public static void set(UserObject u) {
		currentUser = u;
	}
	
	public static UserObject get() {
		return currentUser;
	}
	
}

