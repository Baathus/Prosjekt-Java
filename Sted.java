
public class Sted {

	public Collection dataliste;
	private String sted;
	private String fylke;
	
	public Sted(String s, String f)
	{
		fylke = f;
		sted = s;
	}
	
	public boolean nyData(Data n)
	{	/*sjekker igjennom lista, om det er registrert data på samma dato som 
		parameterens dato, skal den returnere false. 
		Ved vellykket innsetting skal den returnere true
		*/
		dataliste.nyData(n);
	}
}
