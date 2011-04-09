/*
 * Skrevet hovedsaklig av Nam le(mest kred!), 
 * med småsnutt fra Mikael Jakhelln og eventuelt Thomas Nordengen
 * Oppdatert: 9.April 2011
 */

package Meterologi;

import javax.swing.*;

import Meterologi.Lister.StedListe;

import java.awt.event.*;
import java.awt.*;

public class Tab extends JFrame implements ActionListener
{
	JTextArea utskrift1,utskrift2,utskrift3,utskrift4;
	JButton RegNySted;
	JTextField innFylke,innSted;
	JButton regData;
	StedListe stedliste; //må initialisere, men venter til stedliste er ferdig
	RegistrerData registrerdata;

	public Tab()
	{
		utskrift1 = new JTextArea(20,50);
		utskrift2 = new JTextArea(20,45);
		utskrift3 = new JTextArea(20,50);
		utskrift4 = new JTextArea(20,45);

		RegNySted = new JButton("Registrer nytt sted");
		RegNySted.addActionListener(this);

		innFylke = new JTextField(15);
		innSted = new JTextField(15);
		///////////////////////////////////////////////////////////////////////////

		regData = new JButton( "Registrer ny data");
		regData.addActionListener(this);


		JFrame frame = new JFrame("Hovedvindu");   // super("")
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();
		JPanel p7 = new JPanel();
		JPanel p8 = new JPanel();
		
		JTabbedPane sub = new JTabbedPane();
		p3.add(sub);


		//p1
		p1.add(new JLabel("Skriv inn fylket:"));
		p1.add(innFylke);
		p1.add(new JLabel("Skriv inn et nytt sted"));
		p1.add(innSted);
		p1.add(RegNySted);
		p1.add(utskrift1);
	
		//Legger registrering av Data på tab nr to (p2)
		registrerdata = new RegistrerData();
		registrerdata.ByggPanel(p2);
		
		p8.add(utskrift4);
		//p4
		p4.add(new JLabel("hei du er på 4"));
		//p4
		JTabbedPane tpane = new JTabbedPane();

		tpane.addTab("Registrer et nytt sted", null, p1, "Trykk her for registrering av nytt sted");
		tpane.addTab("Registrer ny data",null,p2, "Trykk her for registrering av ny data");
		tpane.addTab("Vis data",null, p3, "hei");
		tpane.addTab("Statistikk",p4);
		
	
		sub.addTab("Statistikk for år", p5);
		sub.addTab("Statistikk for måned", p6);
		sub.addTab("Statistikk for dag", p7);
		sub.addTab("Ekstreme verdier", p8);
		
		
		setLayout(new FlowLayout());
		
		
		frame.setPreferredSize( new java.awt.Dimension(800,600) );
		
		
		
		frame.add(tpane);
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		utskrift1.append("By,fylke:\n");
		utskrift2.append("Oslo, Oslo");
		utskrift3.append("By,fylke:\n");
		utskrift4.append("Oslo, Oslo");



	} //slutt på Konstruktør
	
	public void melding(String m)
	{
		JOptionPane.showMessageDialog(null,m, "OBS!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void p1()
	{
		melding("Nytt sted registrert");
	}
	
	public void p2()
	{
		melding("Ny data er registrert i lista");
	}
	
	public void actionPerformed(ActionEvent action) {

			if(action.getSource() == RegNySted)
				p1();
			/*else if(action.getSource() == regData)
			{
				p2();
			}*/
		}

	public static void main(String[]args)
	{
		Tab t = new Tab();
	}
}//slutt på gui-class