/*------------------------------------------------------
 		Program for Size wise Folder making.
 		
 		@ Saifullah Saifi hasectic(saifi@csdamu.com)
------------------------------------------------------*/
package Calculation;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;
import java.text.*;
import java.util.*;

public class ss {
	public ss(){}
	public void clean(String url)
	{
		File p= new File(url);     
		for(File file: p.listFiles()) 
		{	for (File f : file.listFiles())
				f.delete();
			file.delete();
		}
	} 

	public long getSize(File path) throws IOException
	{
		
BasicFileAttributes bttr = Files.readAttributes(path.toPath(),BasicFileAttributes.class,LinkOption.NOFOLLOW_LINKS);
return bttr.size();

	
	}

	private static void copyFile(File source, File dest)
	        throws IOException {
	    Files.copy(source.toPath(), dest.toPath());
	    System.out.println("success");
	}

	//main
@SuppressWarnings("unchecked")
public static void main(String [] args)throws IOException, ParseException{
		ss ne=new ss();
		
		
final String url ="C:\\Users\\Saifi\\workspace\\koi\\src\\size\\";  
File directory = new File("C:\\Users\\Saifi\\workspace\\koi\\src\\date_check");  
int n= directory.listFiles().length;
File [] myarray;
ne.clean(url);

//myarray=new File[n];
myarray=directory.listFiles();
List<Long> datecollect= new ArrayList<Long>();
Set uniqueEntries = new HashSet();
for(int i=0;i<n; i++ ){
File path=myarray[i];
long size = ne.getSize(path);

datecollect.add(size);
for (Iterator iter = datecollect.iterator(); iter.hasNext(); ) {
	  Object element = iter.next();
	  if (!uniqueEntries.add(element)) // if current element is a duplicate,
	    iter.remove();                 // remove it
	}
}
double mb=0.0;
for(int m=0;m<n; m++ ){
File path=myarray[m];

Iterator iterator = uniqueEntries.iterator(); 

// check values
while (iterator.hasNext()){
	Long x= (Long) iterator.next();
	  mb= (x/1024)/1024;
	/// finding the maxim file size
	  long Max= (long)Collections.max(uniqueEntries) ;
	double d= (double) Max;
	d= (d/1024)/1024;
	String str;
	for(int k=0;k<=d; k++)
		 if(mb>=k && mb<k+1){
			 str=String.valueOf(k+1);
			 File dir= new File(url+str+"MB"); dir.mkdirs();
			  File dest = new File(dir +"\\"+path.getName());
			  if(x.equals(ne.getSize(path))){
					File cpy= path;				
					copyFile(cpy, dest);
			  		}
		 }
		
	
	
	System.out.println(x+ ne.getSize(path));
	


}	}
System.out.println(uniqueEntries);

}
}
