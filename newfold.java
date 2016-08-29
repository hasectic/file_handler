/*------------------------------------------------------
 		Program for choosing 2 files randomly 
 		and putting it together into another folder
 		 1.txt and 9.doc will be saved in
 		 1_9 named Folder.
 		 		
 	@ Saifullah Saifi hasectic(saifi@csdamu.com)
------------------------------------------------------*/
package Calculation;
import java.io.*;
import java.util.*;
 
public class newfold {
	public newfold(){}
	public void clean(String url)
	{
		File p= new File(url);     
		for(File file: p.listFiles()) 
		{	for (File f : file.listFiles())
				f.delete();
			file.delete();
		}
	}
	public static void main(String [] args)throws IOException{
		newfold ne=new newfold();
		// file and folder path
		final String url = "output folder path";
		// e.g final String url = "C:\\Users\\Saifi\\workspace\\koi\\src\\output\\";
File directory = new File("the path of input folder");  
// clean the output folder
File[] myarray;
ne.clean(url);
//variable and method declaration
int n= directory.listFiles().length;
myarray=new File[n];
StringBuffer str1=new StringBuffer();
StringBuffer str =new StringBuffer();
int k=1;

// no. of output according to no of input
if(n>1){	k= n%2==0?n/2:n/2+1;}
else{	k=n;}

// no of files in output folder
List<Integer> lstCompleted= new ArrayList<Integer>();

	// getting all files from input folder
	myarray=directory.listFiles();
	int xx=(myarray.length%2==0?myarray.length/2:myarray.length/2+1);
	System.out.println("n="+n + " X="+xx);
for (int j = 0; j < xx; j++)
{
	PrintWriter out=null;
	int count =0;
	while(count<2 && lstCompleted.size()<myarray.length){	
	int x= 0;
	while(x==0 && lstCompleted.size()<myarray.length)		
	{
		// random input file and taking it into output folder
		Random rand = new Random();
		x= rand.nextInt(n+1);
		x=x==0?1:(x>n?n:x);
		System.out.println(x+" "+lstCompleted.contains(x));
        if(!lstCompleted.contains(x))
        	lstCompleted.add(x);
        else
        	x=0;
	}
	
	
	
	
	
	if(x>0){
		// take input file
       File path=myarray[x-1];
       
       BufferedReader br = new BufferedReader(new FileReader(path));
	   
              
       while (br.ready()) {
    	   // reading data from input files
    	   String s = br.readLine();
    	   // writnig data into stringbuffer str1
    	   str1.append(s);
    	   str1.append(System.getProperty("line.separator"));
          }
       count++;
       // 2nd file input before it a break line
       str1.append(System.getProperty("line.separator"));
       // name of outfile and folder from input file name and between 2 a _seperator
       if (str.length()==0)    {
           str.append(path.getName().substring(0, path.getName().indexOf('.')));
           if(lstCompleted.size()<myarray.length)
           str.append("_");
           
    	   }
    	   else
    		   str.append(path.getName().substring(0, path.getName().indexOf('.')));	
        }
	
	
	}
	// making new dirctory from the name of input files
	
	File dir= new File(url+str.toString());dir.mkdirs();
	out= new PrintWriter(new FileWriter(url+str.toString()+"\\Output_"+str+".txt"));
	out.println(str1);
	// for every loop , strbuff must be empty
	str1.delete(0, str1.length());
	str.delete(0,str.length());
	out.close();
	
}
}
}



