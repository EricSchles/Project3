
/**
 * GenericLinkedList class implements the Index interface.
 * It stores nodes in sorted order. 
 * 
 * @author 
 * @version 
 *
 * @param <T>
 *    any reference type that implements Comparable<T> interface 
 */
public class GenericLinkedList <T extends Comparable<T>>implements Index<T> {

	private GenericNode<T> head;
	private int numOfElements;
	GenericNode<T> prevLoc;        // trailing reference
	GenericNode<T> location;       // traveling reference
	T listElement;            // current list element being compared      
	protected GenericNode<T> previous;   // node preceeding location

   
	// TODO Add any other data fields here. 
	
	
	/**
	 * Creates an empty list object. 
	 */
	public GenericLinkedList( ) {
		head = null;
		numOfElements = 0;
		
		
		// TODO Add any other initialization here. 
	}
	
	/* (non-Javadoc)
	 * @see proj3_posted.Index#insert(java.lang.Comparable)
	 */
	@Override
	public void insert(T item) {

	    // Set up search for insertion point.
	    location = head;
	    prevLoc = null;

	    // Find insertion point.
	    while (location != null)
	    {
	      listElement = location.getData();
	      if (listElement.compareTo(item) < 0)  // list element < add element
	      {
	         prevLoc = location;
	         location = location.getNext();
	      }
	      else
	        break;
	    }

	    // Prepare node for insertion.
	    GenericNode<T> newNode = new GenericNode<T>(item);

	    // Insert node into list.
	    if (prevLoc == null)         
	    {
	      // Insert as first node.
	      newNode.setNext(head);
	      head = newNode;
	    }
	    else
	    {
	      // Insert elsewhere.
	      newNode.setNext(location);
	      prevLoc.setNext(newNode);
	    }
	    numOfElements++;
	  }

	protected boolean find(T target)
	  // Searches list for an occurence of an element e such that
	  // e.equals(target). If successful, sets instance variables
	  // found to true, location to node containing e, and previous
	  // to the node that links to location. If not successful, sets 
	  // found to false.
	  {
	    location = head;
	    boolean found = false;

	    while (location != null) 
	    {
	      if (location.getData().equals(target))  // if they match
	      {
	       found = true;
	       return found;
	      }
	      else
	      {
	        previous = location;
	        location = location.getNext();
	      }
	    }
	    return found;
	  }
	
	

	/* (non-Javadoc)
	 * @see proj3_posted.Index#remove(java.lang.Comparable)
	 */
	@Override
	public void remove(T item) {
		// TODO Provide iterative implementation of this method. 
		if(find(item)){
			
		      if (head == location){     
		        location = location.getNext();    // remove first node
		      }else{
		        previous.setNext(location.getNext());  // remove node at location
		      }
		      numOfElements--;
		    
		}
	}

	/* (non-Javadoc)
	 * @see proj3_posted.Index#get(java.lang.Comparable)
	 */
	@Override
	public T get(T item) {
		boolean found = find(item);    
	    if (found)
	      return location.getData();
	    else
	      return null;
	}

	/* (non-Javadoc)
	 * @see proj3_posted.Index#getNext()
	 */
	@Override
	public T getNext() {
		// Preconditions: The list is not empty
		  //                The list has been reset
		  //                The list has not been modified since most recent reset
		  //
		  // Returns the element at the current position on this list.
		  // If the current position is the last element, then it advances the value 
		  // of the current position to the first element; otherwise, it advances
		  // the value of the current position to the next element.
		  {
			    
		    T next = location.getData();
		    if (location.getNext() == null){
		      location = head;
		    }else{
		      location = location.getNext();
		    }
		    return next;
		  }
	}

	/* (non-Javadoc)
	 * @see proj3_posted.Index#resetNext()
	 */
	@Override
	public void resetNext() {
		  // Initializes current position for an iteration through this list,
		  // to the first element on this list.
	
		    location  = head;
		  
	}

	/* (non-Javadoc)
	 * @see proj3_posted.Index#size()
	 */
	@Override
	public int size() {
		// TODO Provide iterative implementation of this method. 
		return numOfElements;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		 GenericNode<T> currNode = head;
		    String listString = "List:\n";
		    while (currNode != null)
		    {
		      listString = listString + "  " + currNode.getData() + "\n";
		      currNode = currNode.getNext();
		    }
		    return listString;
	}
	

}
