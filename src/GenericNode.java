
/***********************************************************************/
/*                    DO  NOT  MODIFY  THIS  FILE                      */
/***********************************************************************/


/**
 * GenericNode class is used to represent nodes in a sorted linked list.
 * It contains a data item that has to implement Comparable interface
 * and a reference to the next node. 
 * 
 * @author Joanna Klukowska
 * @version Mar 2, 2014 
 *
 * @param <T> 
 *    a reference type that implements Comparable<T> interface 
 */

public class GenericNode <T extends Comparable<T> >  implements Comparable<GenericNode <T>>{
	//reference to the next node
	private GenericNode <T> next;
	//data item stored in the node
	private T data;

	
	/**
	 * Constructs a GenericNode initializing the data part 
	 * according to the parameter and setting reference to
	 * the next node to null.
	 * @param data
	 *    data to be stored in the node
	 */
	public GenericNode ( T data ) {
		if (data != null )
			this.data = data;
	}
	

	/**
	 * Constructs a GenericNode initializing the data part
	 * and the next node reference according to the parameters.
	 * @param data
	 *    data item to store in the node
	 * @param next
	 * 	  reference to the next node 
	+ */
	public GenericNode ( T data, GenericNode<T> next ) {
		if (data != null )
			this.data = data;
		if (next != null )
			this.next = next;
	}

	/**
	 * Next node accessor. 
	 * @return 
	 *    reference to the next node
	 */
	public GenericNode<T> getNext() {
		return next;
	}

	/**
	 * Changes the reference to the next node to the one 
	 * specified in the parameter.
	 * @param next
	 *    reference to the new next node.
	 */
	public void setNext(GenericNode<T> next) {
		this.next = next;
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
	public int compareTo(GenericNode<T> arg0) {
		
		return this.data.compareTo(arg0.data ); 
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return data.toString();
	}
		
	
}
