
public class LinkedStackTest {

	   public static void main(String [] args)
	   {  
	      LinkedStack<Integer> s = new LinkedStack<Integer>();
	      // add a few elements
	      s.push(new Integer(1));
	      s.push(new Integer(2));
	      s.push(new Integer(3));
	      s.push(new Integer(4));

	      // delete all elements
	      while (!s.empty())
	      {
	         System.out.println("Top element is " + s.peek());
	         System.out.println("Removed the element " + s.pop());
	      }
	   }  
}
