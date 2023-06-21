import java.util.List;
import java.util.NoSuchElementException;

public interface DictionaryBackendInterfaceBD {

  //DictionaryBackendInterface(WordReaderInterface wordReader, RedBlackTreeInterface Rbt);
  public boolean insert(String word, String definition, String type);
  public void addDefinition(String word, String definition) throws NoSuchElementException;
  public String getStatistics();
  public List<String> getTypeSpeech(String word)throws NoSuchElementException;
  public List<String> getDefinition(String word) throws NoSuchElementException;
  public void loadData(String filename);
  public void remove(String word) throws NoSuchElementException;
  public void addType(String word,String type) throws NoSuchElementException;

}
