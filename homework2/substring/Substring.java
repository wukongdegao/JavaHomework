package homework2.substring;

/*
 * @author 袁点 13130110031
 */

import java.util.*;

public class Substring 
{

	public static void main(String[] args) 
	{
		int a=0,b=0;
		Scanner in=new Scanner(System.in);
		String string=in.next();
		
		//如果所操作字符串想包括空格，需要加上双引号，则操作如下
		if(string.charAt(0)=='"')
		{
			string=string.substring(1);
			in.useDelimiter("\"");
			String string2=in.next();
			string=string.concat(string2);
			in.reset();
			in.next();
		}
		
		//判定输入是否错误
		if(in.hasNextInt())
		{
			a=in.nextInt();
			if(in.hasNextInt())
				b=in.nextInt();
		}
		else
		{
			in.close();
			System.out.println("input error!!");
			return ;
		}
		in.close();
		
		//判定输入数字是否错误，超出范围
		if(a>(string.length()-1)||b>(string.length()-a)||b==0)
			System.out.println("index or length error!!");
		else
		{
			for(int i=a;i<a+b;i++)
				System.out.print(string.charAt(i));
		}

	}

}
