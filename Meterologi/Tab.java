/*
 * Skrevet hovedsaklig av Nam le(mest kred!),
 * med sm�snutt fra Mikael Jakhelln og eventuelt Thomas Nordengen
 * Oppdatert: 9.April 2011
 */



import javax.swing.*;

//import Meterologi.Lister.StedListe;

import java.awt.event.*;
import java.awt.*;

public class Tab extends JFrame implements ActionListener
{
	JTextArea utskrift1,utskrift2,utskrift3,utskrift4;
	JButton RegNySted;
	JTextField innFylke,innSted;
	JButton regData;
<<<<<<< HEAD
	tab1 t = new tab1();

	//StedListe stedliste; //m� initialisere, men venter til stedliste er ferdig
	//RegistrerData registrerdata;
=======
	StedListe stedliste; //m� initialisere, men venter til stedliste er ferdig
	RegistrerData registrerdata;
	Statistikk statistikk;
>>>>>>> e0bce05727c55eb72913c148c6aa886cb224b05b

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
		JPanel p3 = t.tab1();
		JPanel p4 = new JPanel();
<<<<<<< HEAD
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();
		JPanel p7 = new JPanel();
		JPanel p8 = new JPanel();


		JTabbedPane sub = new JTabbedPane();
		p3.add(sub);

=======
>>>>>>> e0bce05727c55eb72913c148c6aa886cb224b05b

		//p1(f�rste tab) Panel for registrering nytt sted, fylke
		p1.add(new JLabel("Skriv inn fylket:"));
		p1.add(innFylke);
		p1.add(new JLabel("Skriv inn et nytt sted"));
		p1.add(innSted);
		p1.add(RegNySted);
		p1.add(utskrift1);
<<<<<<< HEAD



/* Mikael tester � lage eget panel :/
		//p2
		p2.add(new JLabel("Skriv fylke :"));
		p2.add(fylke2);
		p2.add(new JLabel("min temp. :"));
		p2.add(min2);
		p2.add(new JLabel("Skriv sted :"));
		p2.add(sted2);
		p2.add(new JLabel("max temp. :"));
		p2.add(max2);
		p2.add(new JLabel("Skriv dato :"));
		p2.add(dato2);
		p2.add(new JLabel("nedb�r mm :"));
		p2.add(nedb�r2);
		p2.add(regData);
		p2.add(utskrift2);
*/	//	registrerdata = new RegistrerData();
	//	registrerdata.ByggPanel(p2);

		p8.add(utskrift4);
		//p4
		p4.add(new JLabel("hei du er p� 4"));
		//p4
=======
	
		//Legger registrering av Data p� tab nr.2 to (p2)
		registrerdata = new RegistrerData();
		registrerdata.ByggPanel(p2);

		//p3 panel for Vis Data
		p3.add(new JLabel("hei du er p� vis data"));
		
		//p4 panel for Statistikk
		statistikk = new Statistikk();
		statistikk.byggPanel(p4);
		
		//MAIN TABBED PANEL
>>>>>>> e0bce05727c55eb72913c148c6aa886cb224b05b
		JTabbedPane tpane = new JTabbedPane();

		tpane.addTab("Registrer et nytt sted", null, p1, "Trykk her for registrering av nytt sted");
		tpane.addTab("Registrer ny data",null,p2, "Trykk her for registrering av ny data");
		tpane.addTab("Vis data",null, p3, "hei");
<<<<<<< HEAD
		tpane.addTab("Statistikk",p4);


		sub.addTab("Statistikk for �r", p5);
		sub.addTab("Statistikk for m�ned", p6);
		sub.addTab("Statistikk for dag", p7);
		sub.addTab("Ekstreme verdier", p8);


		setLayout(new FlowLayout());


		frame.setPreferredSize( new java.awt.Dimension(800,600) );



=======
		tpane.addTab("Statistikk", null, p4, "Trykk her for � vise statistikkvalg");
		
		setLayout(new FlowLayout());

>>>>>>> e0bce05727c55eb72913c148c6aa886cb224b05b
		frame.add(tpane);
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		utskrift1.append("By,fylke:\n");
		utskrift2.append("Oslo, Oslo");
		utskrift3.append("By,fylke:\n");
		utskrift4.append("Oslo, Oslo");



	} //slutt p� Konstrukt�r

	public void melding(String m)
	{
		JOptionPane.showMessageDialog(null,m, "OBS!", JOptionPane.INFORMATION_MESSAGE);
	}

	public void p1()
	{
		melding("Nytt sted registrert");
	}
<<<<<<< HEAD

	public void p2()
	{
		melding("Ny data er registrert i lista");
	}

=======
	
>>>>>>> e0bce05727c55eb72913c148c6aa886cb224b05b
	public void actionPerformed(ActionEvent action) {

			if(action.getSource() == RegNySted)
				p1();	
		}

	public static void main(String[]args)
	{
		Tab t = new Tab();
	}
}//slutt p� gui-class