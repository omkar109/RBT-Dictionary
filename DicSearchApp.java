import java.util.Scanner;

public class DicSearchApp {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        DicSearchBackendBD b=new DicSearchBackendBD(new WordReaderDW(),new RedBlackTreeAE<WordInterface>());
        DicSearchFrontendFD f=new DicSearchFrontendFD(sc,b);
        f.runCommandLoop();
    }
}
