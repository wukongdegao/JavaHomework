package homework2.pims;



import java.io.*;

/*
 * @author Ԭ�� 13130110031
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
		//��ʼָ��
		while(true)
		{
			//���ָ����ʾ
			System.out.println("---Enter a command (suported "
			 + "commands are List Create Save Load Quit)---");
			String command=in.next();
			
			//Listָ��
			if(command.equals("List"))
			{
				System.out.println("There are "+Items.size()+" items.");
				if(!Items.isEmpty())
				{
					for(int i=1;i<=Items.size();i++)
						System.out.println("Item "+i+":"+Items.get(i-1));
				}
				
			}
			
			//Createָ��
			else if(command.equals("Create"))
			{
				System.out.println("Enter an item type ( todo, "
						    + "note, contact or appointment )");
				command=in.next();
				
				//����todo�¼�
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
					
					//�򵥼����������
					if(month>12||month<1||day>31||day<1)
					{
						System.out.println("input error!");
						continue;
					}
					
					//������Ϣ����ʵ����������arraylist��
					PIMTodo entity=new PIMTodo();
					entity.setDate(year, month-1, day);
					System.out.println("Enter todo text");
					entity.setText(in.nextLine());
					System.out.println("Enter todo priority:");
					entity.setPriority(in.next());
					Items.add(entity);
					
				}
				
				//����note�¼�
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
				
				//����appointment�¼�������todo�¼�
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
					//�򵥼����������
					if(month>12||month<1||day>31||day<1)
					{
						System.out.println("input error!");
						continue;
					}
					
					//������Ϣ����ʵ����������arraylist��
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
			
			//Saveָ��
			else if(command.equals("Save"))
			{
				try(PrintWriter out=new PrintWriter("save.dat"))
				{
					saveData(Items, out);
				}
				System.out.println("Items have been saved.");

			}
			
			//Loadָ��
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
			
			//Quitָ��
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
	
	//�洢ָ���
	private static void saveData(ArrayList<PIMEntity> entity,PrintWriter out) 
			throws IOException
	{
		for(PIMEntity e: entity)
		{
			out.println(e);
		}
	}
	
	//��ȡָ���
	private static void loadData(String load)
	{
		String[] itemsInformation=load.split("\\s");
		//�ж���Ҫ����ʲô�����¼�
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
