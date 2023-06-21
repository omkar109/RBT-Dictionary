import  org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.w3c.dom.Text;

public class FrontendDeveloperTests {
    DicSearchBackendFD backend;DicSearchFrontendFD frontend;
    DicSearchBackendBD backend2;
    @BeforeEach
            public void setup() {
        backend= new DicSearchBackendFD(new WordReaderFD(), new RedBlackTreeFD());

            //TextUITester t;
    }
    @BeforeEach
    public void setupForIntegration() {
        backend2 = new DicSearchBackendBD((WordReaderInterface) new WordReaderDW(), new RedBlackTreeAE());//making objects of other classes of integration
    }
    /***
     * this method is used to test the constructor of the frontend class
     */

    @Test
    public void test1(){
        DicSearchBackendFD backend = new DicSearchBackendFD(new WordReaderFD(), new RedBlackTreeFD());
        DicSearchFrontendFD frontend = new DicSearchFrontendFD(new Scanner(System.in), backend);
        assertNotEquals(null,frontend);
        assertNotEquals(null,frontend.backend);
        assertNotEquals(null,frontend.userInput);
    }

    /**
     * this test checks the implementation of loaddata method
     */

    @Test
    public void test2()
    {



        //backend = new DicSearchBackendFD(new WordReaderFD(), new RedBlackTreeFD());

        TextUITester t=new TextUITester("l\nssdnjdne.csv\nq\n");
        Scanner sc=new Scanner(System.in);
        frontend= new DicSearchFrontendFD(sc, backend);
         //frontend = new DicSearchFrontendFD(new Scanner(System.in), backend);
        frontend.runCommandLoop();
String output=t.checkOutput();
        System.out.println(output);
        assertTrue(output.contains("unable to open the file"));
//assertEquals("unable to open the file",output);

    }

    /**
     * this method tests the implementation of adding and removing a word
     */
    @Test
    public void test3(){
        {
            int prev_size = backend.rbt.size;
            System.out.println(prev_size);
            TextUITester t = new TextUITester("l\nssdnjdne.csv\na\nword\ndef\ntype\nq\n");
            Scanner sc = new Scanner(System.in);
            frontend = new DicSearchFrontendFD(sc, backend);
            //frontend = new DicSearchFrontendFD(new Scanner(System.in), backend);
            frontend.runCommandLoop();
            String output = t.checkOutput();
            int cur_size = backend.rbt.size;
            System.out.println(output);
            System.out.println(cur_size);
            assertEquals(prev_size + 1, cur_size);
        }
        {
            int prev_size = backend.rbt.size;
            TextUITester   t = new TextUITester("l\nj.csv\na\nword\ndef\ntype\nr\nword\na\nword\ndef\ntype\nq\n")
                    ;Scanner sc = new Scanner(System.in);
            frontend = new DicSearchFrontendFD(sc, backend);
            //frontend = new DicSearchFrontendFD(new Scanner(System.in), backend);
            frontend.runCommandLoop();
            String output = t.checkOutput();
            int cur_size = backend.rbt.size;
            System.out.println(output);
            System.out.println(cur_size);
            System.out.println(prev_size);
            assertEquals(prev_size + 1, cur_size);
        }
    }

    /**
     * this method is used for testing searching of word with both its attributes
     */
    @Test
    public void Test4()
    {
        TextUITester   t = new TextUITester("l\nj.csv\na\nword\ndef\ntype\na\nword\ndef\ntype\nw\nword\nt\nword\nf\nword\nq\n");
        Scanner sc = new Scanner(System.in);
        frontend = new DicSearchFrontendFD(sc, backend);
        //frontend = new DicSearchFrontendFD(new Scanner(System.in), backend);
        frontend.runCommandLoop();
        String output = t.checkOutput();
        int cur_size = backend.rbt.size;
        System.out.println(output);
        assertTrue(output.contains("love"));
        assertTrue(output.contains("beautiful"));
    }

    /**
     * this test tests the functioning of getstatistics and changing of word prompt
     */
    @Test
    public void Test5()
{

    TextUITester   t = new TextUITester("l\nj.csv\na\nword\ndef\ntype\ns\np\nword34343434\np\nhello\nq\n");
    Scanner sc = new Scanner(System.in);
    frontend = new DicSearchFrontendFD(sc, backend);
    //frontend = new DicSearchFrontendFD(new Scanner(System.in), backend);
    frontend.runCommandLoop();
    String output = t.checkOutput();
    int cur_size = backend.rbt.size;
    System.out.println(output);
    System.out.println(frontend.wordPrompt);
assertTrue(output.contains("hi this is the hardcoded statistics"));
   assertEquals("hello",frontend.wordPrompt);
}
/**
 this test checks the working of add definition and add type methods
 */
@Test
    public void Test6(){
        TextUITester   t = new TextUITester("l\nj.csv\na\nword\ndef\ntype\ns\nb\nword\ntype\nd\nword\ndef\nq\n");
        Scanner sc = new Scanner(System.in);
        frontend = new DicSearchFrontendFD(sc, backend);
        //frontend = new DicSearchFrontendFD(new Scanner(System.in), backend);
        frontend.runCommandLoop();
        String output = t.checkOutput();
        int cur_size = backend.rbt.size;
        System.out.println(output);
        assertTrue(output.contains("hardcoded accepted message"));
        assertTrue(output.contains("hardcoded accepted message2"));
    }

    /**
     * this test tests the addition of words to the dictionary and adding an extra word with one definition
     * method is called on the object class created by the other roles to check their code and the junit tester is used to test the functionality
     * then we print the statistics and then add another type to the word we just added
     * THEN WE TRY TO PRINT THE WORDS AND THEIR CHARACTERISTICS by purposedly giving capitalized word as the key
     */
    @Test
    public void test7Integration()
    {
        try {
            TextUITester t = new TextUITester("l\nfile2.csv\na\nenthusiastic\na lot of excitement and interest\nadjective\ns\nb\nenthusiastic\nadverb\nw\nn\nBALL\nw\nENTHUSIASTIC\nq\n");


            Scanner sc = new Scanner(System.in);
            frontend = new DicSearchFrontendFD(sc, backend2);
            frontend.runCommandLoop();
            String output = t.checkOutput();
            //file2 has 4 words and so we expect the size to be 5 now
            assertEquals(5, ((RedBlackTreeFD)(backend2.rbt)).size);
            assertTrue(output.contains("A dance or dancing"));
            assertTrue(output.contains("a lot of excitement and interest"));
            assertTrue(output.contains("enthusiastic"));assertTrue(output.contains("ball"));

            assertTrue(output.contains("noun"));assertTrue(output.contains("adjective"));assertTrue(output.contains("adverb"));
        }
     catch(Exception e)
        {
            assertTrue(false);//always gives error
        }
    }

    /**
     * this method doesn't use a file to instantiate the dictionary from before and gets the definition of words added and prints the stats
     */
    @Test
    public void test8Integration()
    {
        try{
           TextUITester t=new TextUITester("a\ntool\na device or implement, especially one held in the hand, " +
                   "used to carry out a particular function\nnoun\na\ncapacity\nthe " +
                   "maximum amount that something can contain\nnoun\nf\nn\ntool\ns\nq\n");
           String output=t.checkOutput();
            assertTrue(output.contains("device or implement, especially one held "));
            assertTrue(!output.contains("tool"));

            assertTrue(!output.contains("capacity"));
            assertTrue(!output.contains("maximum amount that something can contain"));
            assertEquals(2,((RedBlackTreeFD)(backend2.rbt)).size);
            //checking stats lines
            assertTrue(output.contains("You inserted a word 2 times!"));
            assertTrue(output.contains("You added a definition " + "0" +" times!" ));
            assertTrue(output.contains("You added a type of speech " + "0" +" times!" ));
            assertTrue(output.contains(  "You searched for a definition " + "1" + " times!" ));
            assertTrue(output.contains(   "You searched for the type of speech for a word " + "0" + " times!" ));
            assertTrue(output.contains("You removed a word from the dictionary " + "0"+" times!"));

        }
        catch(Exception e)
        {
            assertTrue(false);
        }
    }

    /***
     * this test first loads words from a new file and then adds some words and adds some types to only one word. Then
     * it gets list if types of that one word and then adds another  definitions to some another word and checks if they both were added
     *at that word and then removes one word and lastly checks if word was removed or not
     */
    @Test
    public void test9Integration()
    {
       TextUITester t=new TextUITester("l\nfile3.csv\na\nswag\ngoods acquired by unlawful means\nnoun\na\n" +
               "promotion\n the act or fact of being raised in position or rank\nnoun\nb\nswag\nverb\nb\nswag" +
               "\nadjective\nt\nn\nswag\nd\npromotion\nthe act of furthering the growth or development of something\n" +
               "f\nn\npromotion\nr\nswag\nq\n");
        String output=t.checkOutput();
       assertTrue(output.contains("verb")); assertTrue(output.contains("adjective")); assertTrue(output.contains("noun"));
       assertTrue(output.contains("the act of furthering the growth or development of something"));
       assertTrue(output.contains("the act or fact of being raised in position or rank"));
       assertEquals(2-1+5,((RedBlackTreeFD)(backend2.rbt)).size);
    }

    /**
     * this method tests the functions of statistics method on the working of adding 2 files' contents,removing and
     * adding alternately,and then adding type and definitions to single word many times and changing word prompt before searching word
     */
    @Test
    public void test10Integration()
    {
        TextUITester t=new TextUITester("l\nfile5.csv\na\nswag\ngoods acquired by unlawful means\nnoun\ns\np\nswag\nw\ny\n" +
                "r\nflight\nf\ny\nt\ny\nr\nswag\nw\ny\ns\nq\n");
        //we will get error exception when we try to find the word after deleting and by searching it through prompt word
    }

    /**
     * this test checks the working of exception handling and the maintainance/passing through of exceptions b/w frontend
     * and the backend
     */
    @Test
    public void test1CodeReviewofBackendDeveloper()
    {

    }

    /**
     * this method tests the working of constructor and statistics method and status of global variables of backend class
     * and also the add and remove method implicitly
     */
    @Test
    public void test2CodeReviewofBackendDeveloper()
    {

    }
}
