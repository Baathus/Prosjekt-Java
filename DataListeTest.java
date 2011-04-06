	import java.awt.*;
	import java.util.*;
	import java.awt.event.*;
	import javax.swing.*;
	
public class DataListeTest extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
		private JTextArea utskrift;
		private JButton skrivut;
		private JButton leggtilny;
		private JTextField dagfelt;
		private JTextField månedfelt;
		private JTextField årfelt;
		private JTextField mintempfelt;
		private JTextField maxtempfelt;
		private JTextField nedbørfelt;
		
		
		private DataListe dataliste;
		private Data nydata;

		public DataListeTest()
		{
			super("Datalistetest");
			Container c = getContentPane();
			c.setLayout(new FlowLayout());
			
			c.add(new JLabel("Dag"));
			dagfelt = new JTextField(2);
			c.add(dagfelt);
			c.add(new JLabel("Måned"));
			månedfelt = new JTextField(2);
			c.add(månedfelt);
			c.add(new JLabel("År"));
			årfelt = new JTextField(4);
			c.add(årfelt);

			c.add(new JLabel("Mimimumstemp"));
			mintempfelt = new JTextField(2);
			c.add(mintempfelt);
			c.add(new JLabel("Maksimumstemp"));
			maxtempfelt = new JTextField(2);
			c.add(maxtempfelt);
			c.add(new JLabel("Nedbør"));
			nedbørfelt= new JTextField(4);
			c.add(nedbørfelt);
			
			
			leggtilny = new JButton("Registrer Ny Data");
			leggtilny.addActionListener(this);
			c.add(leggtilny);
			
			skrivut = new JButton("skriv ut");
			skrivut.addActionListener(this);
			c.add(skrivut);

			utskrift = new JTextArea(40, 40);
			c.add(new JScrollPane(utskrift));

			setSize(500, 500);
			setVisible(true);
			
			dataliste = new DataListe();
		}
		
		public static void main( String[] args )
		{
			DataListeTest vindu = new DataListeTest();
		    vindu.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		}

		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == skrivut)
			{
				if( dataliste.tomListe() )
					utskrift.setText("ingen data i systemet!");
				else
					utskrift.setText(dataliste.skrivUtListe() );
			}
			if(event.getSource() == leggtilny)
			{	try{
				int dag = Integer.parseInt(dagfelt.getText());
				int måned = Integer.parseInt(månedfelt.getText());
				int år = Integer.parseInt(årfelt.getText());
				Calendar dato = Calendar.getInstance(); 
				dato.setTimeInMillis(0); //hadde vært lettere med Date(år, måned, dato)
				dato.set(år,måned,dag,0,0,0);
				
				double min = Integer.parseInt(mintempfelt.getText());
				double max = Integer.parseInt(maxtempfelt.getText());
				double ned = Integer.parseInt(nedbørfelt.getText());
				
				nydata = new Data(dato, min, max, ned);
				boolean ok = dataliste.nyData(nydata);
				if(!ok)
				{JOptionPane.showMessageDialog(null, "Feil ved innsetting av data!");}
				else JOptionPane.showMessageDialog(null, "Data er lagt til");
				}catch(Exception ex){JOptionPane.showMessageDialog(null, "Feil ved innsetting av data!");};
			}
		}
	}
