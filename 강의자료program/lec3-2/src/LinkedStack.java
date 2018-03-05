
import java.util.EmptyStackException;

public class LinkedStack <Type2>
{
   // data members
   protected ChainNode<Type2> topNode;

   // constructors
   /** create an empty stack */
   public LinkedStack(int initialCapacity)
   {
       topNode = null ;
   }

   public LinkedStack()
      {this(0);}

   // methods
   /** @return true iff stack is empty */
   public boolean empty()
      {return topNode == null;}


   /** @return top element of stack 
     * @throws EmptyStackException when the stack is empty */
   public Type2 peek()
   {
      if (empty())
         throw new EmptyStackException();   // 빈 스택일 경우 예외를 발생
      return topNode.element;
   }

   /** add theElement to the top of the stack */
   public void push(Type2 theElement)
      {topNode = new ChainNode<Type2>(theElement, topNode);}

   /** remove top element of stack and return it
     * @throws EmptyStackException when the stack is empty */
   public Type2 pop()
   {
      if (empty())
         throw new EmptyStackException();
      Type2 topElement = topNode.element;
      topNode = topNode.next;
      return topElement;
   }
}  
