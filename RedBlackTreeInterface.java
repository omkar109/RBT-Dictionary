
import java.util.NoSuchElementException;

public interface RedBlackTreeInterface<nodeType> {

//public RedBlackTreeAE(); week 3
 //public RedBlackTreeInterface(); week 4
public nodeType get(nodeType node);
/*gets the node that is equal to the argument, found by the .compareto() method. If the node is not found, returns null*/
public boolean removeNode(nodeType node) throws NoSuchElementException;
public boolean insert(nodeType node);

}



