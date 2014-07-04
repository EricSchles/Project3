

/**
 * BST_Recursive class implements the Index interface.
 * It provides binary search tree structure. 
 *  
 * @author 
 * @version 
 *
 * @param <T>
 *    any reference type that implements Comparable<T> interface 
 */

public class BST_Recursive <T extends Comparable<T>> implements Index<T> {

	private BSTNode<T> root;
	private int numOfElements;
	private BSTNode<T> current;
	// TODO Add any other data fields here. 
	
	/**
	 * Creates an empty binary search tree.
	 */
	public BST_Recursive() {
		this.root = null;
		numOfElements = 0;
		this.current = root;
		// TODO Add any other initialization here. 
	}
	
	/* (non-Javadoc)
	 * @see proj3_posted.Index#insert(java.lang.Comparable)
	 */
	@Override
	public void insert(T item) {
		// TODO Provide recursive implementation of this method. 
		root = recAdd(item,root);
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

	
	
	 public BSTNode<T> lift(BSTNode<T> tree, BSTNode<T> toRemove)
	  {
	     if (tree.getRight() == null) {
	       toRemove.setData(tree.getData());
	       return tree.getLeft();  
	     }else {
	       tree.setRight(lift(tree.getRight(),toRemove));
	       return tree;
	     }
	  }
	  
	 
	
	/* (non-Javadoc)
	 * @see proj3_posted.Index#remove(java.lang.Comparable)
	 */
	@Override
	public void remove(T item) {
		// TODO Provide recursive implementation of this method. 
		root = recRemove(item, root);
	}
//source: http://www.cs.cmu.edu/~pattis/15-1XX/15-200/lectures/treeprocessing/
	private BSTNode<T> recRemove(T toRemove, BSTNode<T> tree)
	  // Adds element to tree; tree retains its BST property.
	  {
		if (tree == null)
		      return null;
		    else if ( toRemove.compareTo(tree.getData()) == 0 ) {
		       if (tree.getLeft()==null)
		         return tree.getRight();
		       else if (tree.getRight()==null)
		         return tree.getLeft();
		       else{ 
		         tree.setLeft(lift(tree.getLeft(),tree));
		         return tree;
		       }
		    }else{
		      if ( toRemove.compareTo( tree.getData()) < 0 )
		        tree.setLeft(recRemove(toRemove,tree.getLeft()));
		      else
		        tree.setRight(recRemove(toRemove,tree.getRight()));
		      return tree;
		    }
	  }

	
	/* (non-Javadoc)
	 * @see proj3_posted.Index#get(java.lang.Comparable)
	 */
	
	public T get(T item) {
		return recGet(item,root);
	}

	private T recGet(T item, BSTNode<T> tree){
		if( tree == null){
			return null;
		}else if(item.compareTo(tree.getData()) < 0){
			return recGet(item, tree.getLeft());
		}else{
			if(item.compareTo(tree.getData()) > 0){
				return recGet(item, tree.getRight());
			}else{
				return tree.getData();
			}
		}
		
	}

	/* (non-Javadoc)
	 * @see proj3_posted.Index#getNext()
	 */
	@Override
	public T getNext() {
	
	}

	private T recGetNext(T item, BSTNode<T> tree){
		
	}
	
	/* (non-Javadoc)
	 * @see proj3_posted.Index#resetNext()
	 */
	@Override
	public void resetNext() {
		// TODO Provide recursive implementation of this method. 
		
	}

	/* (non-Javadoc)
	 * @see proj3_posted.Index#size()
	 */
	@Override
	public int size() {
		// TODO Provide recursive implementation of this method. 
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Provide recursive implementation of this method. 
		return "";
	}
	
	

}
