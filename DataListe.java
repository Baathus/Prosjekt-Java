import java.util.*;

public class DataListe {
	LinkedList<Data> liste = new LinkedList<Data>();
	
	public boolean nyData(Data n)
	{
		Iterator<Data> iter = liste.iterator();
		if( !datoEksisterer(n) )
		{
			while(iter.hasNext())
			{
				if(n.getDato().compareTo(iter.next().getDato()) < 0)
				{
					liste.add(n);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean tomListe()
	{
		Iterator<Data> iter = liste.iterator();
		
		if(iter.hasNext())
			return false;
		
		return true;
	}
	
	public boolean datoEksisterer(Data n)
	{
		Iterator<Data> iter = liste.iterator();
		
		while(iter.hasNext())
		{
			if(n.getDato().compareTo(iter.next().getDato()) == 0)
				return true;
		}
		return false;
	}
	
	public String skrivUtListe()
	{
		Iterator<Data> iter = liste.iterator();
		
		String retur = "Dato\tMinTemp\tMaxTemp\tNedbør ";
		
		while(iter.hasNext())
		{
			retur += iter.next().toString() +"\n";
		}
		
		return retur;
	}
}
