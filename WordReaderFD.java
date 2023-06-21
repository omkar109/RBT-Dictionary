import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
public class WordReaderFD implements WordReaderInterface{
    List<WordInterface> mylist;
    public WordReaderFD(){
        mylist=new ArrayList<WordInterface>();
    }
    @Override
    public List<WordInterface> readWordsFromFile(String filename) throws FileNotFoundException {
//not actually reading the file-just hardcoded 3 words
        WordFD word1=new WordFD("word1","def1","type1");
        WordFD word2=new WordFD("word2","def2","type2");
        WordFD word3=new WordFD("word3","def3","type3");
        mylist.add(word1);
        mylist.add(word2);mylist.add(word3);
        return mylist;
    }
}
