import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author George Ionkov
 *
 */
public class DveDati {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String ds1 = "01/01/2015";
		String ds2 = "04/26/1981";
		
		int days = dayDiff(ds1, ds2);
		System.out.println("Days: " + days);
	}
	
	
	protected static int dayDiff(String ds1, String ds2) 
			throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("MM/DD/YYYY");
		
		Date d1 = df.parse(ds1);
		Date d2 = df.parse(ds2);
		long days = Math.abs(d1.getTime() - d2.getTime()) / (24 * 60 * 60 * 1000);
		return (int)days;
	}

}
