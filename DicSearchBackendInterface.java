import java.io.FileNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

public interface DicSearchBackendInterface {

  //DictionaryBackendInterface(WordReaderInterface wordReader, RedBlackTreeInterface Rbt);
  public boolean insert(String word, String defintion, String type);
  public void addDefinition(String word, String definiton) throws NoSuchElementException;
  public String getStatistics();
  public List<String> getTypeSpeech(String word)throws NoSuchElementException;
  public List<String> getDefinition(String word) throws NoSuchElementException;
  public void loadData(String filename) throws FileNotFoundException;
  public void remove(String word) throws NoSuchElementException;
  public void addType(String word,String type) throws NoSuchElementException;

}
