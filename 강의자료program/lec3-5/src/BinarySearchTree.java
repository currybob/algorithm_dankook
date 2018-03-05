
public class BinarySearchTree {

		protected BinaryTreeNode root ;   // 이진탐색트리의 루트
		
	   /** @return element with specified key
	     * @return null if no matching element */
	   public BinaryTreeNode get(Object theKey)   // 탐색
	   {
	      // pointer p starts at the root and moves through
	      // the tree looking for an element with key theKey
	      BinaryTreeNode p = root;
	      Comparable searchKey = (Comparable) theKey;
	      while (p != null)
	         // examine p.element
	         if (searchKey.compareTo(p.element) < 0)
	            p = p.leftChild;
	         else
	            if (searchKey.compareTo(p.element) > 0)
	               p = p.rightChild;
	            else // found matching element
	               return p ;

	      // no matching element
	      return null;
	   }
	   
	   /** insert an element with the specified key
	     * @return old element (if any) with key theKey */
	   public Object put(Object theKey)   // 삽입
	   {
	      BinaryTreeNode p = root,     // search pointer
	                     pp = null;    // parent of p
	      Comparable elementKey = (Comparable) theKey;
	      // find place to insert theElement
	      while (p != null)
	      {// examine p.element
	         pp = p;
	         // move p to a child
	         if (elementKey.compareTo(p.element) < 0)
	            p = p.leftChild;
	         else if (elementKey.compareTo(p.element) > 0)
	                 p = p.rightChild;
	              else
	              {// return element with same key
	                 return p.element;
	              }
	      }
   
	      // get a node for theElement and attach to pp
	      BinaryTreeNode r = new BinaryTreeNode(theKey);
	      if (root != null)
	         // the tree is not empty
	         if (elementKey.compareTo(pp.element) < 0)
	            pp.leftChild = r;
	         else
	            pp.rightChild = r;
	      else // insertion into empty tree
	         root = r;
	      return null;
	   }
	   
	   /** @return matching element and remove it
	     * @return null if no matching element */
	   public Object remove(Object theKey)
	   {
	      Comparable searchKey = (Comparable) theKey;

	      // set p to point to node with key searchKey
	      BinaryTreeNode p = root,    // search pointer
	                     pp = null;   // parent of p
	      while (p != null && !(p.element).equals(searchKey))
	      {// move to a child of p
	         pp = p;
	         if (searchKey.compareTo(p.element) < 0)
	            p = p.leftChild;
	         else
	            p = p.rightChild;
	      }

	      if (p == null) // no element with key searchKey
	         return null;
	   
	      // save element to be removed
	      Object theElement = p.element ; 
	   
	      // restructure tree
	      // handle case when p has two children
	      if (p.leftChild != null && p.rightChild != null)
	      {// two children
	         // convert to zero or one child case
	         // find element with largest key in left subtree of p
	         BinaryTreeNode s = p.leftChild,
	                        ps = p;  // parent of s
	         while (s.rightChild != null)
	         {// move to larger element
	            ps = s;
	            s = s.rightChild;
	         }
	   
	         // move largest element from s to p
	         p.element = s.element;
	         p = s;
	         pp = ps;
	      }
	   
	      // p has at most one child, save this child in c
	      BinaryTreeNode c;
	      if (p.leftChild == null)
	         c = p.rightChild;
	      else
	         c = p.leftChild;
	   
	      // remove node p
	      if (p == root) root = c;
	      else
	      {// is p left or right child of pp?
	         if (p == pp.leftChild)
	            pp.leftChild = c;
	         else
	            pp.rightChild = c;
	      }
	   
	      return theElement;
	   }

	   /** output elements in ascending order of key */
	   public void ascend()
	      {inOrder(root);}
	   
	   public void inOrder(BinaryTreeNode t)
	   {
	      if (t != null)
	      {
	         inOrder(t.leftChild);   // do left subtree
	         System.out.print(t+" ");    // visit tree root
	         inOrder(t.rightChild);  // do right subtree
	      }
	   }

}
