package Lister;

public class DataListe2 {
	
	Data f�rste;
	
	public boolean nyData(Data n)
	{	
		if(f�rste == null)//hvis f�rste er null, blir n ny f�rste
		{
			f�rste = n;
			return true;
		}
		if(f�rste.getDato().after(n.getDato()))
		//hvis f�rste.dato er etter n.dato 
		//blir n satt forrest i lista
		{
			settInnForrest(n);
			return true;
		}
		
		Data a = f�rste;
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
		n.neste = f�rste;
		f�rste = n;
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
		String retur = "Dato\tMinTemp\tMaxTemp\tNedb�r\n";
		
		if(f�rste != null)
		{
			retur += f�rste.toString() +"\n";
		}
		
		Data a = f�rste;
		while(a.neste != null)
		{
			retur += a.neste.toString()+"\n";
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
