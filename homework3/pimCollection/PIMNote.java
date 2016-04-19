package homework3.pimCollection;


/*
 * @author Ô¬µã 13130110031
 */


public class PIMNote extends PIMEntity 
{
	private String text;
	

	public void setText(String s)
	{
		text=s;
	}
	
	public void fromString(String s) 
	{
		String[] itemsInformation=s.split(" ");
		setPriority(itemsInformation[2]);
		setText(itemsInformation[3]);

	}
	
	
	public String toString() 
	{
		return " NOTE "+Priority+" "+text;
	}

}
