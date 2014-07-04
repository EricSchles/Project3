
import java.util.Stack;

public class BSTree <T extends Comparable <T> >   {

	protected BSTNode<T> root;
	
	
	public BSTree()
	  // Creates an empty BST object.
	  {
	    root = null;
	  }
	
	  private BSTNode<T> recAdd(T element, BSTNode<T> tree)
	  // Adds element to tree; tree retains its BST property.
	  {
	    if (tree == null)
	      // Addition place found
	      tree = new BSTNode<T>(element);
	    else if (element.compareTo(tree.getData()) <= 0)
	      tree.setLeft(recAdd(element, tree.getLeft()));    // Add in left subtree
	    else
	      tree.setRight(recAdd(element, tree.getRight()));   // Add in right subtree
	    return tree;
	  }

	  public void add (T element)
	  // Adds element to this BST. The tree retains its BST property.
	  {
	    root = recAdd(element, root);
	  }


	 //psuedo code at http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
	public void inOrderTraversal(){
		//step 1
		Stack<BSTNode<T>> stack = new Stack<BSTNode<T>>(); //Note the use of Node which is helpful for later in the method.

		//step 2
		//save a current node and set it root at the start.  This is our iterator.
		BSTNode<T> curr = root;
		
		//step 3
		while(curr != null){									
			stack.push(curr);
			curr = curr.getLeft();
		}
		
		//step 4 and 5
		while(stack.size() > 0){
			
			curr = stack.pop();
			System.out.println(curr.getData());
			
			if(curr.getRight() != null){
				curr = curr.getRight();
				
				//back to step 3
				while(curr != null){
					stack.push(curr);
					curr = curr.getLeft();
				}
			}
			
		}
	}
	  
	public boolean contains(T item){

		//create a root node for traversal, note the type.
		
		BSTNode<T> curr = root; 				//the current node
		boolean result; 						//the result of the search for the element.  Note result is not set initially.
		while(curr != null){ 
			//item < current node
			if(item.compareTo(curr.getData()) < 0){
				curr = curr.getLeft();
			}
			//item  > current node
			else if(item.compareTo(curr.getData()) > 0){
				curr = curr.getRight();
			}
			//item == current node
			else{
				result = true; 				//if a node matching the search value is found result is true.
											//note we only look for the first occurence.
				return result;
			}
		}
										
		result = false;						//If the node is not found result is set to null.
		return result;
	}
	
	
}
