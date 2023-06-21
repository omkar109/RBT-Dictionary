import java.util.Scanner;
import java.util.List;
public interface DicSearchFrontendInterface {
    //    public DicSearchFrontendXX(Scanner userInput,DicSearchBackendInterface backend);
    public  void runCommandLoop();

    public char mainMenuPrompt();
    public void loadDataCommand();
    public String chooseWordPrompt();
    public void searchWord(String prompt);
    public void searchTypeSpeech(String prompt);
    public void addWord();
    public void removeWord();
    public void displayStatsCommand();
    public void addDefinition();
public void searchDefinition(String prompt);
public void addType();
}
