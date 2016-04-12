package homework1;


/*
 * @author Ô¬µã 13130110031
 */

import java.util.*;

public class SumOfArgs {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int sum=0;
		String get=in.nextLine();
		String[] str=get.split("\\D");
		for(int i=0;i<str.length;i++)
		{
			if(!"".equals(str[i]))
			sum+= Integer.parseInt(str[i]);
		}
		System.out.print(sum);
		in.close();
	}

}
