// --== CS400 Spring 2023 File Header Information ==--
// Name: Omkar Kendale
// Email: kendale@wisc.edu
// Team: DK
// TA: Yuye Jiang
// Lecturer: Florain Heimerl
// Notes to Grader: < Ultimately, our code won't work because code from some role's code doesn't work>

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class implements the backend methods of our project. This class relies on the Data wrangler methods
 * and the Algorithm engineer methods
 * @author omkar
 *
 */
public class DicSearchBackendBD implements DicSearchBackendInterface {

  private WordReaderInterface wordReader; //This is the wordReader object 
  public RedBlackTreeInterface<WordInterface> rbt; //This is the redblacktree object
  private int[] methodCounts; //An array that stores how many times each method is called. Index 0 represents
                              //insert, index 0 represents insert index 1 represents addDefintion, 2 represents 
                              //addType, 3 represents getDefinition, 4 represents getType, and 5 represents removes
  
  /**
   * Constructor for backend object
   * 
   * @param wordReader the wordReader object to be used in this class
   * @param rbt the redblacktree object to be used in this class
   */
  DicSearchBackendBD(WordReaderInterface wordReader, RedBlackTreeInterface<WordInterface> rbt){
    //Initializes both objects
    this.wordReader = wordReader;
    this.rbt = rbt;
    //Intializes the methodCounts array to a size of 6 for each statistic we are keeping track of
    methodCounts = new int[6];
  }
  
  
  /**
   * This method creates the word object needed and passes it into the algorithm engineers insert method
   * 
   * @param word the word to insert
   * @param definition the definition of the word to insert
   * @param type the type of speech of the word to insert
   * @return true if the insert was successful, false otherwise
   */
  @Override
  public boolean insert(String word, String definition, String type) {
    //Create the word to insert
    ArrayList<String> tempDefinition = new ArrayList<String>();
    tempDefinition.add(definition);
    ArrayList<String> tempType = new ArrayList<String>();
    tempType.add(type);
    WordInterface toInsert = new WordDW(word, tempType, tempDefinition);
    try {
      rbt.insert(toInsert);
    }
    catch(Exception e1){
      //If the insert caused an error return false
      return false;
    }
    //Mark in the methodCounts array that we performed an insert
    methodCounts[0]++;
    return true;
  }

  /**
   * This method adds another definition to a word node
   * 
   * @param word the word to add the definition to
   * @param definition the definition to add
   */
  @Override
  public void addDefinition(String word, String definition) throws NoSuchElementException {
    //Finds the word to add the definition to 
    WordInterface wordNode = (WordDW) rbt.get(new WordDW(word, null, null));
    if(wordNode == null) {
      throw new NoSuchElementException("That word doesn't exist in the dictionary");
    }
    //Passes that word to the addDescription method of the word object
    wordNode.getDescription().add(definition);
    //Marks in methodCounts array that we added a definition
    methodCounts[1]++;
    
  }

  /**
   * This method returns the types of speech for a word
   * 
   * @param word the word to find the types of speech for
   * @return a list of types of speech for that word
   */
  @Override
  public List<String> getTypeSpeech(String word) throws NoSuchElementException {
    //Searches for the word node in the rbt
    WordInterface wordNode = (WordDW) rbt.get(new WordDW(word, null, null));
    if(wordNode == null) {
      throw new NoSuchElementException("That word doesn't exist in the dictionary");
    }
    //Indicates in methodCounts that we searched for a type
    methodCounts[4]++;
    //Returns the list of types
    return wordNode.getType();
    
  }

  /**
   * This method returns the definitions of a word
   * 
   * @param the word to find definitions for
   * @return a list of definitions for that word
   */
  @Override
  public List<String> getDefinition(String word) throws NoSuchElementException {
    //Finds word in the rbt
    WordInterface wordNode = (WordDW) rbt.get(new WordDW(word, null, null));
    if(wordNode == null) {
      throw new NoSuchElementException();
    }
    //Indicates we searched for a definition
    methodCounts[3]++;
    //returns a list of definitions
    return wordNode.getDescription();
  }

  /**
   * This methods passes the data wrangler object a filename to load data from
   * @param filename the name of the csv file
   */
  @Override
  public void loadData(String filename) throws FileNotFoundException{
    
    ArrayList<WordInterface> words =  (ArrayList<WordInterface>) wordReader.readWordsFromFile(filename);
    for(int i = 0; i < words.size(); i++) {
      rbt.insert(words.get(i));
    }
    
  }

  /**
   * This method passes a word node to be removed from the rbt to the algorithm engineer object
   * @param word the word in the wordNode to be removed
   */
  @Override
  public void remove(String word) throws NoSuchElementException {
    //Finds the word to be removed
    WordInterface toRemove = (WordDW) rbt.get(new WordDW(word, null, null));
    //if the node wasn't found in the dictionary, throw exception
    if(toRemove == null) {
      throw new NoSuchElementException();
    }
    //Passes that node to the algoEngineers remove method
    rbt.removeNode(toRemove);
    //Indicates in methodCounts we performed a removal
    methodCounts[5]++;
  }

  /**
   * This method adds another type to a word node
   * 
   * @param word the word to add the type to
   * @param type the type to add
   */
  @Override
  public void addType(String word, String type) throws NoSuchElementException {
    WordInterface wordNode = (WordDW) rbt.get(new WordDW(word, null, null));
  //if the node wasn't found in the dictionary, throw exception
    if(wordNode == null) {
      throw new NoSuchElementException();
    }
    wordNode.getType().add(type);
    methodCounts[2]++;
    
  }

  /**
   * This method outputs a string of statistics on how many times the user performed each method
   * 
   * @return a string contains statistics for how many times a user performed a certain action
   */
  @Override
  public String getStatistics() {
    return "You inserted a word " + methodCounts[0] + " times! \n" +
           "You added a definition " + methodCounts[1] + " times! \n" +
           "You added a type of speech " + methodCounts[2] + " times! \n" +
           "You searched for a defintion " + methodCounts[3] + " times! \n" +
           "You searched for the type of speech for a word " + methodCounts[4] + " times! \n" +
           "You removed a word from the dictionary " + methodCounts[5] + " times! \n";
  }

}
