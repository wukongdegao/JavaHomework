package homework2.cal;

/*
 * @author Ԭ�� 13130110031
 */

import java.text.DateFormatSymbols;
import java.util.*;

public class Cal 
{
	public static void main(String[] args) 
	{
		//�����꣬�£�����
		int month;
		int year;
		GregorianCalendar d;
		
		//�õ����ڣ��·�����
		String[] monthName=new DateFormatSymbols(Locale.ENGLISH).getMonths();
		String[] weekdayName={" ","Su","Mo","Tu","We","Th","Fr","Sa"};
		
		Scanner in=new Scanner(System.in);
		//�ı�ָ�����ʹ��ֱ�ӻس�ʱ���ص�ǰ������
		in.useDelimiter("");
		//�ж����룬��ʼ������ʵ��
		if(!in.hasNext("\n")&&in.hasNextInt())
		{
			//�ظ�Ĭ�Ϸָ���
			in.reset();
			month=in.nextInt();
			if(in.hasNextInt())
			{
				year=in.nextInt();
				if(month>=1&&month<=12)
					d=new GregorianCalendar(year, month-1, 1);
				else
					d=new GregorianCalendar();
			}
			else
				d=new GregorianCalendar();
		}
		else
			d=new GregorianCalendar();
		
		month=d.get(Calendar.MONTH);
		year=d.get(Calendar.YEAR);
		
		//����dΪ��ǰ��1�ţ��ҵõ�1��Ϊ���ڼ����Լ���ǰ�������ڵ�һ��
		d.set(Calendar.DAY_OF_MONTH, 1);
		int weekday=d.get(Calendar.DAY_OF_WEEK);
		int firstDayofWeek=d.getFirstDayOfWeek();
		
		//�õ����ʱ��Ҫ�������� ��ֱ�������ڵ�һ��
		int indent=0;
		while(weekday!=firstDayofWeek)
		{
			indent++;
			d.add(Calendar.DAY_OF_MONTH, -1);
			weekday=d.get(Calendar.DAY_OF_WEEK);
		}
		
		//��ӡ���ڣ����,������д
		System.out.println(monthName[month]+"   "+year);
		do {
			System.out.printf("%-7s",weekdayName[weekday]);
			d.add(Calendar.DAY_OF_MONTH,1);
			weekday=d.get(Calendar.DAY_OF_WEEK);
		} while (weekday!=firstDayofWeek);
		System.out.println();
		
		//��ӡ1��֮ǰ�Ŀո���������Ϊ1��
		for(int i=0;i<indent ;i++)
			System.out.print("       ");
		d.set(Calendar.DAY_OF_MONTH,1);

		//��ʼ��ӡ����
		do {
			int day=d.get(Calendar.DAY_OF_MONTH);
			System.out.printf("%-7d",day);
			d.add(Calendar.DAY_OF_MONTH,1);
			weekday=d.get(Calendar.DAY_OF_WEEK);
			//�����ڵ�һ�컻��
			if(weekday==firstDayofWeek)
				System.out.println();
		} while (d.get(Calendar.MONTH)==month );
		in.close();
		
	}

}
