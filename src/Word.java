


/***********************************************************************/
/*                    DO  NOT  MODIFY  THIS  FILE                      */
/***********************************************************************/


/**
 * Word class represents unique words and their counts.
 * 
 * @author Joanna Klukowska
 * @version Mar 28, 2014 
 *
 */
public class Word implements Comparable <Word> {
	//string representing a unique word
	private String word;
	//counter for this word
	private int count;
	
	/**
	 * Constructs a Word object given a word passed 
	 * as a parameter and initializes its count to 1.
	 * @param word
	 */
	public Word( String word ) {
		this.word = word;
		count = 1;
	}

	/**
	 * Increments count of this word. 
	 * @return
	 *    the new value of counter
	 */
	public int incrementCount( ) {
		count++;
		return count;
	} 
	
	/**
	 * Returns a reference to the String object stored in this Word. 
	 * @return 
	 *    reference to the String object stored in this Word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Returns a value of the counter variable for this Word
	 * @return 
	 *    the counter variable for this word
	 */
	public int getCount() {
		return count;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Word other) {
		return this.word.compareTo( other.word );
	} 
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return String.format("%5d  %s", count, word);
	}
	
}
