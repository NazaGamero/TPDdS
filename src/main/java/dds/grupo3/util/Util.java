package dds.grupo3.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
/*Esta clase existe para guardar funcionalidades que se usan a lo largo de todo el codigo*/
	
	private static DateFormat timeStampFormatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	
	//Pasar un Date a String "20220818131336848" por ejemplo
	public static String dateToString(Date fecha) {
		String fechaString = fecha.toString();
		fechaString = timeStampFormatter.format(fecha);
		return fechaString;
	}
	
	//Pasar un String tipo "20220818131336848" a Date
	public static Date stringToDate(String fecha) throws ParseException {
		Date objFecha = timeStampFormatter.parse(fecha);
		return objFecha;
	}
}
