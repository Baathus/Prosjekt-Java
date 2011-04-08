package Lister;

public class DataListe2 {
	
	Data første;
	
	public boolean nyData(Data n)
	{	
		if(første == null)//hvis første er null, blir n ny første
		{
			første = n;
			return true;
		}
		if(første.getDato().after(n.getDato()))
		//hvis første.dato er etter n.dato 
		//blir n satt forrest i lista
		{
			settInnForrest(n);
			return true;
		}
		
		Data a = første;
		Data b = null;
		while(a.neste != null && n.getDato().after(a.getDato()) )
		{
			a = a.neste;
		}
		n.neste = a.neste;
		a.neste = n;
		
		return true;
	}
	
	private void settInnForrest(Data n)
	{
		n.neste = første;
		første = n;
	}
	
	public boolean datoEksisterer(Data n)
	{
		if(første == null)
			return false;
		
		if(første.getDato().compareTo(n.getDato()) == 0)
			return true;
		
		Data a = første;
		
		while(a.neste != null)
		{
			if(a.neste.getDato().compareTo(n.getDato())== 0)
				return true;
			a = a.neste;
		}
		return false;
	}
	
	public String skrivUtListe()
	{
		String retur = "Dato\tMinTemp\tMaxTemp\tNedbør\n";
		
		if(første != null)
		{
			retur += første.toString() +"\n";
		}
		
		Data a = første;
		while(a.neste != null)
		{
			retur += a.neste.toString()+"\n";
			a = a.neste;
		}
		return retur;
	}
	
	public boolean tomListe()
	{
		if(første == null)
			return true;
		return false;
	}
}
