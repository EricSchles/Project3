
/***********************************************************************/
/*                    DO  NOT  MODIFY  THIS  FILE                      */
/***********************************************************************/

/**
 * BSTNode class is used to represent nodes in a binary search tree.
 * It contains a data item that has to implement Comparable interface
 * and references to left and right subtrees. 
 * 
 * @author Joanna Klukowska
 * @version Mar 29, 2014
 *
 * @param <T> 
 *    a reference type that implements Comparable<T> interface 
 */
public class BSTNode <T extends Comparable <T> > implements Comparable <BSTNode <T> > {
	//reference to the left subtree 
	private BSTNode <T> left;
	//reference to the right subtree
	private BSTNode <T> right;
	//data item stored in the node
	private T data;
	
	/**
	 * Constructs a BSTNode initializing the data part 
	 * according to the parameter and setting both 
	 * references to subtrees to null.
	 * @param data
	 *    data to be stored in the node
	 */
	public BSTNode(T data) {
		this.data = data;
		left = null;
		right = null;
	}
	
	/**
	 * Constructs a BSTNode initializing the data part
	 * and the subtree references according to the parameters.
	 * @param data
	 *    data to be stored in the node
	 * @param left
	 *    reference to the left subtree
	 * @param right
	 *    reference to the right subtree
	 */
	public BSTNode( T data, BSTNode<T> left, BSTNode<T> right) {
		this.left = left;
		this.right = right;
		this.data = data;
	}

	/**
	 * Left subtree accessor. 
	 * @return 
	 *    reference to the left subtree of a node
	 */
	public BSTNode<T> getLeft() {
		return left;
	}
	
	/**
	 * Changes the reference to the left subtree to the one 
	 * specified in the parameter.
	 * @param left
	 *    reference to the new left subtree of the node.
	 */
	public void setLeft(BSTNode<T> left) {
		this.left = left;
	}
	
	/**
	 * Right subtree accessor. 
	 * @return 
	 *    reference to the right subtree of a node
	 */
	public BSTNode<T> getRight() {
		return right;
	}
	
	/**
	 * Changes the reference to the right subtree to the one 
	 * specified in the parameter.
	 * @param right
	 *    reference to the new right subtree of the node.
	 */
	public void setRight(BSTNode<T> right) {
		this.right = right;
	}
	
	/**
	 * Returns a reference to the data stored in the node. 
	 * @return 
	 *    reference to the data stored in the node
	 */
	public T getData() {
		return data;
	}
	/**
	 * Changes the data stored in the node to the one 
	 * specified in the parameter.
	 * @param data
	 *    reference to the new data of the node
	 */
	public void setData(T data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(BSTNode<T> other) {
		return this.data.compareTo(other.data);
	} 

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return data.toString();
	}
	
	
	
}
