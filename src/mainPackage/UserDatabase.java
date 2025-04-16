package mainPackage;

import java.io.*;
import java.util.*;

public class UserDatabase{
	//Fields
	private ArrayList<UserObject> userList; 
	
	//Constructor
	public UserDatabase(String filename) throws FileNotFoundException, NoSuchElementException { 
	
		userList = new ArrayList<>();
		fileRead fr = new fileRead(filename);
		for(int i  = 0; i < fr.getNumberOfLines(); i++) {
			
			String raw = fr.getLine(i);
			StringTokenizer st = new StringTokenizer(raw, "*");
			String Fname = st.nextToken();
			String Lname = st.nextToken();
			String Minitial = st.nextToken();
			String email = st.nextToken();
			String numberi = st.nextToken();
			Integer number = Integer.parseInt(numberi);
			String address = st.nextToken();
			String password = st.nextToken();
			String username = st.nextToken();
			String dob = st.nextToken();
			String isMember = st.nextToken();
			String duesi = st.nextToken();
			Integer dues = Integer.parseInt(duesi);
			UserObject newEnt = new UserObject(Fname, Lname, Minitial, email, number, address, password, username, dob, isMember, dues);
			userList.add(newEnt);
		}
			
		
	}
	
	// Methods
		public static void addEntry() throws IOException{
			fileWrite fw = new fileWrite("db.txt");
			keyboardInput b = new keyboardInput();
			
			String Fname;
			pn("Enter First Name: ");
			Fname = b.getKeyboardLine();
			while(Fname.length() < 3)
			{
				pn("First Name Must Be Longer Than Three Characters");
				pn("Enter First Name: ");
				Fname = b.getKeyboardLine();
			}
			
			
			String Lname;
			pn("Enter Last Name: ");
			Lname = b.getKeyboardLine();
			while(Lname.length() < 3)
			{
				pn("First Name Must Be Longer Than Three Characters");
				pn("Enter First Name: ");
				Lname = b.getKeyboardLine();
			}
			
			String Minitial = " ";
			pn("Enter Middle Initial (enter 0 for no initial: ");
			Minitial = b.getKeyboardLine();
			if(Minitial == "0") {
				Minitial = null;
			}
			
			String email;
			pn("Enter email: ");
			email = b.getKeyboardLine();
			while(email.length() < 3)
			{
				pn("Last Name Must Be Longer Than Three Characters");
				pn("Enter Last Name: ");
				email = b.getKeyboardLine();
			}
			
			String number;
			pn("Enter Number: ");
			number = b.getKeyboardLine();
			while(number.length() < 3)
			{
				pn("Number Must Be Longer Than Three Characters");
				pn("Enter Number: ");
				number = b.getKeyboardLine();
			}
			
			String address;
			pn("Enter Full Address: ");
			address = b.getKeyboardLine();
			while(address.length() < 3)
			{
				pn("Address Must Be Longer Than Three Characters");
				pn("Enter Address: ");
				address = b.getKeyboardLine();
			}
			
			String password;
			pn("Enter Password:");
			password = b.getKeyboardLine();
			while(password.length() < 8)
			{
				pn("Password Must Be Longer Than Eight Characters");
				pn("Enter Password: ");
				password = b.getKeyboardLine();
			}
			
			/*String passwordcheck = " ";
			while(password != passwordcheck) {
				pn("Re-enter password:");
				passwordcheck = b.getKeyboardLine();
				if(password == passwordcheck) {
					break;
				}
			}*/
			
			String username;
			pn("Enter Username: ");
			username = b.getKeyboardLine();
			while(username.length() < 7)
			{
				pn("First Name Must Be Longer Than Seven Characters");
				pn("Enter username: ");
				username = b.getKeyboardLine();
			}
			
			String dob = " ";
			pn("Enter Date Of Birth (mm/dd/yyyy): ");
			dob = b.getKeyboardLine();
			
			
			pn(" ");
			pn(" ");
			DBUtil.insertUser(Fname, Lname, Minitial, email, number, address, password, username, dob);
			//String newLine = (Fname + "*" + Lname + "*" + Minitial + "*" + email + "*" + number + "*" + address + "*" + password + "*" + username + "*" + dob);
			//fw.writeLine(newLine);
			//fw.saveFile();
		}
		
		
		//Grabs all of user information and displays it
		public void userDataList(ArrayList<String> dataList, int index) {
			
			dataList.add(userList.get(index).getFname());
			dataList.add(userList.get(index).getLname());
			dataList.add(userList.get(index).getMinitial());
			dataList.add(userList.get(index).getEmail());
			dataList.add(userList.get(index).getNumber().toString());
			dataList.add(userList.get(index).getAddress());
			dataList.add(userList.get(index).getPassword());
			dataList.add(userList.get(index).getUsername());
			dataList.add(userList.get(index).getDob());
			pn("Name: " + dataList.get(0) + " " + dataList.get(2) + " " + dataList.get(1) );
			pn("Email: " + dataList.get(3));
			pn("Number: " + dataList.get(4));
			pn("Address: " + dataList.get(5));
			pn("Password: " + dataList.get(6));
			pn("Username: " + dataList.get(7));
			pn("Date of Birth " + dataList.get(8));
			pn(" ");
			pn(" ");
		}
		
		
		//Search methods
		public static void searchByID(int id) {
			DBUtil.searchUserByID(id);
		}
		
		
		public void searchByName(String Fname, String Lname) {
			
			ArrayList<String> dataList = new ArrayList<>();
			int index = 0;
			boolean flag = false;
			for(int i = 0; i < userList.size(); i++) {
				
				String FnameData = userList.get(i).getFname();
				String LnameData = userList.get(i).getLname();
				if(Fname.equalsIgnoreCase(FnameData)) {
					flag = true;
					break;
				}
				if(Lname.equalsIgnoreCase(LnameData)) {
					flag = true;
					break;
				}
				index++;
			}
			pn(" ");
			if(flag == true) {
				
				userDataList(dataList, index);
				
			}
			else
			{
				userNotFound();
			}
			
		}
		
		
			@SuppressWarnings("unused")
			public void searchByEmail(String email) {
				
				ArrayList<String> dataList = new ArrayList<>();
				int index = 0;
				boolean flag = false;
				for(int i = 0; i < userList.size(); i++) {

					String emailData = userList.get(i).getEmail();
					if(email == emailData) {
						flag = true;
						break;
					}
						
				}
				
				if(flag = true) 
				{	
					userDataList(dataList, index);	
				}
				else
				{
					userNotFound();
				}
				
			}
			
			public void searchByNumber(String number) {
				ArrayList<String> dataList = new ArrayList<>();
				int index = 0;
				boolean flag = false;
				for(int i = 0; i < userList.size(); i++) {
					
					String numberData = userList.get(i).getNumber().toString();
					if(number == numberData)
					{
						flag = true;
						break;
					}
					
					if(flag == true) {
						userDataList(dataList, index);
					}
					else
					{
						userNotFound();
					}
				}
			}
			
			public void searchByAddress(String address) {
				ArrayList<String> dataList = new ArrayList<>();
				int index = 0;
				boolean flag = false;
				for(int i = 0; i < userList.size(); i++) {
					
					String addressData = userList.get(i).getAddress();
							if(address == addressData)
					{
						flag = true;
						break;
					}
					
					if(flag == true) {
						userDataList(dataList, index);
					}
					else
					{
						userNotFound();
					}
				}
			}
			
			public void searchByUsername(String username) {
				ArrayList<String> dataList = new ArrayList<>();
				int index = 0;
				boolean flag = false;
				for(int i = 0; i < userList.size(); i++) {
					
					String usernameData = userList.get(i).getUsername();
					if(username == usernameData)
					{
						flag = true;
						break;
					}
					
					if(flag == true) {
						userDataList(dataList, index);
					}
					else
					{
						userNotFound();
					}
				}
			}
			
			public void searchByDob(String dob) {
				ArrayList<String> dataList = new ArrayList<>();
				int index = 0;
				boolean flag = false;
				for(int i = 0; i < userList.size(); i++) {
					
					String dobData = userList.get(i).getDob();
					if(dob == dobData)
					{
						flag = true;
						break;
					}
					
					if(flag == true) {
						userDataList(dataList, index);
					}
					else
					{
						userNotFound();
					}
				}
			}

		
		
		
		public static void userNotFound() {		
			pn("User not found");
			pn(" ");
			pn(" ");
		}
		
		public static <E> void p(E item){
			System.out.print(item + " ");
		}
		
		/* Helper method for easy printing with line return */
		public static <E> void pn(E item){
			System.out.println(item);
		}
}