/*
 * Skrevet av Mikael Jakhelln, 8.4.2011
 * Denne klassen skal v�re gui for registrering av nyData og legges til i Tab.java
 */

package Meterologi;

import java.awt.*;
		import java.util.*;
		import java.awt.event.*;
import javax.swing.*;

import Meterologi.Lister.Data;
import Meterologi.Lister.DataListe;

public class RegistrerData implements ActionListener{

	private static final long serialVersionUID = 1L;

			private JTextArea utskrift;
			
			private JComboBox fylkeboks;
			private JButton skrivut;
			private JButton leggtilny;
			private JTextField dagfelt;
			private JTextField m�nedfelt;
			private JTextField �rfelt;
			private JTextField mintempfelt;
			private JTextField maxtempfelt;
			private JTextField nedb�rfelt;
			
			private int dag;
			private int m�ned;
			private int �r;
			private double min;
			private double max;
			private double ned;
			
			
			private DataListe dataliste;
			private Data nydata;

			public JPanel ByggPanel(JPanel panelet)
			{
				panelet.setLayout(new FlowLayout());
				
				panelet.add(new JLabel("Dag"));
				dagfelt = new JTextField(2);
				panelet.add(dagfelt);
				panelet.add(new JLabel("M�ned"));
				m�nedfelt = new JTextField(2);
				panelet.add(m�nedfelt);
				panelet.add(new JLabel("�r"));
				�rfelt = new JTextField(4);
				panelet.add(�rfelt);

				panelet.add(new JLabel("Minimumstemp"));
				mintempfelt = new JTextField(2);
				panelet.add(mintempfelt);
				panelet.add(new JLabel("Maksimumstemp"));
				maxtempfelt = new JTextField(2);
				panelet.add(maxtempfelt);
				panelet.add(new JLabel("Nedb�r"));
				nedb�rfelt= new JTextField(3);
				panelet.add(nedb�rfelt);
				
				
				leggtilny = new JButton("Registrer Ny Data");
				leggtilny.addActionListener(this);
				panelet.add(leggtilny);
				
				skrivut = new JButton("skriv ut");
				skrivut.addActionListener(this);
				panelet.add(skrivut);

				utskrift = new JTextArea(40, 40);
				panelet.add(new JScrollPane(utskrift));
				panelet.setVisible(true);
				
				dataliste = new DataListe();
				
				return panelet;
			}
			
			public void melding(String m)
			{
				JOptionPane.showMessageDialog(null, m);
			}
			
			public boolean getDatoVerdier()
			{
				dag = Integer.parseInt(dagfelt.getText());
				m�ned = Integer.parseInt(m�nedfelt.getText());
				�r = Integer.parseInt(�rfelt.getText());
				if(dag <= 0 || dag > 31)
				{	melding("ugyldig dag");
					return false; 
				}
				if(m�ned == 0 || m�ned >12 || m�ned < 1)
				{	melding("ugyldig m�ned");
					return false;
				}
				if(�r < 1970)
				{	melding("ugyldig �rstall");
					return false;
				}
				if(�r > 3000)
				{	melding("Morsom eller.\n�r "+�r+" :P");
					return false;
				}
				//m� lage test p� registrering av datoer som ikke har v�rt enn�.
				return true;
			}
			
			public boolean getV�rVerdier()
			{
				try{
				min = Integer.parseInt(mintempfelt.getText());
				}catch(Exception e){melding("ugyldig mintempverdi");return false;}
				try{
				max = Integer.parseInt(maxtempfelt.getText());
				}catch(Exception e){melding("ugyldig maxtempverdi");return false;}
				try{
				ned = Integer.parseInt(nedb�rfelt.getText());
				}catch(Exception e){melding("ugyldig nedb�rsverdi");return false;}
				
				if(min <0 )
				{melding("ugyldig nedb�rsverdier"); return false;}
				if(max<min)
				{melding("maxnedb�r er mindre en minnedb�r!");return false;}
				if(max > 9999)
				{melding("ekstremnedb�r");}
				
				return true;
			}

			public void knappelytter(ActionEvent event) {
				if(event.getSource() == skrivut)
				{
					if( dataliste.tomListe() )
						utskrift.setText("ingen data i systemet!");
					else
						utskrift.setText(dataliste.skrivUtListe() );
				}
				if(event.getSource() == leggtilny)
				{	
					try{
						//henter dato input
						if(!getDatoVerdier())
							return;
						//lagrer dato som calendar objekt
						Calendar dato = Calendar.getInstance(); 
						dato.setTimeInMillis(0); //hadde v�rt lettere med Date(�r, m�ned, dato)
						dato.set(�r,m�ned-1,dag);/*-1 fordi Calendar.set() er teit*/
						Calendar n� = Calendar.getInstance();
						if(n�.before(dato))
						{
							melding("regisrtert dato har ikke intruffet enn�");
							return;
						}
						
						if(!getV�rVerdier())
							return;
						
						//lager en ny node med dataen
						nydata = new Data(dato, min, max, ned);
						
						//pr�ver � sette den inn i lista.
						boolean dobbeltregistrering = dataliste.datoEksisterer(nydata);
							
						if(dobbeltregistrering)
						{melding("Det er allerede registrert data p� denne datoen");}
						else{
							dataliste.nyData(nydata);
							melding("Data er lagt til");
						}
					}
					catch(Exception ex){melding("Feil ved innsetting av data!");};
				}
			}
		}

