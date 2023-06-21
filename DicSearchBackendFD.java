import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DicSearchBackendFD implements DicSearchBackendInterface{
     WordReaderFD w; RedBlackTreeFD rbt;
    public DicSearchBackendFD(WordReaderFD w,RedBlackTreeFD a)
    {
        this.w=w;this.rbt=a;
    }
    @Override
    public boolean insert(String word, String definition, String type) {
rbt.size++;//hardcoding to increase the size presuming that the insertion is valid
        return true;
    }

    @Override
    public void remove(String word) throws NoSuchElementException {
rbt.size--;//hardcoding to decrease the size
    }

    @Override
    public String getStatistics() {
        return "hi this is the hardcoded statistics";
    }

    @Override
    public List<String> getTypeSpeech(String word) throws NoSuchElementException {
        List<String> hardcode=new ArrayList<String>();
        hardcode.add("i");hardcode.add("love");hardcode.add("you");
        return hardcode;
    }

    @Override
    public List<String> getDefinition(String word) throws NoSuchElementException {
        List<String> hardcode=new ArrayList<String>();
        hardcode.add("she");hardcode.add("is");hardcode.add("beautiful");
        return hardcode;
    }

    @Override
    public void loadData(String filename) throws FileNotFoundException {
            throw new FileNotFoundException("hardcoded message");
    }

    @Override
    public void addDefinition(String word, String definition) throws NoSuchElementException {
        System.out.println("hardcoded accepted message");
    }

    @Override
    public void addType(String word, String type) throws NoSuchElementException {
        System.out.println("hardcoded accepted message2");
    }
}
