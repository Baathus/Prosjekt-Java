public class DataListe2 {
	
	Data første;
	
	public boolean nyData(Data n)
	{
		if(tomListe())
		{
			første = n; 
			return true;
		}
		
		Data a = første;
		Data b = null;
		
		if(n.getDato().compareTo(a.getDato()) < 0)
		{
			a.neste = n;
			return true;
			
		}
		
		while(a.neste != null)
		{
			if(n.getDato().compareTo(a.neste.getDato()) < 0)
			{
				b = a.neste;
				a.neste=n;
				n.neste = b;
				b = null;
				return true;
			}
			a = a.neste;
		}
		a.neste = n;
		return true;
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
		Data a = første;
		String retur = "Dato\tMinTemp\tMaxTemp\tNedbør\n";
		
		while(a.neste != null)
		{
			retur += a.toString()+"\n";
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
