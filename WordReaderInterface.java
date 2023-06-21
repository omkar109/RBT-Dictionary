import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public interface WordReaderInterface {
//Public WordReaderXX()
//make an arraylist to get the words of the file and then they  can be put into the rbt by the algo engineers
   
   public List<WordInterface> readWordsFromFile(String filename) throws FileNotFoundException;

}
