// --== CS400 Spring 2023 File Header Information ==--
// Name: Omkar Kendale
// Email: kendale@wisc.edu
// Team: DK
// TA: Yuye Jiang
// Lecturer: Florain Heimerl
// Notes to Grader: <optional extra notes>

import java.util.ArrayList;
import java.util.List;

/**
 * This is a placeholder class implemented by the backend to serve as the word data type for the rbt
 * @author omkar
 *
 */
public class WordBD implements WordInterface{

  private String word; //The word to be stored in the word object
  private ArrayList<String> descriptions; //The list of definitions to be stored in the word object
  private ArrayList<String> types; //The list of types of speech to be stored in the word object
  
  /**
   * Constructor for the word object, intialized fields
   * 
   * @param word the word for this object
   * @param description the definition for this object
   * @param type the type for this object
   */
  public WordBD(String word, ArrayList<String> type, ArrayList<String> description) {

    this.word = word;

    this.descriptions = description;

    this.types = type;
}

  /**
   * This method gets the word in the word object
   * 
   * @return the string of the word in this word object
   */
  @Override
  public String getWord() {
    return word;
  }

  /**
   * This method gets the list of definitions in the word object
   * 
   * @return an arraylist of definitions of the word in this word object
   */
  @Override
  public List<String> getDescription() {
    // TODO Auto-generated method stub
    return descriptions;
  }

  /**
   * This method gets the list of types in the word object
   * 
   * @return an arraylist of types of speech of the word in this word object
   */
  @Override
  public List<String> getType() {
    // TODO Auto-generated method stub
    return types;
  }

  @Override
  public int compareTo(WordInterface word) {
    return 0;
  }

 



}
