/*------------------------------------------------------
 		Program for File reader, and File Writer.
 		 		
 		@ Saifullah Saifi hasectic(saifi@csdamu.com)
------------------------------------------------------*/
package Calculation;

import java.io.*;


public class File_reader {
	public static void main(String [] args)throws IOException{
	BufferedReader in= new BufferedReader(new FileReader("C:\\Users\\Saifi\\workspace\\koi\\src\\inp.txt"));
	PrintWriter out= new PrintWriter(new FileWriter("C:\\Users\\Saifi\\workspace\\koi\\src\\output.txt")) ;
	String s=in.readLine();
	while (s != null)
	{
		out.println(s);
	s=in.readLine();
	}
	in.close();
	out.close();
}
	}
