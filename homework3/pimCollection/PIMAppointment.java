package homework3.pimCollection;

/*
 * @author 袁点 13130110031
 */


import java.util.*;

public class PIMAppointment extends PIMEntity implements pimDate
{
	private Calendar date;
	private String text;
	
	
	//设置时间
	public void setDate(int year,int month,int day)
	{
		date=new GregorianCalendar(year, month, day);
	}
	
	//特有的时间打印
	public String datePrint(Calendar d)
	{
		return d.get(Calendar.MONTH)+1+"/"+d.get(Calendar.DAY_OF_MONTH)+"/"+d.get(Calendar.YEAR);
	}
	
	//得到时间
	public Calendar getDate()
	{
		return date;
	}
	
	//写入事件描述
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
	
	//打印描述
	public String toString() 
	{
		return " APPOINTMENT "+Priority+" "+datePrint(date)+" "+text;
	}

}
