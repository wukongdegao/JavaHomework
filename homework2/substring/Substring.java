package homework2.substring;

/*
 * @author Ԭ�� 13130110031
 */

import java.util.*;

public class Substring 
{

	public static void main(String[] args) 
	{
		int a=0,b=0;
		Scanner in=new Scanner(System.in);
		String string=in.next();
		
		//����������ַ���������ո���Ҫ����˫���ţ����������
		if(string.charAt(0)=='"')
		{
			string=string.substring(1);
			in.useDelimiter("\"");
			String string2=in.next();
			string=string.concat(string2);
			in.reset();
			in.next();
		}
		
		//�ж������Ƿ����
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
		
		//�ж����������Ƿ���󣬳�����Χ
		if(a>(string.length()-1)||b>(string.length()-a)||b==0)
			System.out.println("index or length error!!");
		else
		{
			for(int i=a;i<a+b;i++)
				System.out.print(string.charAt(i));
		}

	}

}
