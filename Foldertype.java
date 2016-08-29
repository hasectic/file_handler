/*------------------------------------------------------
 		Program for choosing all files from a folder
 		without Knowing Names of files
 		 and saving it into another file.
 		 		
 		@ Saifi
------------------------------------------------------*/

package Calculation;
import java.io.*;
public class Foldertype {
	public static void main(String [] args)throws IOException{

File directory = new File("C:\\Users\\Saifi\\workspace\\koi\\src\\new");      
File[] myarray;  

myarray=directory.listFiles();
PrintWriter out= new PrintWriter(new FileWriter("C:\\Users\\Saifi\\workspace\\koi\\src\\output.txt")) ;

for (int j = 0; j < myarray.length; j++)
{
       File path=myarray[j];
     
       BufferedReader br = new BufferedReader(new FileReader(path));
       String s = br.readLine();
       while (br.ready()) {
    	   System.out.println(s);
    	   out.println(s);
          br.readLine();
          
       }
       br.close();  
}

out.close();
}}