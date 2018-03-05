// import utilities.ChangeArrayLength ;

	public class MaxHeap 
	{
	   // data members
	   Comparable [] heap;   // array for complete binary tree
	   int size;             // number of elements in heap

	   // constructors
	   /** create a heap with the given initial capacity
	     * @throws IllegalArgumentException when
	     * initialCapacity < 1 */
	   public MaxHeap(int initialCapacity)
	   {
	      if (initialCapacity < 1)
	         throw new IllegalArgumentException
	                   ("initialCapacity must be >= 1");
	      heap = new Comparable [initialCapacity + 1];
	      size = 0;
	   }
	   
	   /** create a heap with initial capacity 10 */
	   public MaxHeap()
	      {this(10);}

	   // methods
	   /** @return true iff the heap is empty */
	   public boolean isEmpty()
	      {return size == 0;}

	   /** @return number of elements in the heap */
	   public int size()
	      {return size;}

	   /** @return maximum element
	     * @return null if the heap is empty */
	   public Comparable getMax()
	      {return (size == 0) ? null : heap[1];}

	   /** put theElement into the heap */
	   public void put(Comparable theElement)
	   {
	      // increase array size if necessary
	      if (size == heap.length - 1)
	    	  System.out.println("Heap is full. No insertion.");
//	         heap = (Comparable []) ChangeArrayLength.changeLength1D
//	                                    (heap, 2 * heap.length);
	      else {
	    	  // find place for theElement
	    	  // currentNode starts at new leaf and moves up tree
	    	  int currentNode = ++size;
	    	  while (currentNode != 1 &&
	             heap[currentNode / 2].compareTo(theElement) < 0)
	    	  {
	    		  // cannot put theElement in heap[currentNode]
	    		  heap[currentNode] = heap[currentNode / 2]; // move element down
	    		  currentNode /= 2;                          // move to parent
	    	  }
	   
	    	  heap[currentNode] = theElement;
	      }
	   }
	   
	   /** remove max element and return it */
	   public Comparable removeMax()
	   {
	      // if heap is empty return null
	      if (size == 0) return null;       // heap empty
	   
	      Comparable maxElement = heap[1];  // max element
	   
	      // reheapify
	      Comparable lastElement = heap[size--];
	   
	      // find place for lastElement starting at root
	      int currentNode = 1,
	          child = 2;     // child of currentNode
	      while (child <= size)
	      {
	         // heap[child] should be larger child of currentNode
	         if (child < size &&
	             heap[child].compareTo(heap[child + 1]) < 0) child++;
	   
	         // can we put lastElement in heap[currentNode]?
	         if (lastElement.compareTo(heap[child]) >= 0)
	            break;   // yes
	   
	         // no
	         heap[currentNode] = heap[child]; // move child up
	         currentNode = child;             // move down a level
	         child *= 2;
	      }
	      heap[currentNode] = lastElement;
	   
	      return maxElement;
	   }
	   
	   public String toString()
	   {
	      StringBuffer s = new StringBuffer(); 
	      s.append("The " + size + " elements are [");
	      if (size > 0)
	      {// nonempty heap
	         // do first element
	         s.append(heap[1]);
	         // do remaining elements
	         for (int i = 2; i <= size; i++)
	            s.append(", " + heap[i]);
	      }
	      s.append("]");

	      return new String(s);
	   }

}
