public class DataListe2 {
	
	Data f�rste;
	
	public boolean nyData(Data n)
	{
		if(tomListe())
		{
			f�rste = n; 
			return true;
		}
		
		Data a = f�rste;
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
		if(f�rste == null)
			return false;
		
		if(f�rste.getDato().compareTo(n.getDato()) == 0)
			return true;
		
		Data a = f�rste;
		
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
		Data a = f�rste;
		String retur = "Dato\tMinTemp\tMaxTemp\tNedb�r\n";
		
		while(a.neste != null)
		{
			retur += a.toString()+"\n";
			a = a.neste;
		}
		return retur;
	}
	
	public boolean tomListe()
	{
		if(f�rste == null)
			return true;
		return false;
	}
}
