package homework2.pims;

/*
 * @author Ԭ�� 13130110031
 */


import java.util.*;

public class PIMTodo extends PIMEntity implements pimDate
{
	private Calendar date;
	private String text;
		
	//���е�ʱ���ӡ
	public String datePrint(Calendar d)
	{
		return d.get(Calendar.MONTH)+1+"/"+d.get(Calendar.DAY_OF_MONTH)+"/"+d.get(Calendar.YEAR);
	}
	
	//����ʱ��
	public void setDate(int year,int month,int day)
	{
		date=new GregorianCalendar(year, month, day);
	}
	
	//д���¼�����
	public void setText(String s)
	{
		text=s;
	}
	
	//��������Ϣ�������¼���������
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
	
	//�¼��ı���
	public String toString() 
	{
		return " TODO "+Priority+" "+datePrint(date)+" "+text;
	}
	
	//���ַ�������ȡ������Ϣ
	public static void getDate(String date,Integer month,Integer day,Integer year)
	{
		String[] str=date.split("\\D");
		month=Integer.parseInt(str[0]);
		day=Integer.parseInt(str[1]);
		year=Integer.parseInt(str[2]);
	}

}
