package mainPackage;

import java.io.*;
import java.util.*;

public class fileRead {
	// Fields
	private ArrayList<String> lines;
	// Constructor
	public fileRead(String filename) throws FileNotFoundException
	{
		lines = new ArrayList<>();
		File perm = new File(filename);
		Scanner wr = new Scanner(perm);
		
		while(wr.hasNextLine())
		{
			if(wr.hasNextLine())
				lines.add(wr.nextLine());
		}
		wr.close();
		}
	
	// Methods
	public int getNumberOfLines(){
		return lines.size();
	}
	
	public String getLine(int index){
		return lines.get(index);
		
	}
}
