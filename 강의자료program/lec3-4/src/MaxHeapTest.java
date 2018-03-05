
public class MaxHeapTest {

	   public static void main(String [] args)
	   {
	      // test constructor and put
	      MaxHeap h = new MaxHeap(20);
	      h.put(new Integer(10));
	      h.put(new Integer(20));
	      h.put(new Integer(5));

	      // test toString
	      System.out.println("Elements in array order are");
	      System.out.println(h);
	      System.out.println();

	      h.put(new Integer(15));
	      h.put(new Integer(30));

	      System.out.println("Elements in array order are");
	      System.out.println(h);
	      System.out.println();

	      // test remove max
	      System.out.println("The max element is " + h.getMax());
	      System.out.println("Deleted max element " + h.removeMax());
	      System.out.println("Deleted max element " + h.removeMax());
	      System.out.println("Elements in array order are");
	      System.out.println(h.toString());
	   }

}
