package mainPackage;
//I didn't see a Date class, so I made one with just the basic month, date, and year numbers
class DateNumber
{
	public int month;
	public int day;
	public int year;

	
	//construcor method
	public DateNumber(int month, int day, int year)
	{
		this.month = month;
		this.day = day;
		this.year = year;
		
	}
	
	//setter methods
	public void setDay(int newDay)
	{
		this.day = newDay;
	}
	public void setMonth(int newMonth)
	{
		this.month = newMonth;
	}
	public void setYear(int newYear)
	{
		this.year = newYear;
	}
	//Getter Methods
	public int getDay()
	{
		return this.day;
	}
	public int getMonth()
	{
		return this.month;
	}
	public int getYear()
	{
		return this.year;
	}


	//creates a string of the date in a readable form.
	/* There are many different ways to read it, so I created a toSting for each different way. 
	 The 1st is the standard American number way.
	 The 2nd is if you want to read it the European number way.
	 * */
	public String toString()
	{
		String s = "";
		s = this.month + "/" + this.day + "/" + this.year;
		return s;
	}
	public String toStringEurope()
	{
		String s = "";
		s= this.day + "/" + this.month + "/" + this.year;
		return s;
	}

}