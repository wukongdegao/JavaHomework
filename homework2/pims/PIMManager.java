package homework2.pims;



import java.io.*;

/*
 * @author 袁点 13130110031
 */


import java.util.*;

public class PIMManager 
{
	private static ArrayList<PIMEntity> Items;

	public static void main(String[] args) throws IOException
	{
		Scanner in=new Scanner(System.in);
		Items=new ArrayList<>();
		
		System.out.println("Welcome to PIM.");
		//开始指令
		while(true)
		{
			//输出指令提示
			System.out.println("---Enter a command (suported "
			 + "commands are List Create Save Load Quit)---");
			String command=in.next();
			
			//List指令
			if(command.equals("List"))
			{
				System.out.println("There are "+Items.size()+" items.");
				if(!Items.isEmpty())
				{
					for(int i=1;i<=Items.size();i++)
						System.out.println("Item "+i+":"+Items.get(i-1));
				}
				
			}
			
			//Create指令
			else if(command.equals("Create"))
			{
				System.out.println("Enter an item type ( todo, "
						    + "note, contact or appointment )");
				command=in.next();
				
				//创建todo事件
				if(command.equals("todo"))
				{
					
					Integer year=0,month=0,day=0;
					System.out.println("Enter date for todo item as month/day/year:");
					
					in.nextLine();
					String date=in.nextLine();
					
					String[] str=date.split("\\D");
					month=Integer.parseInt(str[0]);
					day=Integer.parseInt(str[1]);
					year=Integer.parseInt(str[2]);
					
					//简单检查输入日期
					if(month>12||month<1||day>31||day<1)
					{
						System.out.println("input error!");
						continue;
					}
					
					//根据信息创建实例，并加入arraylist中
					PIMTodo entity=new PIMTodo();
					entity.setDate(year, month-1, day);
					System.out.println("Enter todo text");
					entity.setText(in.nextLine());
					System.out.println("Enter todo priority:");
					entity.setPriority(in.next());
					Items.add(entity);
					
				}
				
				//创建note事件
				else if(command.equals("note"))
				{
					in.nextLine();
					System.out.println("Enter note text:");
					PIMNote entity=new PIMNote();
					entity.setText(in.nextLine());
					System.out.println("Enter note priority:");
					entity.setPriority(in.next());
					Items.add(entity);
				}
				
				//创建appointment事件，类似todo事件
				else if(command.equals("appointment"))
				{
					int year,month,day;
					System.out.println("Enter date for appointment item as month/day/year:");
					
					in.nextLine();
					String get=in.nextLine();
					
					String[] str=get.split("\\D");
					month=Integer.parseInt(str[0]);
					day=Integer.parseInt(str[1]);
					year=Integer.parseInt(str[2]);
					//简单检查输入日期
					if(month>12||month<1||day>31||day<1)
					{
						System.out.println("input error!");
						continue;
					}
					
					//根据信息创建实例，并加入arraylist中
					PIMAppointment entity=new PIMAppointment();
					entity.setDate(year, month-1, day);
					System.out.println("Enter appointment text:");
					entity.setText(in.nextLine());
					System.out.println("Enter appointment priority:");
					entity.setPriority(in.next());
					Items.add(entity);
				}
				
				else if(command.equals("contact"))
				{
					System.out.println("Enter name for contact item:");
					PIMContact entity=new PIMContact();
					entity.setName(in.next(), in.next());
					in.nextLine();
					System.out.println("Enter email address:");
					entity.setEmail(in.nextLine());
					Items.add(entity);
				}
				
				else
				{
					System.out.println("error command!");
				}
			}
			
			//Save指令
			else if(command.equals("Save"))
			{
				try(PrintWriter out=new PrintWriter("save.dat"))
				{
					saveData(Items, out);
				}
				System.out.println("Items have been saved.");

			}
			
			//Load指令
			else if(command.equals("Load"))
			{
				try(Scanner load=new Scanner(new FileInputStream("save.dat")))
				{
					Items=new ArrayList<>();
					while(load.hasNextLine())
					{
						loadData(load.nextLine());
					}
					System.out.println("Load successed");
				}
				catch (FileNotFoundException e) 
				{
					System.out.println("Can not found save file");
				}
			}
			
			//Quit指令
			else if(command.equals("Quit"))
			{
				in.close();
				break;
			}
			
			
			else
			{
				System.out.println("error command!");
			} 
			
		}
	}
	
	//存储指令函数
	private static void saveData(ArrayList<PIMEntity> entity,PrintWriter out) 
			throws IOException
	{
		for(PIMEntity e: entity)
		{
			out.println(e);
		}
	}
	
	//读取指令函数
	private static void loadData(String load)
	{
		String[] itemsInformation=load.split("\\s");
		//判断需要创建什么类型事件
		if(itemsInformation[1].equals("TODO"))
		{
			PIMTodo entity=new PIMTodo();
			entity.fromString(load);
			Items.add(entity);
		}
		
		else if(itemsInformation[1].equals("NOTE"))
		{
			PIMNote entity=new PIMNote();
			entity.fromString(load);
			Items.add(entity);
		}
		
		else if(itemsInformation[1].equals("APPOINTMENT"))
		{
			PIMAppointment entity=new PIMAppointment();
			entity.fromString(load);
			Items.add(entity);
		}
		
		else if(itemsInformation[1].equals("CONTACT"))
		{
			PIMContact entity=new PIMContact();
			entity.fromString(load);
			Items.add(entity);
		}
		
		else
		{
			System.out.println("Load error!");
			
		}
		
	}

}
