package homework3.pimCollection;

/*
 * @author Ԭ�� 13130110031
 */

import java.util.*;


@SuppressWarnings("serial")
public class PIMCollection<E> extends ArrayList<E> 
{
	//��ԭ�м�����Ԫ�ع���PIMCollection
	public PIMCollection(Collection<E> pim)
	{
		for(E e:pim)
			add(e);
	}
	
	public PIMCollection(){}
	
	//�����ж�collection��Ԫ�����Ƿ�����Ҫ�õ��࣬���뼯�ϣ�����
	public Collection<E> getNotes()
	{
		PIMCollection<E> noteCollection;
		noteCollection=new PIMCollection<E>();
		for(E e:this)
		{
			if(e.getClass().equals(new PIMNote().getClass()))
				noteCollection.add(e);
		}
		
		return noteCollection;
	}
	
	public Collection<E> getTodos()
	{
		PIMCollection<E> todoCollection;
		todoCollection=new PIMCollection<E>();
		for(E e:this)
		{
			if(e.getClass().equals(new PIMTodo().getClass()))
				todoCollection.add(e);
		}
		
		return todoCollection;
	}
	
	public Collection<E> getAppointments()
	{
		PIMCollection<E> appointmentCollection;
		appointmentCollection=new PIMCollection<E>();
		for(E e:this)
		{
			if(e.getClass().equals(new PIMAppointment().getClass()))
				appointmentCollection.add(e);
		}
		
		return appointmentCollection;
	}
	
	public Collection<E> getContacts()
	{
		PIMCollection<E> contactCollection;
		contactCollection=new PIMCollection<E>();
		for(E e:this)
		{
			if(e.getClass().equals(new PIMContact().getClass()))
				contactCollection.add(e);
		}
		
		return contactCollection;
	}
	
	public Collection<E> getItemsForDate(Calendar d)
	{
		PIMCollection<E> forDateCollection;
		forDateCollection=new PIMCollection<E>();
		for(E e:this)
		{
			//�ж�e�Ƿ�ʵ��pimDate�ӿ�
				if(e instanceof pimDate)
				{
					
					if(((pimDate) e).getDate().equals(d))
						forDateCollection.add(e);
						
				}
		}
		
		return forDateCollection;
	}
}
