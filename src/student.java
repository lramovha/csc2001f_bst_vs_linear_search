import java.util.*;
import java.io.*;
/**
  *@author Ramovha Lasy
  *
*/
public class student 
{
	public static Scanner newScannerKey;
	String [] studentID = new String[5000];    //Attributes are variables of a class
	String [] studentName = new String[5000];
	String [] studentSurname = new String[5000];
	String search;
	int opCount;

	BinarySearchTree<String> b = new BinarySearchTree<String>();

	/**opens the file with specified path
  	 *@param filePath the path of the file to open
	*/
	public void openFile(String filePath)     //methods are function of a class
	{
		try
		{
			File f = new File(filePath);
			newScannerKey = new Scanner(f);
		}
		catch(Exception e)
		{
			System.out.println("error - file not found");
			System.exit(0);
		}
	}

	/**
  	 * Reads the text file and store the data in the array
	*/
	public void readFile()
	{
		int row = 0;
		String[] indexLine;

		while(newScannerKey.hasNext())
		{
			indexLine = (newScannerKey.nextLine()).split(" ");
			studentID[row] = indexLine[0];
			//System.out.println(indexLine[0]);
			studentName[row] = indexLine[1];
			studentSurname[row] = indexLine[2];
			row++;
		}	
	}

	/**
  	 * prints all studentID and names in the array
	*/

	public void printAllStudents()
	{
		for (int index = 0; index < 5000; index++)
		{
			System.out.println("Student Number: "+studentID[index]);
			System.out.println("Student Name: "+studentName[index]+" "+studentSurname[index]+"\n");
		}
	}

	/**Prints student name given the student ID as Key usind the Array
  	 *@param studentId student id/student number
	*/

	public void printStudent(String studentId)
	{
		PrintWriter outStream = null;
		try
		{
			FileOutputStream fout = new FileOutputStream("/home/hope/csc2001f_uct/assignment1/RMVLAS001/data/Instrumentation.txt");
			outStream = new PrintWriter(fout);
		}
		catch(Exception e)
		{
			System.out.println("error - cannot open Instrumentation.txt");
			System.exit(0);
		}

		search = "on";
		opCount = 0;

		for(String temp:studentID)
		{
			opCount++;
			if (temp.trim().equals(studentId))
			{
				System.out.println("Student number: "+studentID[opCount - 1]+"\nstudent name: "+studentName[opCount - 1]+" "+studentSurname[opCount - 1]);
				System.out.println("The instrumentaion count for Array is: "+opCount);  // test to be removed
				search = "off";
				break;
			}
		}

		if (search.equals("on"))
		{
			System.out.println("Access Denied!");
			System.out.println("The instrumentaion count for Array is: "+opCount);
		}
		outStream.println("The instrumentaion count for Array is: "+opCount);
		outStream.close();
	}

	/**
  	 * read the input text file and insert the data to a binary Tree Node
	*/

	public void readFileBst()
	{
		int row = 0;
		String[] indexLine;

		while(newScannerKey.hasNext() && row < 5000)
		{
			indexLine = (newScannerKey.nextLine()).split(" ");
			b.insert(indexLine[0], indexLine[1], indexLine[2]);
			row++;
		}
	}

	/**
  	 * prints all students using the preOrder algorythm in the Binary Search Tree
	*/

	public void printAllStudentsBst()
	{
		b.preOrder();
	}

	/**Prints student name given the student ID as Key in the Binary Search Tree
  	 *@param student_id student id/student number
	*/

	public void printStudentBst(String student_id)
	{
		PrintWriter outStream = null;
		try
		{
			FileOutputStream fout = new FileOutputStream("/home/hope/csc2001f_uct/assignment1/RMVLAS001/data/InstrumentationBST.txt");
			outStream  = new PrintWriter(fout);
		}
		catch(Exception e)
		{
			System.out.println("error - cannot open InstrumentationBST.txt");
			System.exit(0);
		}

		search = "on";

		if(b.find(student_id) != null)
		{
			System.out.println(b.find(student_id));
			System.out.println("Instrumentation count for BST is: "+b.countBST);
			search = "off";
		}
		if(search.equals("on"))
		{
			System.out.println("Access Denied!");
			System.out.println("The instrumentaion count for BST is: "+b.countBST);
		}
		outStream.println("Instrumentation count for BST is: "+b.countBST);
		outStream.close();
	}

}
