package homework3.pimCollection;

/*
 * @author Ԭ�� 13130110031
 */


import java.util.*;

public class PIMAppointment extends PIMEntity implements pimDate
{
	private Calendar date;
	private String text;
	
	
	//����ʱ��
	public void setDate(int year,int month,int day)
	{
		date=new GregorianCalendar(year, month, day);
	}
	
	//���е�ʱ���ӡ
	public String datePrint(Calendar d)
	{
		return d.get(Calendar.MONTH)+1+"/"+d.get(Calendar.DAY_OF_MONTH)+"/"+d.get(Calendar.YEAR);
	}
	
	//�õ�ʱ��
	public Calendar getDate()
	{
		return date;
	}
	
	//д���¼�����
	public void setText(String s)
	{
		text=s;
	}
	
	public void fromString(String s) 
	{
		String[] itemsInformation=s.split("\\s");
		Integer year=0,month=0,day=0;
		
		String[] str=itemsInformation[3].split("\\D");
		month=Integer.parseInt(str[0]);
		day=Integer.parseInt(str[1]);
		year=Integer.parseInt(str[2]);
		
		setPriority(itemsInformation[2]);
		date=new GregorianCalendar(year, month-1, day);
		setText(itemsInformation[4]);
	}
	
	//��ӡ����
	public String toString() 
	{
		return " APPOINTMENT "+Priority+" "+datePrint(date)+" "+text;
	}

}
