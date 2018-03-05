
// import java.util.*;

public class Chain<Type2> {
   // data members
   protected ChainNode<Type2> firstNode;
   protected int size;

   // constructors
   /** create a list that is empty */
   public Chain(int initialCapacity)
   {
     firstNode = null ;
     size = initialCapacity ;
   }

   public Chain()
      {this(0);}

   // methods
   /** @return true iff list is empty */
   public boolean isEmpty()
      {return size == 0;}

   /** @return current number of elements in list */
   public int size()
      {return size;}

   /** @throws IndexOutOfBoundsException when
     * index is not between 0 and size - 1 */
   void checkIndex(int index)
   {
      if (index < 0 || index >= size)
         throw new IndexOutOfBoundsException
               ("index = " + index + "  size = " + size);
   }

   /** @return element with specified index
     * @throws IndexOutOfBoundsException when
     * index is not between 0 and size - 1 */
   public Type2 get(int index)
   {
      checkIndex(index);
   
      // move to desired node
      ChainNode<Type2> currentNode = firstNode;
      for (int i = 0; i < index; i++)
         currentNode = currentNode.next;
   
      return currentNode.element;
   }

   /** @return index of first occurrence of theElement,
     * return -1 if theElement not in list */
   public int indexOf(Type2 theElement)
   {
      // search the chain for theElement
      ChainNode<Type2> currentNode = firstNode;
      int index = 0;  // index of currentNode
      while (currentNode != null &&
            !currentNode.element.equals(theElement))
      {
         // move to next node
         currentNode = currentNode.next;
         index++;
      }
   
      // make sure we found matching element
      if (currentNode == null)
         return -1;
      else
         return index;
   }

   /** Remove the element with specified index.
     * All elements with higher index have their
     * index reduced by 1.
     * @throws IndexOutOfBoundsException when
     * index is not between 0 and size - 1
     * @return removed element */
   public Type2 remove(int index)
   {
      checkIndex(index);
   
      Type2 removedElement;
      if (index == 0) // remove first node
      {
         removedElement = firstNode.element;
         firstNode = firstNode.next;
      }
      else 
      {  // use q to get to predecessor of desired node
         ChainNode<Type2> q = firstNode;
         for (int i = 0; i < index - 1; i++)
            q = q.next;
      
         removedElement = (Type2) q.next.element;
         q.next = q.next.next; // remove desired node
      }
      size--;
      return removedElement;
   }

   /** Insert an element with specified index.
     * All elements with equal or higher index
     * have their index increased by 1.
     * @throws IndexOutOfBoundsException when
     * index is not between 0 and size */
   public void add(int index, Type2 theElement)
   {
      if (index < 0 || index > size)
         // invalid list position
         throw new IndexOutOfBoundsException
               ("index = " + index + "  size = " + size);
   
      if (index == 0)
         // insert at front
         firstNode = new ChainNode<Type2>(theElement, firstNode);
      else
      {   // find predecessor of new element
         ChainNode<Type2> p = firstNode;
         for (int i = 0; i < index - 1; i++)
            p = p.next;
      
          // insert after p
         p.next = new ChainNode<Type2>(theElement, p.next);
      }
      size++;
   }

   /** convert to a string */
   public String toString()
   {
      StringBuffer s = new StringBuffer("["); 
   
      // put elements into the buffer
      ChainNode<Type2> currentNode = firstNode;
      while(currentNode != null)
      {
         if (currentNode.element == null)
            s.append("null, ");
         else
            s.append(currentNode.element.toString() + ", ");
         currentNode = currentNode.next;
      }
      if (size > 0)
         s.delete(s.length() - 2, s.length());  // remove last ", "
      s.append("]");
   
      // create equivalent String
      return new String(s);
   }
}

