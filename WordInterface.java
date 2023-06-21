import java.util.List;

public interface WordInterface extends Comparable<WordInterface>{
   // public WordInterface(String word, String description, String type);
   public String getWord();
   public List<String> getDescription();
   public List<String> getType();
   public int compareTo(WordInterface word);

}
