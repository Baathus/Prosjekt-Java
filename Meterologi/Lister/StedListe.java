/*
 * Skrevet av Thomas Nordengen den 4 april 2011
 */


import javax.swing.*;

import java.text.*;
import java.util.*;
import java.io.*;

public class StedListe

{
	private RuleBasedCollator kollator;
	private SortedSet<Sted> stedliste = new TreeSet<Sted>();
	
	//Setter inn sted bakerst i listen
	public void setInnFylke(Sted obj)
	{
		stedliste.add(obj);
	}
	

	/*public String getFylke(Sted obj)
	{
		String fylke = "";
		fylke = Sted.toString();
		return fylke;
	}*/
	
	//Gjennomløper og skriver ut lista
	public String skrivUt()
	{
		String output = "";
		Iterator<Sted> iterator = stedliste.iterator();
		while(iterator.hasNext())
		{
			output += iterator.next().toString() + "\n";
		}
		
		return output;
	}
	
	//Gjennomløper og skriver ut lista alfabetisk
	public String skrivUtAlfabetisk()
	{
		//Definerer rekkefølgen på sorteringen
		String rekkefølge = 
			"Akershus, Aust-Agder, Buskerud Finnmark, Hedmark, Hordaland, Møre og Romsdal, " +
			"Nordland, Nord-Trøndelag, Oppland, Oslo, Rogaland, Sogn og Fjordane," +
			"Sør-Trøndelag, Telemark, Troms, Vest-Agder, Vestfold, Østfold";
		try
		{
			kollator = new RuleBasedCollator (rekkefølge);
		}
		catch(ParseException pe)
		{
			JOptionPane.showMessageDialog(null, "Det oppstod en feil i sorteringen!");
		}
		
		stedliste = new TreeSet<Sted>(kollator);
		
		Iterator<Sted> Iter =  stedliste.iterator();
		while(Iter.hasNext())
		{
			Iter.next();
		}
		String output = stedliste.toString();
		return output;
	}


	public String toString()
	{
		String result = "";

		result += "Dette er den totale og sorterte listen av alle fylkene." + skrivUtAlfabetisk() + "\n";

		return result;
	}

}


