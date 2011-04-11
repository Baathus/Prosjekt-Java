package Meterologi;

import java.awt.*;

import javax.swing.JPanel;
import javax.swing.*;

import Meterologi.Lister.StedListe;
import Meterologi.Lister.Sted;

public class Statistikk {
	Meterologi.Lister.StedListe stedliste;
	Sted valgtsted;
	JTabbedPane sub;
	JPanel stataar;
	JPanel statmaaned;
	JPanel statdag;
	JPanel statextreme;
	
	public void byggPanel(JPanel panel)
	{
		panel.setLayout(new FlowLayout());
		//panel for visting av statistikk for år
		stataar = new JPanel();
		stataar.add(new JLabel("asas"));
		stataar.add(new JTextArea(30,30));
		
		//panel for visning av statistikk for måned
		statmaaned = new JPanel();
		statmaaned.add(new JLabel("asas"));
		statmaaned.add(new JTextArea(30,30));
		
		//panel for visning av statistikk for dag
		statdag = new JPanel();
		statdag.add(new JLabel("asas"));
		statdag.add(new JTextArea(30,30));
		
		//panel for visning av ekstreme statistiske verdier
		statextreme = new JPanel();
		statextreme.add(new JLabel("asas"));
		statextreme.add(new JTextArea(30,30));
		
		//Tabbed panel for statistikk
		sub = new JTabbedPane();
		
		sub.addTab("Statistikk for år", stataar);
		sub.addTab("Statistikk for måned", statmaaned);
		sub.addTab("Statistikk for dag", statdag);
		sub.addTab("Ekstreme verdier", statextreme);
		
		panel.add(sub);
		
	}
}
