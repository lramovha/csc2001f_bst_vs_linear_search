import java.util.*;
import java.io.*;
/**
  *@author Ramovha Lasy
  *
*/
public class AccessBSTApp
{
	/** main methods for runnig the programme
     *@param args takes data from the terminal
    */
	public static void main(String [] args)
	{
		student Access = new student();
		Access.openFile("/home/hope/csc2001f_uct/assignment1/RMVLAS001/data/oklist.txt");
		Access.readFileBst();
		if (args.length != 0)
		{
			Access.printStudentBst(args[0]);
		}
		else
		{
			Access.printAllStudentsBst();
		}
	}
}
