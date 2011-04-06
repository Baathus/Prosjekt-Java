import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Data implements Serializable{
	private Calendar dato;
	private double mintemp;
	private double maxtemp;
	private double nedbør;
	
	public Data(Calendar d, double min, double max, double ned)
	{
		dato = d;
		mintemp = min;
		maxtemp = max;
		nedbør = ned;
	}
	
	public double getMinTemp()
	{
		return mintemp;
	}
	
	public double getMaxTemp()
	{
		return maxtemp;
	}
	
	public double getNedbør()
	{
		return nedbør;
	}
	
	public Calendar getDato()
	{
		return dato;
	}
	
	public String toString()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyy");
		return sdf.format(dato.getTime()) +"\t"+mintemp+"\t"+maxtemp+"\t"+nedbør;
	}
}
