package Lister;

import java.util.*;

import javax.swing.JOptionPane;

public class DatoTest {
	
	public static void main(String[] args)
	{
		Calendar en = Calendar.getInstance();
		en.setTimeInMillis(0);
		en.set(1999,1,1);
		
		Calendar to = Calendar.getInstance();
		to.setTimeInMillis(0);
		to.set(2000,1,1);
		
		String s = "en : 1.1.1999\nto: 1.1.2000\nHvilken er f�r den andre?\nSvar: ";
					if(en.before(to))
							s+="en er f�rst";
					else
						s+="to er f�rst";
		JOptionPane.showMessageDialog(null,s);
	}
	
}
