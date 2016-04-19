package homework3.pimCollection;

import java.util.*;


@SuppressWarnings("serial")
public class PIMCollection extends ArrayList<PIMEntity> 
{
	public PIMCollection(ArrayList<PIMEntity> pim)
	{
		for(PIMEntity e:pim)
			add(e);
	}
	
	public PIMCollection(){}
	
	public Collection getNotes()
	{
		PIMCollection noteCollection;
		noteCollection=new PIMCollection();
		for(PIMEntity e:this)
		{
			if(e.getClass().equals(new PIMNote().getClass()))
				noteCollection.add(e);
		}
		
		return noteCollection;
	}
	
	public Collection getTodos()
	{
		PIMCollection todoCollection;
		todoCollection=new PIMCollection();
		for(PIMEntity e:this)
		{
			if(e.getClass().equals(new PIMTodo().getClass()))
				todoCollection.add(e);
		}
		
		return todoCollection;
	}
	
	public Collection getAppointments()
	{
		PIMCollection appointmentCollection;
		appointmentCollection=new PIMCollection();
		for(PIMEntity e:this)
		{
			if(e.getClass().equals(new PIMAppointment().getClass()))
				appointmentCollection.add(e);
		}
		
		return appointmentCollection;
	}
	
	public Collection getContacts()
	{
		PIMCollection contactCollection;
		contactCollection=new PIMCollection();
		for(PIMEntity e:this)
		{
			if(e.getClass().equals(new PIMContact().getClass()))
				contactCollection.add(e);
		}
		
		return contactCollection;
	}
	
	public Collection getItemsForDate(Calendar d)
	{
		PIMCollection forDateCollection;
		forDateCollection=new PIMCollection();
		for(PIMEntity e:this)
		{
				if(e instanceof pimDate)
				{
					
					if(((pimDate) e).getDate().equals(d))
						forDateCollection.add(e);
						
				}
		}
		
		return forDateCollection;
	}
}
