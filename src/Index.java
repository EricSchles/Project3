
/***********************************************************************/
/*                    DO  NOT  MODIFY  THIS  FILE                      */
/***********************************************************************/


/**
 * An interface for container classes used for storing data in sorted order. 
 * 
 * @author Joanna Klukowska
 * @version Mar 29, 2014 
 *
 * @param <T>
 *    any reference type that implements comparable 
 */
public interface Index <T extends Comparable <T> >  {

	/**
	 * Adds an item to the index in sorted order.
	 * @param item
	 *    new item to be added
	 */
	void insert (T item );
	
	/**
	 * Removes an item from the index if it exists, 
	 * otherwise the index remains unchanged.
	 * @param item
	 *    item to be removed
	 */
	void remove (T item );
	
	/**
	 * Returns a reference to the item stored in the index,
	 * or null if such item does not exits.
	 * @param item
	 *    item to which the reference should be returned
	 * @return
	 *    reference to the item stored in the index,
	 *    or null if it does not exist
	 */
	T get ( T item );
	
	/**
	 * Return a reference to the next item stored in the index.
	 * Should be initialized by a call to resetNext() to start at the 
	 * beginning of the index.
	 * @return
	 *    reference to the next item in the index
	 */
	T getNext ();
	
	/**
	 * Resets the iterator to the beginning of the list.
	 */
	void resetNext(); 
	
	/**
	 * Returns number of items stored in the index.
	 * @return
	 *    number of items stored in the index.
	 */
	int size ();
	
}
