// --== CS400 Spring 2023 File Header Information ==--
// Name: Omkar Kendale
// Email: kendale@wisc.edu
// Team: DK
// TA: Yuye Jiang
// Lecturer: Florain Heimerl
// Notes to Grader: My tests from last week don't run because in my Backendimplementation, I updated it to use
//                  the WordDW class from the data wrangler instead of my backend placeholder, so the code
//                  won't work 

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;

public class BackendDeveloperTests {

  /**
   * This method tests the loading of a csv file into the program and tests inserting new words and deleting new words.
   * This tests frontend, backend and datawrangler because the frontend must pass the right input to backend which must 
   * pass the right input to datawrangler  
   */
  @Test
  public void IntegrationTest1() {
    
    //This tests the load in of a new file and makes sure the file was properly loading by searching for a 
    //word in the tree that should've been loaded in the file
    try {
      //This loads a file, gives the name of the file, searches for a word, says no to search by previously
      //defined word, then enters word to search for
    TextUITester t = new TextUITester("l\nfile2\nw\nno\nball\nq\n");
  //Sets up all the objects we need
    Scanner sc=new Scanner(System.in);
    DicSearchBackendBD backend = new DicSearchBackendBD(new WordReaderDW(), new RedBlackTreeAE());
    DicSearchFrontendFD frontend = new DicSearchFrontendFD(sc, backend);
    frontend.runCommandLoop();
    //Gets the output printed to the console
    String output = t.checkOutput();
    //Ensures that the definition of the word we searched for is in redblacktree and outputted
    Assertions.assertTrue(output.contains("A dance or dancing."));
    //Ensures that the type of the word we searched for is in redblacktree and outputted
    Assertions.assertTrue(output.contains("noun"));
    }
    catch(Exception e1) {
      //Fails the method if any exception is thrown
      Assertions.fail();
    }
    
    //This tests inserting of new words 
    try {
      //This adds a word to the redblacktree, gives the word, gives the definition, gives the type, searches for word
      //says no to searching by previously defined word, then gives word to search for
      TextUITester t = new TextUITester("a\nword\ndefinition\ntype\nw\nno\nword\nq\n");
    //Sets up all the objects we need
      Scanner sc=new Scanner(System.in);
      DicSearchBackendBD backend = new DicSearchBackendBD(new WordReaderDW(), new RedBlackTreeAE());
      DicSearchFrontendFD frontend = new DicSearchFrontendFD(sc, backend);
      frontend.runCommandLoop();
      //Gets the output printed to the console
      String output = t.checkOutput();
      //Ensures that the definition you inserted was outputted
      Assertions.assertEquals(output.contains("definition"), true);
      //Ensures that the type you inserted was outputted
      Assertions.assertEquals(output.contains("type"), true);
      
      }
      catch(Exception e1) {
        //Fails the method if any exception is thrown
        Assertions.fail();
      }
    
    //This tests the deletion of words
    try {
      //This adds a word to the rbt, gives the definition, gives types, then removes word and inputs the word to remove
      TextUITester t = new TextUITester("a\nword\ndefinition\ntype\nr\nword\nq\n");
    //Sets up all the objects we need
      Scanner sc=new Scanner(System.in);
      DicSearchBackendBD backend = new DicSearchBackendBD(new WordReaderDW(), new RedBlackTreeAE());
      DicSearchFrontendFD frontend = new DicSearchFrontendFD(sc, backend);
      frontend.runCommandLoop();
    //Gets the output printed to the console
      String output = t.checkOutput();
      //Checks that the user was prompted to remove something
      Assertions.assertEquals(output.contains("please enter word to remove"), true);
      
      //As long as no exception is called from these inputs, the remove is successful
    }
    catch(Exception e1) {
      //Fails the method if any exception is thrown
      Assertions.fail();
    }
  }
  
  /**
   * This method tests the loading of a csv file into the program and tests adding/getting of definitions and
   * types and printing out statistics
   */
  @Test
  public void IntegrationTest2() {
    //Checks that add definition and get definition works
    try {
      //This adds a word to the rbt, gives its definition, gives its type, searches for a definition, 
      //says no to searching by previously defined word, gives the word we want the definition for
      TextUITester t = new TextUITester("a\nword\ndefinition\ntype\nf\nno\nword\nq\n");
    //Sets up all the objects we need
      Scanner sc=new Scanner(System.in);
      DicSearchBackendBD backend = new DicSearchBackendBD(new WordReaderDW(), new RedBlackTreeAE());
      DicSearchFrontendFD frontend = new DicSearchFrontendFD(sc, backend);
      frontend.runCommandLoop();
    //Gets the output printed to the console
      String output = t.checkOutput();
      //Make sure that the definition was outputted
      Assertions.assertEquals(output.contains("definition"), true);
    }
    catch(Exception e1) {
    //Fails the method if any exception is thrown
      Assertions.fail();
    }
    
  //Checks that add definition and get definition works
    try {
      //This adds a word to the rbt, gives its definition, gives its type, searches for a type, 
      //says no to searching by previously defined word, gives the word we want the type for
      TextUITester t = new TextUITester("a\nword\ndefinition\ntype\nt\nno\nword\nq\n");
    //Sets up all the objects we need
      Scanner sc=new Scanner(System.in);
      DicSearchBackendBD backend = new DicSearchBackendBD(new WordReaderDW(), new RedBlackTreeAE());
      DicSearchFrontendFD frontend = new DicSearchFrontendFD(sc, backend);
      frontend.runCommandLoop();
    //Gets the output printed to the console
      String output = t.checkOutput();
      //Make sure that the definition was outputted
      Assertions.assertEquals(output.contains("type"), true);
    }
    catch(Exception e1) {
    //Fails the method if any exception is thrown
      Assertions.fail();
    }
    
  //Checks that the getStatistics method works
    try {
      //This loads a file then this adds a word to the rbt (with its definition and type), then searches for a type, 
      //then searches for a definition, then adds a type
      TextUITester t = new TextUITester("a\nword\ndefinition\ntype\nt\nno\nword\nf\nno\nword\nb\nno\nwordq\n");
    //Sets up all the objects we need
      Scanner sc=new Scanner(System.in);
      DicSearchBackendBD backend = new DicSearchBackendBD(new WordReaderDW(), new RedBlackTreeAE());
      DicSearchFrontendFD frontend = new DicSearchFrontendFD(sc, backend);
      frontend.runCommandLoop();
    //Gets the output printed to the console
      String output = t.checkOutput();
      //Make sure that the statistics was outputted correctly
      Assertions.assertEquals(output.contains("You inserted a word 1 times! \n" +
          "You added a definition 0 times! \n" +
          "You added a type of speech 1 times! \n" +
          "You searched for a defintion 1 times! \n" +
          "You searched for the type of speech for a word 1 times! \n" +
          "You removed a word from the dictionary 0 times! \n"),
          true);
    }
    catch(Exception e1) {
    //Fails the method if any exception is thrown
      Assertions.fail();
    }
    
  }
  
  /**
   * This method will check specifically that frontend is outputting the right things when loading a file, 
   * adding a word, adding a definition, adding a type, displaying statistics
   */
  @Test
  public void CodeReviewOfFrontendDeveloper1() {
    //Tests the right output for loading a file
    try {
      //Loads a file, then gives filename
    TextUITester t = new TextUITester("l\nfile1\nq\n");
  //Sets up all the objects we need
    Scanner sc=new Scanner(System.in);
    DicSearchBackendBD backend = new DicSearchBackendBD(new WordReaderDW(), new RedBlackTreeAE());
    DicSearchFrontendFD frontend = new DicSearchFrontendFD(sc, backend);
    frontend.runCommandLoop();
    //Gets the output printed to the console
    String output = t.checkOutput();
    Assertions.assertEquals(output.contains("please give the filename"), true);
    
    }
    catch(Exception e1) {
    //Fails the method if any exception is thrown
      Assertions.fail();
    }
    
    //Tests the right output for adding a word
    try {
      //This inserts a word, gives the word, gives the definition, gives the type
      TextUITester t = new TextUITester("a\nword\ndefinition\ntype\nq\n");
    //Sets up all the objects we need
      Scanner sc=new Scanner(System.in);
      DicSearchBackendBD backend = new DicSearchBackendBD(new WordReaderDW(), new RedBlackTreeAE());
      DicSearchFrontendFD frontend = new DicSearchFrontendFD(sc, backend);
      frontend.runCommandLoop();
      //Gets the output printed to the console
      String output = t.checkOutput();
      
      Assertions.assertEquals(output.contains("please enter word to add"), true);
      Assertions.assertEquals(output.contains("please enter definition of word to add"), true);
      Assertions.assertEquals(output.contains("please enter type of speech of word to add"), true);
      
      }
      catch(Exception e1) {
      //Fails the method if any exception is thrown
        Assertions.fail();
      }
    
  //Tests the right output for adding a definition
    try {
      //This inserts a word, gives the word, gives the definition, gives the type, then adds another definition to that word
      TextUITester t = new TextUITester("a\nword\ndefinition\ntype\nd\nword\ndefinition2\nq\n");
    //Sets up all the objects we need
      Scanner sc=new Scanner(System.in);
      DicSearchBackendBD backend = new DicSearchBackendBD(new WordReaderDW(), new RedBlackTreeAE());
      DicSearchFrontendFD frontend = new DicSearchFrontendFD(sc, backend);
      frontend.runCommandLoop();
      //Gets the output printed to the console
      String output = t.checkOutput();
      Assertions.assertEquals(output.contains("please enter word to add"), true);
      Assertions.assertEquals(output.contains("please enter definition of word to add"), true);
      
      }
      catch(Exception e1) {
      //Fails the method if any exception is thrown
        Assertions.fail();
      }
    
    //Tests the right output for adding a type
    try {
      //This inserts a word, gives the word, gives the definition, gives the type, then adds another type to that word
      TextUITester t = new TextUITester("a\nword\ndefinition\ntype\nb\nword\ntype2\nq\n");
    //Sets up all the objects we need
      Scanner sc=new Scanner(System.in);
      DicSearchBackendBD backend = new DicSearchBackendBD(new WordReaderDW(), new RedBlackTreeAE());
      DicSearchFrontendFD frontend = new DicSearchFrontendFD(sc, backend);
      frontend.runCommandLoop();
      //Gets the output printed to the console
      String output = t.checkOutput();
      Assertions.assertEquals(output.contains("please enter word to add"), true);
      Assertions.assertEquals(output.contains("please enter type of speech of word to add"), true);
      }
      catch(Exception e1) {
      //Fails the method if any exception is thrown
        Assertions.fail();
      }
    
  //Tests the right output for displaying statistics
    try {
      //This asks for statistics
      TextUITester t = new TextUITester("s\nq\n");
    //Sets up all the objects we need
      Scanner sc=new Scanner(System.in);
      DicSearchBackendBD backend = new DicSearchBackendBD(new WordReaderDW(), new RedBlackTreeAE());
      DicSearchFrontendFD frontend = new DicSearchFrontendFD(sc, backend);
      frontend.runCommandLoop();
      //Gets the output printed to the console
      String output = t.checkOutput();
      //Ensure the start of the statistics are printed
      Assertions.assertEquals(output.contains("You inserted a word 0 times!"), true);
      //Ensure the end of the statistics are printed
      Assertions.assertEquals(output.contains("You removed a word from the dictionary 0 times!"), true);
      }
      catch(Exception e1) {
      //Fails the method if any exception is thrown
        Assertions.fail();
      }
    
    
  }
  
  /**
   * This tests that searching for a word, searching for a definition and searching for a type output the right things
   */
  @Test
  public void CodeReviewOfFrontendDeveloper2() {
    //Tests the right output for searching for a word
    try {
      //This inserts a word, then searches for that word, and says no to searching for the previously defined word
      TextUITester t = new TextUITester("a\nword\ndefinition\ntype\nw\nno\nword\nq\n");
      //Sets up all the objects we need
      Scanner sc=new Scanner(System.in);
      DicSearchBackendBD backend = new DicSearchBackendBD(new WordReaderDW(), new RedBlackTreeAE());
      DicSearchFrontendFD frontend = new DicSearchFrontendFD(sc, backend);
      frontend.runCommandLoop();
      //Gets the output printed to the console
      String output = t.checkOutput();
      //Ensure the right output was printed out
      Assertions.assertEquals(output.contains("do you want to search the word previously defined by the word search"
          + " prompt"), true);
    }
      catch(Exception e1) {
      //Fails the method if any exception is thrown
        Assertions.fail();
      }
    
  //Tests the right output for searching for a word
    try {
      //This inserts a word, then searches for the definition, and says no to searching for the previously defined word
      TextUITester t = new TextUITester("a\nword\ndefinition\ntype\nf\nno\nword\nq\n");
      Scanner sc=new Scanner(System.in);
      DicSearchBackendBD backend = new DicSearchBackendBD(new WordReaderDW(), new RedBlackTreeAE());
      DicSearchFrontendFD frontend = new DicSearchFrontendFD(sc, backend);
      frontend.runCommandLoop();
      String output = t.checkOutput();
      //Ensure the right output was printed out
      Assertions.assertEquals(output.contains("do you want to search the word previously defined by the word search"
          + " prompt"), true);
    }
      catch(Exception e1) {
      //Fails the method if any exception is thrown
        Assertions.fail();
      }
    
  //Tests the right output for searching for a word
    try {
      //This inserts a word, then searches for the definition, and says no to searching for the previously defined word
      TextUITester t = new TextUITester("a\nword\ndefinition\ntype\nt\nno\nword\nq\n");
      Scanner sc=new Scanner(System.in);
      DicSearchBackendBD backend = new DicSearchBackendBD(new WordReaderDW(), new RedBlackTreeAE());
      DicSearchFrontendFD frontend = new DicSearchFrontendFD(sc, backend);
      frontend.runCommandLoop();
      String output = t.checkOutput();
      //Ensure the right output was printed out
      Assertions.assertEquals(output.contains("do you want to search the word previously defined by the word search"
          + " prompt"), true);
    }
      catch(Exception e1) {
      //Fails the method if any exception is thrown
        Assertions.fail();
      }
  }
  
  /**
   * This tester tests the insert method
   */
  @Test 
  public void Test1() {
    RedBlackTreeInterface<WordInterface> rbt = new RedBlackTreeBD();
    DicSearchBackendBD tester = new DicSearchBackendBD(new WordReaderBD(), rbt);
    //This checks that the backend method insert successfully passes the word to AE
    Assertions.assertEquals(tester.insert("chair", "object you sit on", "noun"), true);
    //This checks that the AE method gets the right word from backend
    ArrayList<String> definitions = new ArrayList<String>();
    definitions.add("object you sit on");
    ArrayList<String> types = new ArrayList<String>();
    types.add("object you sit on");
    Assertions.assertEquals(rbt.insert(new WordBD("chair", types, definitions)), 
        "You inserted the word: chair with definition [object you sit on] with type [noun]");
  }
  
  /**
   * This tester tests the getDefinition method
   */
  @Test 
  public void Test2() {

    RedBlackTreeInterface<WordInterface> rbt = new RedBlackTreeBD();
    DicSearchBackendBD tester = new DicSearchBackendBD(new WordReaderBD(), rbt);
    tester.insert("banana", "yellow fruit", "noun");
    tester.insert("orange", "orange fruit", "noun");
    tester.insert("apple", "red fruit", "noun");
    ArrayList<String> definitions = new ArrayList<String>();
    definitions.add("yellow fruit");
    ArrayList<String> types = new ArrayList<String>();
    types.add("noun");
    Assertions.assertEquals(tester.getDefinition("banana"), rbt.get(new WordBD("banana", types, definitions)).getDescription());
    definitions = new ArrayList<String>();
    definitions.add("orange fruit");
    types = new ArrayList<String>();
    types.add("noun");
    Assertions.assertEquals(tester.getDefinition("orange"), rbt.get(new WordBD("orange", types, definitions)).getDescription());
    definitions = new ArrayList<String>();
    definitions.add("yellow fruit");
    types = new ArrayList<String>();
    types.add("noun");
    Assertions.assertEquals(tester.getDefinition("apple"), rbt.get(new WordBD("apple", types, definitions)).getDescription());
  }
  
  /**
   * This tester tests the getType method
   */
  @Test 
  public void Test3() {
    RedBlackTreeInterface<WordInterface> rbt = new RedBlackTreeBD();
    DicSearchBackendBD tester = new DicSearchBackendBD(new WordReaderBD(), rbt);
    tester.insert("lightbulb", "emits light", "noun");
    tester.insert("sleep", "lay down", "verb");
    tester.insert("happy", "joyous", "adjective");
    ArrayList<String> definitions = new ArrayList<String>();
    definitions.add("emits light");
    ArrayList<String> types = new ArrayList<String>();
    types.add("noun");
    Assertions.assertEquals(tester.getTypeSpeech("lightbulb"), rbt.get(new WordBD("lightbulb", types, definitions)).getType());
    definitions = new ArrayList<String>();
    definitions.add("lay down");
    types = new ArrayList<String>();
    types.add("verb");
    Assertions.assertEquals(tester.getTypeSpeech("sleep"), rbt.get(new WordBD("sleep", types, definitions)).getType());
    definitions = new ArrayList<String>();
    definitions.add("joyous");
    types = new ArrayList<String>();
    types.add("adjective");
    Assertions.assertEquals(tester.getTypeSpeech("happy"), rbt.get(new WordBD("happy", types, definitions)).getType());
  }
  
  /**
   * This tester tests addDefinition and addType methods
   */
  @Test 
  public void Test4() {
    RedBlackTreeInterface<WordInterface> rbt = new RedBlackTreeBD();
    DicSearchBackendBD tester = new DicSearchBackendBD(new WordReaderBD(), rbt);
    tester.insert("rose", "type of flower", "noun");
    tester.insert("bark", "tree bark", "noun");
    tester.addDefinition("rose", "To arise");
    tester.addDefinition("bark", "dog bark");
    ArrayList<String> definitions = new ArrayList<String>();
    definitions.add("type of flower");
    ArrayList<String> types = new ArrayList<String>();
    types.add("noun");
    Assertions.assertEquals(tester.getDefinition("rose"), rbt.get(new WordBD("rose", types, definitions)).getDescription());
    definitions = new ArrayList<String>();
    definitions.add("tree bark");
    types = new ArrayList<String>();
    types.add("noun");
    Assertions.assertEquals(tester.getDefinition("bark"), rbt.get(new WordBD("bark", types, definitions)).getDescription());
    tester.insert("White House", "presidents house", "noun");
    tester.insert("climb", "go up something", "verb");
    tester.addType("White House", "pronoun");
    tester.addType("climb", "noun");
    definitions = new ArrayList<String>();
    definitions.add("presidents house");
    types = new ArrayList<String>();
    types.add("noun");
    Assertions.assertEquals(tester.getTypeSpeech("White House"), rbt.get(new WordBD("White House", types, definitions)).getType());
    definitions = new ArrayList<String>();
    definitions.add("climb");
    types = new ArrayList<String>();
    types.add("go up something");
    Assertions.assertEquals(tester.getTypeSpeech("climb"), rbt.get(new WordBD("climb", types, definitions)).getType());
  }
  
  /**
   * This tester tests the getStatistics method
   */
  @Test 
  public void Test5() {
    DicSearchBackendBD tester = new DicSearchBackendBD(new WordReaderBD(), new RedBlackTreeBD());
    tester.insert("code", "to program", "verb");
    tester.insert("eat", "consume food", "verb");
    tester.addDefinition("code", "secret cryptics");
    tester.addType("eat", "noun");
    tester.getDefinition("eat");
    tester.getTypeSpeech("code");
    tester.remove("eat");
    Assertions.assertEquals(tester.getStatistics(), "You inserted a word 2 times! \n" +
           "You added a definition 1 times! \n" +
           "You added a type of speech 1 times! \n" +
           "You searched for a defintion 1 times! \n" +
           "You searched for the type of speech for a word 1 times! \n" +
           "You removed a word from the dictionary 1 times! \n");
    tester.getDefinition("code");
    tester.remove("code");
    Assertions.assertEquals(tester.getStatistics(), "You inserted a word 2 times! \n" +
        "You added a definition 1 times! \n" +
        "You added a type of speech 1 times! \n" +
        "You searched for a defintion 2 times! \n" +
        "You searched for the type of speech for a word 1 times! \n" +
        "You removed a word from the dictionary 2 times! \n");
  }
  

}
