import java.util.*;
import java.io.*;
/**
  *@author Ramovha Lasy
  *
*/
public class AccessArrayApp
{
    
	/** main methods for runnig the programme
     *@param args takes data from the terminal
    */
	public static void main(String[] args)
    {
	    student AccessApp = new student();
	    AccessApp.openFile("oklist.txt");
	    AccessApp.readFile();
	    if (args.length != 0)
	    {
		    AccessApp.printStudent(args[0]);
	    }
	    else
	    {
		    AccessApp.printAllStudents();
	    }
    }
}
