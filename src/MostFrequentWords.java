

/***********************************************************************/
/*  MODIFY  THIS  FILE  ONLY IF YOU ARE COMPLETING EXTRA CREDIT PART   */
/***********************************************************************/


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * The MostFrequentWords program parses an input text file and uses
 * different data structures to compute the frequency of words that appear
 * in the input file. I produces a list of most frequent words.
 * <p>
 * Usage:
 * <p>The program is called from the command line and expects three parameters:
 * <p>&nbsp;&nbsp;&nbsp;&nbsp;  java MostFrequentWords inputFile cutOffValue outputFile
 *   
 * <p>inputFile   is a text file containing words to be counter
 * <p>cutOfValue  is a positive integer, only the words whose count is equal to or grater
 *             than the cutOfValue are printed to the output file
 * <p>outputFile  is a text file containing results of the computations,
 *             it prints all the words that occur at least cutOfValue many times in 
 *             the input file in alphabetical order, one per line together with their counts 
 *  
 * @author Joanna Klukowska
 * @version Mar 28, 2014 
 *
 */
public class MostFrequentWords {

	/**
	 * @param args 
	 *    command line arguments as described above
	 */
	public static void main(String[] args) {
		//timers used for performance evaluation of different data structures
		long start, end;
		
		//verify number of command line arguments
		if ( args.length < 3 ) {
			System.err.printf("\nERROR : missing parameters. \n\n");
			System.exit(1);
		}
		
		//make sure that the output file argument is valid
		File outFile = new File (args[2]);
		PrintWriter out = null;
		
		if ( outFile.canWrite() || !outFile.exists() )  {
			try {
				out = new PrintWriter( outFile );
			} catch (FileNotFoundException e) {
				System.err.println ("ERROR: problem encountered opening output file.");
				System.err.println ( e.getMessage() ) ;
				System.exit(1);
			}
		}
		
		//initial storage of all words in the input file 
		ArrayList <String> allWords = new ArrayList<String> ();
		
		//FileParser object processes the input file and produces a list
		//containing all words found in the input file
		FileParser fp = null;
		try {
			fp = new FileParser( args[0] ) ;
		}
		catch (IOException e ) {
			System.err.println ("ERROR: problem encountered reading file:");
			System.err.println ( e.getMessage() ) ;
			System.exit(1);
		}
		//process the input file and display information about processing time
		//and number of words read 
		start = System.nanoTime();
		allWords = fp.getAllWords();
		end = System.nanoTime(); 
		System.out.printf("INFO: Reading file took %d ms (~ %7.3f seconds).\n", 
				(end - start)/1000, (end - start)/1000000000.0  );
		
		System.out.printf("INFO: %d words read. \n", allWords.size() );
		
		//wordList can be instantiated to different data structures
		//it is used for keeping words and their frequencies
		Index < Word > wordList = null;
		
		//process the words using linked list
		wordList = new GenericLinkedList < Word > () ; 
		runTest ( wordList, allWords, System.out, Integer.valueOf( args[1] ));
		
		/*
		 * TODO Uncomment this block if you are implementing 
		 *      the extra credit part. 
		 * 
		//process the words using iterative bst
		wordList = new BST_Iterative < Word > () ; 
		runTest ( wordList, allWords, System.out,  Integer.valueOf( args[1] ));
		*/
		
		//process the words using recursive bst
		wordList = new BST_Recursive < Word > () ; 
		runTest ( wordList, allWords, System.out,  Integer.valueOf( args[1] ));
		
		//write data to the output file 
		out.println(wordList );
		
		//close the output stream
		out.close(); 
	}
	
	/**
	 * Produces counts of each words in allWords list using index data structure and retains only the words
	 * whose count is at least minCount. The information about time used for processing and number
	 * of words remaining in the index structure are printed to the out stream.
	 * 
	 * @param index
	 *    data structure used for storing unique words and their counts
	 * @param allWords
	 *    list of all the words (contains multiple occurrences of words) 
	 * @param out
	 *    output stream to which statistics should be printed
	 * @param minCount
	 *    smallest counter for words that should remain in the data structure 
	 */
	public static void runTest ( Index <Word> index,  ArrayList<String> allWords, PrintStream out, int minCount )  {
		
		long start, end;
		String className = null;
		//print the information about data structure used
		if ( index instanceof GenericLinkedList)
			className = "Sorted Linked List";
		else if ( index instanceof BST_Recursive)
			className = "Recursive BST";
		else if ( index instanceof BST_Iterative)
			className = "Iterative BST";
		else 
			className = " Index ";
		out.printf("\nProcessing using %s\n", className);
		
		//add words from allWords to the data structure referenced by index
		//and print the information
		start = System.nanoTime();
		populateIndex( index, allWords); 
		end = System.nanoTime(); 
		out.printf("INFO: Creating index took %d ms (~ %7.3f seconds).\n",
				(end - start)/1000, (end - start)/1000000000.0  );
		out.printf("INFO: %d words stored in index.\n", index.size() );
				
		//prune the index by removing words whose count is smaller than minCount
		//and print the information 
		start = System.nanoTime();
		pruneIndex( index, minCount); 
		end = System.nanoTime(); 
		out.printf("INFO: Pruning index took %d ms (~ %7.3f seconds).\n",
				(end - start)/1000, (end - start)/1000000000.0  );
		out.printf("INFO: %d words remaining after pruning.\n", index.size() );	
		
	}
	
	/**
	 * Populates index data structure with words from allWords list. 
	 * index stores unique words and their counts.
	 * @param index
	 *    data structure to store unique words and their counts 
	 * @param allWords
	 *    list of all the words (contains multiple occurrences of words)
	 */
	public static void populateIndex ( Index <Word> index, ArrayList<String> allWords ) {
		Word tmp;
		Word check;
		//for each word in allWords list
		for (String currentString : allWords ) { 
			tmp = new Word (currentString);
			//check if the word exists in index
			check = index.get(tmp);
			//if it already exists, increment its counter
			if ( check != null ) {
				check.incrementCount();
			}
			//otherwise add it to the list
			else { 
				index.insert( tmp );
			}
		}
	}

	/**
	 * Prunes (removes) all words whose count is smaller than minCount.
	 * @param index
	 *    data structure to store unique words and their counts 
	 * @param minCount
	 *    smallest counter for words that should remain in the data structure 
	 */
	public static void pruneIndex ( Index <Word> index, int minCount ) {
		//reset the iterator to the beginning of index
		index.resetNext();
		//get the first Word object from index
		Word tmp = index.getNext();
		//as long as we are not at the end of the list
		while ( tmp != null ) {
			//if the current Word object's count is smaller than minCount, remove it from index
			if ( tmp.getCount() < minCount ) {
				index.remove( tmp ); 
			}
			//get the next Word object
			tmp = index.getNext();
		}
	}
}
