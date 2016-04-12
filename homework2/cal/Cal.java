package homework2.cal;

/*
 * @author 袁点 13130110031
 */

import java.text.DateFormatSymbols;
import java.util.*;

public class Cal 
{
	public static void main(String[] args) 
	{
		//定义年，月，日历
		int month;
		int year;
		GregorianCalendar d;
		
		//得到星期，月份名称
		String[] monthName=new DateFormatSymbols(Locale.ENGLISH).getMonths();
		String[] weekdayName={" ","Su","Mo","Tu","We","Th","Fr","Sa"};
		
		Scanner in=new Scanner(System.in);
		//改变分隔符，使当直接回车时返回当前月日历
		in.useDelimiter("");
		//判断输入，初始化日历实例
		if(!in.hasNext("\n")&&in.hasNextInt())
		{
			//回复默认分隔符
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
		
		//设置d为当前月1号，且得到1号为星期几，以及当前地区星期第一天
		d.set(Calendar.DAY_OF_MONTH, 1);
		int weekday=d.get(Calendar.DAY_OF_WEEK);
		int firstDayofWeek=d.getFirstDayOfWeek();
		
		//得到输出时需要缩进多少 ，直到该星期第一天
		int indent=0;
		while(weekday!=firstDayofWeek)
		{
			indent++;
			d.add(Calendar.DAY_OF_MONTH, -1);
			weekday=d.get(Calendar.DAY_OF_WEEK);
		}
		
		//打印日期，年份,星期缩写
		System.out.println(monthName[month]+"   "+year);
		do {
			System.out.printf("%-7s",weekdayName[weekday]);
			d.add(Calendar.DAY_OF_MONTH,1);
			weekday=d.get(Calendar.DAY_OF_WEEK);
		} while (weekday!=firstDayofWeek);
		System.out.println();
		
		//打印1号之前的空格，设置日期为1号
		for(int i=0;i<indent ;i++)
			System.out.print("       ");
		d.set(Calendar.DAY_OF_MONTH,1);

		//开始打印日期
		do {
			int day=d.get(Calendar.DAY_OF_MONTH);
			System.out.printf("%-7d",day);
			d.add(Calendar.DAY_OF_MONTH,1);
			weekday=d.get(Calendar.DAY_OF_WEEK);
			//到星期第一天换行
			if(weekday==firstDayofWeek)
				System.out.println();
		} while (d.get(Calendar.MONTH)==month );
		in.close();
		
	}

}
