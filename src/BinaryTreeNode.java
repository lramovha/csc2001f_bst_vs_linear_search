// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

public class BinaryTreeNode<dataType>
{
   dataType data;
   dataType name;
   dataType surname;
   BinaryTreeNode<dataType> left;
   BinaryTreeNode<dataType> right;
   
   public BinaryTreeNode ( dataType d, dataType s_name, dataType s_surname, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r )
   {
      data = d;
      name = s_name;
      surname = s_surname;
      left = l;
      right = r;
      //System.out.println(s_name);
   }

   BinaryTreeNode<dataType> getLeft ()
   { 
	   return left; 
   }
   BinaryTreeNode<dataType> getRight ()
   { 
	   return right; 
   }

   public String toString()
   {
      return "student number: "+data+"\nstudent name: "+name+" "+surname+"\n";
   }
   
}
