package mainPackage;

import java.util.Scanner;

public class keyboardInput {
	// Fields
	private Scanner kb;
	
	// Constructor
	public keyboardInput(){
		kb = new Scanner(System.in);
	}
	
	// Methods
	public String getKeyboardLine(){
		String getKeyboardLine = kb.nextLine();
		return getKeyboardLine;
	}
	
	public int getKeyboardInt() {
		int getKeyboardInt = kb.nextInt();
		return getKeyboardInt;
	}
	
	public boolean getKeyboardBoolean() {
		boolean getKeyboardBoolean = kb.nextBoolean();
		return getKeyboardBoolean;
	}
	
	/* Call this method before you exit the program! Do NOT close the scanner object inside of getKeyboardLine method! */
	public void closeKeyboard(){
		kb.close();
	}
}
