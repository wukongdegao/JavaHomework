package homework3.pimCollection;

/*
 * @author Ԭ�� 13130110031
 */


public class PIMContact extends PIMEntity 
{
	
	private String firstName;
	private String lastName;
	private String emailAddress;
	
	
	//д������
	public void setName(String first,String last)
	{
		firstName=first;
		lastName=last;
	}
	
	//д��email��ַ
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

	//��ӡ����
	public String toString()
	{
		return " CONTACT "+firstName+" "+lastName+" "+emailAddress;
	}

}
