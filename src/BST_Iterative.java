

/***********************************************************************/
/*   IMPLEMENT ONLY IF YOU ARE COMPLETING THE EXTRA CREDIT PART        */
/***********************************************************************/


/**
 * BSIterative class implements the Index interface.
 * It provides binary search tree structure. 
 *  
 * @author 
 * @version 
 *
 * @param <T>
 *    any reference type that implements Comparable<T> interface 
 */

public class BST_Iterative <T extends Comparable<T>> implements Index<T> {


	private BSTNode<T> root;
	private int numOfElements;
	
	// TODO Add any other data fields here. 
	
	/**
	 * Creates an empty binary search tree.
	 */
	public BST_Iterative() {
		this.root = null;
		numOfElements = 0;
		// TODO Add any other initialization here. 
	}
	
	/* (non-Javadoc)
	 * @see proj3_posted.Index#insert(java.lang.Comparable)
	 */
	@Override
	public void insert(T item) {
		// TODO Provide iterative implementation of this method. 
		
	}

	/* (non-Javadoc)
	 * @see proj3_posted.Index#remove(java.lang.Comparable)
	 */
	@Override
	public void remove(T item) {
		// TODO Provide iterative implementation of this method. 
		
	}

	/* (non-Javadoc)
	 * @see proj3_posted.Index#get(java.lang.Comparable)
	 */
	@Override
	public T get(T item) {
		// TODO Provide iterative implementation of this method. 
		return null;
	}

	/* (non-Javadoc)
	 * @see proj3_posted.Index#getNext()
	 */
	@Override
	public T getNext() {
		// TODO Provide iterative implementation of this method. 
		return null;
	}

	/* (non-Javadoc)
	 * @see proj3_posted.Index#resetNext()
	 */
	@Override
	public void resetNext() {
		// TODO Provide iterative implementation of this method. 
		
	}

	/* (non-Javadoc)
	 * @see proj3_posted.Index#size()
	 */
	@Override
	public int size() {
		// TODO Provide iterative implementation of this method. 
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Provide iterative implementation of this method. 
		return "";
	}

}
