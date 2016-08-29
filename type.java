/*------------------------------------------------------
 		Program for type extension wise Folder making.
 		
 		@ Saifullah Saifi hasectic(saifi@csdamu.com)
------------------------------------------------------*/
package Calculation;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;
import java.text.*;
import java.util.*;

public class type {
	public type(){}
	public void clean(String url)
	{
		File p= new File(url);     
		for(File file: p.listFiles()) 
		{	for (File f : file.listFiles())
				f.delete();
			file.delete();
		}
	} 

	public String getType(File path) throws IOException
	{
		StringTokenizer n= new StringTokenizer(path.getName(),".");
	String file_name=	n.nextToken();
	String type= n.nextToken();
return type;

	
	}

	private static void copyFile(File source, File dest)
	        throws IOException {
	    Files.copy(source.toPath(), dest.toPath());
	    System.out.println("success");
	}

	//main
@SuppressWarnings("unchecked")
public static void main(String [] args)throws IOException, ParseException{
		type ne=new type();
		
		
final String url ="C:\\Users\\Saifi\\workspace\\koi\\src\\type\\";  
File directory = new File("C:\\Users\\Saifi\\workspace\\koi\\src\\date_check");  
int n= directory.listFiles().length;
File [] myarray;
ne.clean(url);

//myarray=new File[n];
myarray=directory.listFiles();
List<String> datecollect= new ArrayList<String>();
Set uniqueEntries = new HashSet();
for(int i=0;i<n; i++ ){
File path=myarray[i];
String ft = ne.getType(path);
datecollect.add(ft);
for (Iterator iter = datecollect.iterator(); iter.hasNext(); ) {
	  Object element = iter.next();
	  if (!uniqueEntries.add(element)) // if current element is a duplicate,
	    iter.remove();                 // remove it
	}

Iterator iterator = uniqueEntries.iterator(); 

// check values
while (iterator.hasNext()){
	String x= (String) iterator.next();
			 File dir= new File(url+x); dir.mkdirs();
			  File dest = new File(dir +"\\"+path.getName());
			  if(x.equals(ne.getType(path))){
					File cpy= path;				
					copyFile(cpy, dest);
			  		
	
			  
	System.out.println(x+ ne.getType(path));
			  }


}	}
System.out.println(uniqueEntries);

}
}
