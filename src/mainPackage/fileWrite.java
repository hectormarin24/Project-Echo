/* READ THIS!: The idea behind this class is that we save the "writeBuffer" in memory but do not actually write the file to disk 
 * until someone calls the "saveFile" method. The reason for this is for performance and to prevent keeping an open file pointer 
 * (which is poor form and risky) */

package mainPackage;

import java.io.*;
import java.util.ArrayList;

public class fileWrite {
	// Fields
	private ArrayList<String> writeBuffer;
	private String filename;
	
	// Constructor
	public fileWrite(String filename){
		this.filename = filename;			// Save filename for later
		writeBuffer = new ArrayList<>();
	}
	
	//Methods
	public void writeLine(String newLine) throws FileNotFoundException{
		writeBuffer.add(newLine);
	}
	
	public void saveFile() throws IOException{
		FileWriter myWriter = new FileWriter(filename, true);
		int i = writeBuffer.size() - 1;
		myWriter.write("\n" +  writeBuffer.get(i));
		myWriter.close();
		
	}
}
