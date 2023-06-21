import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This is a placeholder class implemented by the backend for the RedBlackTree
 * @author omkar
 *
 */
public class RedBlackTreeBD implements RedBlackTreeInterface<WordInterface>{

  
  private ArrayList<WordBD> treeArray; //Represents the red black tree but as an arraylist instead of an actual tree
  
  /**
   * Constructor for redblacktree object, intializes the rbt
   */
  public RedBlackTreeBD() {
    treeArray = new ArrayList<WordBD>();
  }
  

  /**
   * This method gets passed in a node with a word and outputs the node in the rbt with that same word
   * 
   * @param node the node to look for in the rbt
   */
  @Override
  public WordInterface get(WordInterface node) {
  //Looks for the node in the rbt that has the same word as the word in the node passed in 
    for(int i = 0;i < treeArray.size(); i++) {
      if(treeArray.get(i).getWord().equals(node.getWord())) {
        //returns the node with the matching word
        return treeArray.get(i);
      }
    }
    return node;
  }

  /**
   * This method removes the node is the rbt with the same word as the node thats passed in
   * 
   * @param node the node to be removed from the rbt
   * @return a string indicating what node was removed (this is for testing purposes)
   */
  @Override
  public boolean removeNode(WordInterface node) throws NoSuchElementException {

  return true;
  }

  /**
   * This method inserts the node in the rbt
   * 
   * @param node the node to be inserted into the rbt
   * @return boolean indicating if the insert was successful
   */
  @Override
  public boolean insert(WordInterface node) {
  //Adds node to the tree
    treeArray.add((WordBD) node);
    //return true if insert was successful and no errors occurred
    return true;
  }

}
