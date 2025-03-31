package mainPackage;

import java.io.*;
import java.util.*;




public class BookDatabase{
	//Fields
	private ArrayList<BookObject> bookList;
	
	//Constructor
	public BookDatabase(String filename) throws FileNotFoundException, NoSuchElementException
	{
		bookList = new ArrayList<>();
		fileRead fr = new fileRead(filename);
		for(int i = 0; i < fr.getNumberOfLines(); i++){
			String raw = fr.getLine(i);
			StringTokenizer st = new StringTokenizer(raw, "*");
			String title = st.nextToken();
			String author = st.nextToken();
			String ISBN = st.nextToken();
			String genre = st.nextToken();
			String publisher = st.nextToken();
			String location = st.nextToken();
			String yeari = st.nextToken();
			Integer year = Integer.parseInt(yeari);
			String isAvailable = st.nextToken();
			BookObject newEnt = new BookObject(title, author, ISBN, genre, publisher, location, year, isAvailable);
			bookList.add(newEnt);
		}
		
	}
	
	// Methods
	public void addEntry() throws IOException{
		fileWrite fw = new fileWrite("db.txt");
		keyboardInput b = new keyboardInput();
		
		String title = " ";
		pn("Enter Title: ");
		title = b.getKeyboardLine();
		while(title.length() < 3)
		{
			pn("Title Must Be Longer Than Three Characters");
			pn("Enter Title: ");
			title = b.getKeyboardLine();
		}
		
		p("\nEnter Author: ");
		b.getKeyboardLine();
		String author = b.getKeyboardLine();
		
		p("\nEnter ISBN: ");
		b.getKeyboardLine();
		String ISBN = b.getKeyboardLine();
		
		p("\nEnter Genre: ");
		b.getKeyboardLine();
		String genre = b.getKeyboardLine();
		
		p("\nEnter Publisher: ");
		b.getKeyboardLine();
		String publisher = b.getKeyboardLine();
		
		p("\nEnter Location: ");
		b.getKeyboardLine();
		String location = b.getKeyboardLine();
		
		Integer year = 0;
		pn("Enter Year: ");
		year = b.getKeyboardInt();		
				
		String isAvailable;
		pn("Is the book available? (Enter \"Yes\" or \"No\" ONLY)");
		isAvailable = b.getKeyboardLine();
		
		String newLine = (title + "*" + author + "*" + ISBN + "*" + genre + "*" + publisher + "*" + location + "*" + year + "*" + isAvailable);
		fw.writeLine(newLine);
		fw.saveFile();
	}
	
	public void searchByTitle(String title) 
	{
		ArrayList<String> dataList = new ArrayList<>();
		int index = 0;
		boolean flag = false;
		for(int i = 0; i < bookList.size(); i++)
		{
			String data = bookList.get(i).getTitle();
			if(title.equalsIgnoreCase(data))
			{
				flag  = true;
				break;
			}
			index++;
		}
		pn(" ");
		if(flag == true) {
		
			dataList.add(bookList.get(index).getAuthor());
			dataList.add(bookList.get(index).getISBN());
			dataList.add(bookList.get(index).getGenre());
			dataList.add(bookList.get(index).getPublisher());
			dataList.add(bookList.get(index).getLocation());
			dataList.add(bookList.get(index).getYear().toString());
			dataList.add(bookList.get(index).getAvailability());
			pn("Author: \t" + dataList.get(0));
			pn("ISBN: \t" + dataList.get(1));
			pn("Genre: \t" + dataList.get(2));
			pn("Publisher: \t" + dataList.get(3));
			pn("Location: \t" + dataList.get(4));
			pn("Year: \t" + dataList.get(5));
			pn("Available? \t" + dataList.get(6));
			pn(" ");
			pn(" ");
		}
		
		else 
		{
			pn("Title Not Found....");
			pn(" ");
			pn(" ");
		}
		
		
	}
	
	/*public void searchByAuthor(String author){
		ArrayList<String> dataList = new ArrayList<>();
		for(int i = 0; i < bookList.size(); i++)
		{
			String data = bookList.get(i).getActor1();
			String data1 = bookList.get(i).getActor2();
			if(actor.equalsIgnoreCase(data) || actor.equalsIgnoreCase(data1))
			{
				dataList.add(bookList.get(i).getTitle());
			}
		}
		if(dataList.size() > 0) {
			pn("");
			for(int i = 0; i < dataList.size(); i++)
			{
				pn(dataList.get(i));
			}
			pn("");
			pn("");
		}
		else
		{
			pn("");
			pn("No titles found for actor");
			pn("");
			pn("");

		}
		
	}
	
	public void searchByDirector(String director){
		ArrayList<String> dataList = new ArrayList<>();
		for(int i = 0; i < movieList.size(); i++)
		{
			String data = movieList.get(i).getDirector();
			if(director.equalsIgnoreCase(data))
			{
				dataList.add(movieList.get(i).getTitle());
			}
		}
		if(dataList.size() > 0) {
			for(int i = 0; i < dataList.size(); i++)
			{
				pn(dataList.get(i));
			}
			pn("");
			pn("");

		}
		else
		{
			pn("No titles found for director");
			pn("");
			pn("");

		}
	}
	
	public void searchByYear(int year){
		ArrayList<String> dataList = new ArrayList<>();
		for(int i = 0; i < movieList.size(); i++)
		{
			int data = movieList.get(i).getYear();
			if(year == data)
			{
				dataList.add(movieList.get(i).getTitle());
			}
		}
		if(dataList.size() > 0) {
			for(int i = 0; i < dataList.size(); i++)
			{
				pn(dataList.get(i) + " ");
			}
			pn("");
			pn("");

		}
		else
		{
			pn("No titles found for year");
			pn("");
			pn("");

		}
	}
	
	public void searchByRuntime(int runtime){
		ArrayList<String> dataList = new ArrayList<>();
		for(int i = 0; i < movieList.size(); i++)
		{
			int data = movieList.get(i).getRuntime();
			if(runtime == data)
			{
				dataList.add(movieList.get(i).getTitle());
			}
		}
		if(dataList.size() > 0) {
			for(int i = 0; i < dataList.size(); i++)
			{
				pn(dataList.get(i) + " ");
			}
			pn("");
			pn("");

		}
		else
		{
			pn("No titles found for runtime");
			pn("");
			pn("");

		}
	}*/
	/* Helper method for easy printing on same line */
	public static <E> void p(E item){
		System.out.print(item + " ");
	}
	
	/* Helper method for easy printing with line return */
	public static <E> void pn(E item){
		System.out.println(item);
	}
}