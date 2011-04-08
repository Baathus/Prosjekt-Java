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
		if(f�rste.getDato().compareTo(n.getDato()) > 0)
		//hvis f�rste.dato er etter n.dato 
		//blir n satt forrest i lista
		{
			settInnForrest(n);
			return true;
		}
		else//setter ny data, sortert inn i lista etter dato.
		{
			Data a = f�rste;
			while(a.neste != null && a.neste.getDato().compareTo(n.getDato()) < 0)
			{
				a = a.neste;
			}
			n.neste = a.neste;
			a.neste = n;
			return true;
		}
	}
	
	private void settInnForrest(Data n)
	{
		Data a = f�rste;
		
		n.neste = a;
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
		Data a = f�rste;
		String retur = "Dato\tMinTemp\tMaxTemp\tNedb�r\n";
		
		if(a != null)
		{
			retur += a.toString() +"\n";
		}
		
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
