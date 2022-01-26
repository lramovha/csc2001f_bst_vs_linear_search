/**
* @author Ramovha Lasy
*/

import java.util.*;
import java.io.*;

public class experiment
{
	public static Scanner newScan;
	String search;

	AVLTree<String> avl = new AVLTree<String>();

	/**
	* opens file at specified path
	* @param fileName the name of the file to open. An error message
	*                 is printed to the terminal if file is not found.
	*/

	public void openFile(String fileName)
	{
		try
		{
			File f = new File(fileName);
			newScannerKey = new Scanner(f);
		}
		catch(Exception e)
		{
			System.out.println("error - file not found");
			System.exit(0);
		}

	}

	/**
	* Reads file and insert students data in the AVL data structure.
	*/

	public void readFile()
	{
		String[] indexLine;
		while (newScannerKey.hasNext())
		{
			indexLine = (newScannerKey.nextLine()).split(" ");
			avl.insert(indexLine[0],indexLine[1], indexLine[2]);
		}
	}

	/**
	* Print all students details to the terminal in AVLTree order.
	*/

	public void printAllStudents()
	{
		avl.treeOrder();
	}

	/**
	* Prints student details given a student number as key.
	* @param studentID student number to search in the AVLTree data structure.
	* 		   The student name and surname is then displayed on terminal if found.
	*/

	public void printStudent(String studentID)
	{
		//FileWritter fstream = null;
		try
		{
			 fstream = new FileOutputStream("../data/InstrumentationAVL.txt");
			outStream = new PrintWriter(fout);
		}
		catch(Exception e)
		{
			System.out.println("error - cannot open InstrumentationAVL.txt");
			System.exit(0);
		}

		search = "on";
		if(avl.find(studentID) != null)
		{
			System.out.println(avl.find(studentID));
			System.out.println("instrumentation count for find is: "+avl.opCountFind);
			System.out.println("instrumentation count for insert is: "+avl.opCountInsert);
			search = "off";
		}
		if(search.equals("on"))
		{
			System.out.println("Access Denied!");
			System.out.println("operation count for find is: "+avl.opCountFind);
			System.out.println("operation count for insert is: "+avl.opCountInsert);
		}
		outStream.println("Instrumentation count for find is: "+avl.opCountFind);
		outStream.println("instrumentation count for insert is: "+avl.opCountInsert);
		outStream.close();
}
