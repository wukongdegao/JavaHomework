package homework1;


/*
 * @author Ô¬µã 13130110031
 */

import java.util.*;

public class CourseSelectingTest {

	public static void main(String[] args) 
	{
		Student student1;
		Scanner in=new Scanner(System.in);
		if(in.hasNext())
		{
			student1=new Student(in.next());
			String get=in.nextLine();
			String information[]=get.split("\\s");
			for(int i=1;i<information.length;i++)
				student1.addCourse(new Course(information[i]));
			System.out.println(student1);
			in.close();
		}
		
	}

}

class Student
{
	//Ñ§ºÅ£¬¿Î³Ì
	private String ID;
	private ArrayList<Course> courses;
	private ArrayList<Books> books;
	
	public Student()
	{
		courses=new ArrayList<>();
		ID="default";
	}
	
	public Student(String id)
	{
		courses=new ArrayList<>();
		ID=id;
	}
	
	public Student(String id,Course[] course)
	{
		courses=new ArrayList<>();
		ID=id;
		for(Course c:course)
		{
			courses.add(c);
		}
	}
	
	public String getID()
	{
		return ID;
	}
	
	public void addCourse(Course c)
	{
		courses.add(c);
	}
	
	public void addBook(Books b)
	{	
			books.add(b);
	}
	
	public String toString()
	{
		String string;
		if(courses.isEmpty())
			return getID()+" not choose any courses";
		if(courses.size()==1)
			return getID()+" choose "+courses.get(0).getName();
		string=new String(getID()+" choose ");
		for(int i=0;i<courses.size()-1;i++)
			string=string.concat(courses.get(i).getName()+" ");
		string=string.concat("and "+courses.get(courses.size()-1).getName());
		return string;
	}
}

class Course
{
	private String courseName;
	
	public Course(String name)
	{
		courseName=name;
	}
	
	public String getName()
	{
		return courseName;
	}
	
}

class Books
{
	private String bookName;
	
	public Books(String name)
	{
		bookName=name;
	}
	
	public String getName()
	{
		return bookName;
	}
}