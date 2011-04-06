import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class Tab extends JFrame implements ActionListener
{
	JTextArea utskrift1,utskrift2,utskrift3,utskrift4;

	//P1 (registrer ny sted)//////////////////////////////////////////////////
		JButton RegNySted;
		JTextField innFylke,innSted;
	//P2 (registrer ny data)///////////////////////////////////////////////////
		JButton regData2;
	public Tab()
	{

		utskrift1 = new JTextArea(20,50);
		utskrift2 = new JTextArea(20,45);
		utskrift3 = new JTextArea(20,50);
		utskrift4 = new JTextArea(20,50);



		RegNySted = new JButton("Registrer nytt sted");
		RegNySted.addActionListener(this);

		innFylke = new JTextField(15);
		innSted = new JTextField(15);
		///////////////////////////////////////////////////////////////////////////

		JTextField fylke2,sted2,dato2,min2,max2,nedbør2;
		fylke2 = new JTextField(18);
		sted2 = new JTextField(18);
		dato2 = new JTextField(18);
		min2 = new JTextField(18);
		max2 = new JTextField(18);
		nedbør2 = new JTextField(18);
		regData2 = new JButton( "Registrer ny data");
		regData2.addActionListener(this);

		JFrame frame = new JFrame("Hovedvindu");   // super("")
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();



		//p1
		p1.add(new JLabel("Skriv inn fylket:"));
		p1.add(innFylke);
		p1.add(new JLabel("Skriv inn et nytt sted"));
		p1.add(innSted);
		p1.add(RegNySted);
		p1.add(utskrift1);

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
		p2.add(new JLabel("nedbør mm :"));
		p2.add(nedbør2);
		p2.add(regData2);
		p2.add(utskrift2);


		//p3
		p3.add(new JLabel("hei du er på 3"));
		//p4
		p4.add(new JLabel("hei du er på 4"));
		//p4
		JTabbedPane tpane = new JTabbedPane();

		tpane.addTab("Registrer et nytt sted", null, p1, "hei");
		tpane.addTab("Registrer ny data",null,p2, "hei");
		tpane.addTab("Vis data",null, p3, "hei");
		tpane.addTab("Statistikk",null, p4 , "hei");


		frame.add(tpane);
		frame.setSize(600,500);
		frame.setVisible(true);

		utskrift1.append("By,fylke:\n");
		utskrift2.append("Oslo, Oslo");
		utskrift3.append("By,fylke:\n");
		utskrift4.append("Oslo, Oslo");



	} //slutt på Konstruktør
	public void p1()
	{
				utskrift1.setText("Nytt sted registrert");
	}
	public void p2()
	{
		utskrift2.setText("Ny data er registrert i lista");
	}
	public void actionPerformed(ActionEvent action) {

			if(action.getSource() == RegNySted)
				p1();
			else if(action.getSource() == regData2)
				p2();
		}

	public static void main(String[]args)
	{
		Tab t = new Tab();
	}


}//slutt på gui-class

