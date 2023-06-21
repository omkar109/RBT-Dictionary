// --== CS400 Project One File Header ==--
// Name: Pranav Mehrotra
// CSL Username: pmehrotra
// Email: pmehrotra3@wisc.edu
// Lecture #: Lecture4 3:30pm-4:20pm [M W F]
// Notes to Grader: <any optional extra notes to your grader>

import java.util.ArrayList;

/**
 * This class is an ADT to store and access a word's spelling, type and
 * description.
 * 
 * @author Pranav Mehrotra
 */
public class WordDW implements WordInterface{

	private String word; // Stores the word.

	private ArrayList<String> description; // Stores the various meanings of the word.

	private ArrayList<String> type; // Stores the type of word.

	/**
	 * This class creates an instance of a word.
	 * 
	 * @author Pranav Mehrotra
	 * @param word:        A string containing the word.
	 * @param type:        A string containing the type of the word.
	 * @param description: An arrayList storing the various meanings of the word.
	 */
	public WordDW(String word, ArrayList<String> type, ArrayList<String> description) {

		this.word = word;

		this.description = description;

		this.type = type;
	}

	/**
	 * This class creates an instance of a word.
	 * 
	 * @author Pranav Mehrotra
	 * @return A string containing the word.
	 */
	@Override
	public String getWord() {

		return this.word;
	}

	/**
	 * This class creates an instance of a word.
	 * 
	 * @author Pranav Mehrotra
	 * @return An arraylist containing the various meanings of the word.
	 */
	@Override
	public ArrayList<String> getDescription() {

		return this.description;
	}

	/**
	 * This class creates an instance of a word.
	 * 
	 * @author Pranav Mehrotra
	 * @return A string containing the type of the word.
	 */
	@Override
	public ArrayList<String> getType() {

		return this.type;
	}

	/**
	 * This method compares two word objects and returns an integer corresponding with which word is alphabetically
	 * first.
	 *
	 * @author Omkar, backend developer wrote this method to even out workloads
	 *
	 * @param wordToCompare the word to compare against
	 * @return -1 if this word you are comparing to wordToCompare is alphabetically first. Returns 0 if both words 
	 *         are the same. Returns 1 if wordToCompare alphabetically comes before the word you are calling this on.  
	 */
	@Override
        public int compareTo(WordInterface wordToCompare) {
              return this.getWord().compareTo(wordToCompare.getWord());
        }

}
