/*
 * Skrevet av Thomas Nordengen den 4 april 2011
 */

package Meterologi.Lister;

import javax.swing.*;
import java.util.*;
import java.io.*;

public class StedListe
{
	private SortedSet<Sted> stedsliste;
	String rekkefølge = 
		"Akershus, Aust-Agder, Buskerud Finnmark, Hedmark, Hordaland, Møre og Romsdal, " +
		"Nordland, Nord-Trøndelag, Oppland, Oslo, Rogaland, Sogn og Fjordane, " +
		"Sør-Trøndelag, Telemark, Troms, Vest-Agder, Vestfold, Østfold";
	
	
	
	try{
		Comparator comp = new RuleBasedComparator (rekkefølge);
	}
	catch(ParseException pe)
	{
		JOptionPane.showMessageDialog(null, "Det oppstod en feil i sorteringen!");

	}



	public String getFylke(Sted obj)
	{
		String fylke = "";
		fylke = Sted.getFylke();
		return fylke;
	}

	//Setter inn fylke i listen
	public void setInnFylke(Sted obj)
	{
		stedsliste.add(obj);
	}

	//Gjennomløper lista fra valgt startposisjon og fremmover
	public String visFraStartPos(String fylke)
	{
		SortedSet<Sted> tail = stedsliste.tailset(fylke);
		Iterator<S ted> iter = new tale.iterator();
		while(iter.hasNext())
		{
			String resultat = iter.next();
		}
		return resultat;
	}




	public String sorterObjekter()
	{
		String sorted = "";

		stedsliste = new TreeSet<Sted>(comp);
		Iterator<Sted> iter = new stedsliste.iterator();

		while(iter.hasNext())
		{
			sorted += iterator.next().toString() + "\n";
		}

		return sorted;
	}

	//Alfabetisk utskrift av alle flylker med respektive steder
	public String getFylkeSted()
	{
		String sorted2 = "";

				stedsliste = new TreeSet<Sted>(comp);
				Iterator<Sted> iter = new stedsliste.iterator();
				String plass = "";

				while(iter.hasNext())
				{
					sted = iter.next().getSted();

					sorted2 += iterator.next().toString() + "\n";
					sorted2 += sted"\n";
				}

		return sorted;
	}


	public String toString()
	{
		String result = "";

		result += "Dette er den totale og sorterte listen av alle fylkene." + sorted + "\n";

		return result;
	}

}
