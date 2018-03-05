
public class BinarySearchTreeTest {

	   public static void main(String [] args)
	   {
	      BinarySearchTree y = new BinarySearchTree();
	    
	      // insert a few elements
	      y.put(new Integer(1));
	      y.put(new Integer(6));
	      y.put(new Integer(4));
	      y.put(new Integer(8));
	      System.out.println("Elements in ascending order are");
	      y.ascend();
	      System.out.println();

	      // remove an element
	      System.out.println("Removed element " + y.remove(new Integer(4))) ;
	      System.out.println("Elements in ascending order are");
	      y.ascend();
	      System.out.println();

	      // remove another element
	      System.out.println("Removed element " + y.remove(new Integer(8))) ;
	      System.out.println("Elements in ascending order are");
	      y.ascend();
	      System.out.println();

	      // remove yet another element
	      System.out.println("Removed element " + y.remove(new Integer(6))) ;
	      System.out.println("Elements in ascending order are");
	      y.ascend();
	      System.out.println();

	      // try to remove a nonexistent element
	      System.out.println("Removed element " + y.remove(new Integer(6))) ;
	      System.out.println("Elements in ascending order are");
	      y.ascend();
	      System.out.println();
	   }
}
