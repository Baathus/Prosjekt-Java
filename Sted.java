import java.io.Serializable;
import java.util.Collection;


public class Sted implements Serializable{

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
		if(!finnesILista(n) )
			{
				dataliste.addSorted(n);//fiktivt metodekall	
				return true;
			}
		else return false;
	}
	
	public boolean finnesILista(Data n)
	//sjekker igjennom datalista om dato er registrert ifra før
	{
		//if(dataliste.nyNode.getDato() )
		
		return false;
	}
}
