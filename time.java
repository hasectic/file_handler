/*------------------------------------------------------
 		Program for Time zone and format change.
 		
 		@ Saifullah Saifi hasectic(saifi@csdamu.com)
------------------------------------------------------*/

package Calculation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.TimeZone;

public class time {
	public String fodate(FileTime date1) throws IOException
	{
		Date d = new Date(date1.toMillis());
	DateFormat gmtDf = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
	gmtDf.setTimeZone(TimeZone.getTimeZone("GMT"));
	gmtDf.getCalendar().setTime(d);
	Date x= gmtDf.getCalendar().getTime();
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//	df.setTimeZone(TimeZone.getTimeZone("GMT"));
//	df.format(x);
	//df.getCalendar().setTime(x);
	return df.format(x).toString();
	}
	
	//main
public static void main(String [] args)throws IOException, ParseException{
		time ne=new time();
		File x=new File("C:\\Users\\Saifi\\workspace\\koi\\src\\inp.txt");
		BasicFileAttributes bttr = Files.readAttributes(x.toPath(),BasicFileAttributes.class,LinkOption.NOFOLLOW_LINKS);
		String d = ne.fodate(bttr.lastModifiedTime());
		StringTokenizer st = new StringTokenizer(d.toString(),"T");
		String date = st.nextToken();
System.out.println(d);

}
	

}
