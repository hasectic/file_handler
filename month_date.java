/*-----------------------------------------------------------------
 		Program for Year, date, month wise folder making.
 		
 		@ Saifi
-----------------------------------------------------------------*/
package Calculation;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class month_date {
	private time t= new time();
	// constructor
	public  month_date(){}
	// method for fresh new file clean it 
	public void clean(String url)
	{
		File p= new File(url);     
		for(File file: p.listFiles()) 
		{	for (File f : file.listFiles())
				f.delete();
			file.delete();
		}
	} 
	// according to  date e.g 2010-10-12
	public String getDate(File path) throws IOException
	{
		
BasicFileAttributes bttr = Files.readAttributes(path.toPath(),BasicFileAttributes.class,LinkOption.NOFOLLOW_LINKS);

StringTokenizer st = new StringTokenizer(t.fodate(bttr.lastModifiedTime()).toString(),"T");
String date = st.nextToken();

return  (date);
	
	}
	// according to  year  e.g.2010
	public String getYear(File path) throws IOException
	{
		
BasicFileAttributes bttr = Files.readAttributes(path.toPath(),BasicFileAttributes.class,LinkOption.NOFOLLOW_LINKS);


StringTokenizer st = new StringTokenizer(t.fodate(bttr.lastModifiedTime()).toString(),"-");
String year = st.nextToken();

return  (year);
	
	}
	
	//according to month e.g. nov or 11
	public String getMonth(File path) throws IOException
	{
		
BasicFileAttributes bttr = Files.readAttributes(path.toPath(),BasicFileAttributes.class,LinkOption.NOFOLLOW_LINKS);

StringTokenizer st = new StringTokenizer(t.fodate(bttr.lastModifiedTime()).toString(),"-");
String year = st.nextToken();
String month = st.nextToken();

return  (month);
	
	}
	//// copy file from 1 folder to another
	private static void copyFile(File source, File dest)
	        throws IOException {
	    Files.copy(source.toPath(), dest.toPath());
	    System.out.println("success");
	}

	//main
public static void main(String [] args)throws IOException, ParseException{
		month_date ne=new month_date();
		
		File directory = new File("C:\\Users\\Saifi\\workspace\\koi\\src\\date_check");  
		int n= directory.listFiles().length;
		File [] myarray;
		System.out.println(n);
		myarray=directory.listFiles();
//		System.out.println("Please enter Your choice:\n If you want to sort the file by date press 1\n  If you want to sort the file by year press 2\n If you want to sort the file by mont press 3\n");
		BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		String ch="n";
		do{
			System.out.println("Please enter Your choice:\n If you want to sort the file by date press 1\n  If you want to sort the file by year press 2\n If you want to sort the file by mont press 3\n");
		int choice= Integer.parseInt(in.readLine());
		
			switch (choice) {
		
		case 1:
			final String url="C:\\Users\\Saifi\\workspace\\koi\\src\\after_date\\"; 
			ne.clean(url);
			List<String> datecollect= new ArrayList<String>();
			Set uniqueEntries = new HashSet();
			for(int i=0;i<n; i++ ){
				File path=myarray[i];
				String date= ne.getDate(path);

				datecollect.add(date);
				for (Iterator iter = datecollect.iterator(); iter.hasNext(); ) {
					  Object element = iter.next();
					  if (!uniqueEntries.add(element)) // if current element is a duplicate,
					    iter.remove();                 // remove it
					}
				}
			for(int m=0;m<n; m++ ){
				File path=myarray[m];
				Iterator iterator = uniqueEntries.iterator();
				while (iterator.hasNext()){
					String x= (String) iterator.next();
					File dir= new File(url+x);dir.mkdirs();
					File dest = new File(dir +"\\"+path.getName());
					System.out.println(x+ ne.getDate(path));
					if(x.equals(ne.getDate(path))){
						File cpy= path;
						
						
						copyFile(cpy, dest);
					}


				}
			}
			System.out.println(uniqueEntries);
			break;
		case 2:
			final String url_year ="C:\\Users\\Saifi\\workspace\\koi\\src\\year\\";
			ne.clean(url_year);
			List<String> cyear= new ArrayList<String>();
			Set uniqueyear= new HashSet();
			for(int i=0;i<n; i++ ){
				File path=myarray[i];
				String year= ne.getYear(path);
				cyear.add(year);
				for (Iterator iter = cyear.iterator(); iter.hasNext(); ) {
					  Object element = iter.next();
					  if (!uniqueyear.add(element)) // if current element is a duplicate,
					    iter.remove();                 // remove it
					}
				}
			for(int m=0;m<n; m++ ){
				File path=myarray[m];
				Iterator yr=uniqueyear.iterator();
				while (yr.hasNext()){
					String xy= (String) yr.next();
					File diry= new File(url_year+xy);diry.mkdirs();
					File desty = new File(diry +"\\"+path.getName());
					System.out.println(xy+ ne.getYear(path));
					if(xy.equals(ne.getYear(path))){
						File cpy= path;				
						copyFile(cpy, desty);
					}
				}
			}
				System.out.println(uniqueyear);
				
			
			break;
		case 3:
			final String url_month ="C:\\Users\\Saifi\\workspace\\koi\\src\\month\\"; 
			ne.clean(url_month);
			List<String> month= new ArrayList<String>();
			Set uniquemonth = new HashSet();
			for(int i=0;i<n; i++ ){
				File path=myarray[i];
			String xmonth=ne.getMonth(path);
			month.add(xmonth);
			for (Iterator iter = month.iterator(); iter.hasNext(); ) {
				  Object element = iter.next();
				  if (!uniquemonth.add(element)) // if current element is a duplicate,
				    iter.remove();                 // remove it
				}
			}
			for(int m=0;m<n; m++ ){
				File path=myarray[m];
			Iterator mnth= uniquemonth.iterator();
			while (mnth.hasNext()){
				String x1= (String) mnth.next();
				File dirc= new File(url_month+x1);
				dirc.mkdirs();
				File desti = new File(dirc +"\\"+path.getName());
				System.out.println(x1+ ne.getMonth(path));
				if(x1.equals(ne.getMonth(path))){
					File cpy= path;					
					copyFile(cpy, desti);
				}
				}
			}
			System.out.println(uniquemonth);
			break;
		default:
			System.out.println("Please enter Your choice:\n If you want to sort the file by date press 1\n  If you want to sort the file by year press 2\n If you want to sort the file by mont press 3\n");
			BufferedReader iun= new BufferedReader(new InputStreamReader(System.in));
		 choice= Integer.parseInt(iun.readLine());
			break;
		}
			System.out.println("Do u want to run it again?(Y/N)");
			ch =	sc.next();
		}while(ch.equalsIgnoreCase("y"));	
}
}
