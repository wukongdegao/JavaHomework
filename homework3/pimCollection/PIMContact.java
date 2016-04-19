package homework3.pimCollection;

/*
 * @author 袁点 13130110031
 */


public class PIMContact extends PIMEntity 
{
	
	private String firstName;
	private String lastName;
	private String emailAddress;
	
	
	//写入姓名
	public void setName(String first,String last)
	{
		firstName=first;
		lastName=last;
	}
	
	//写入email地址
	public void setEmail(String email)
	{
		emailAddress=email;
	}
	
	public void fromString(String s) 
	{
		String[] itemsInformation=s.split(" ");
		setName(itemsInformation[2], itemsInformation[3]);
		setEmail(itemsInformation[4]);
	}

	//打印描述
	public String toString()
	{
		return " CONTACT "+firstName+" "+lastName+" "+emailAddress;
	}

}
