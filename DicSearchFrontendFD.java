import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.*;

public class DicSearchFrontendFD implements DicSearchFrontendInterface{
    Scanner  userInput;
    DicSearchBackendInterface backend;
    public DicSearchFrontendFD(Scanner userInput,DicSearchBackendInterface backend)
    {
        this.userInput=userInput;
        this.backend=backend;
    }
    String wordPrompt="";
    public void runCommandLoop()
    {
char operation ='y';//calls for the next iteration
        String cc="";
        while(operation!='q')
        {
             operation=mainMenuPrompt();//get the operation character we want to operate
            System.out.println("Hi");


            switch(operation)
            {

                case 'a':
                    addWord();break;
                case 'f':
                    System.out.println("do you want to search the word previously defined by the word search prompt\n" +
                            "y:yes\n" +
                            "n:no");
                    cc=userInput.next();
                    if(cc.equals("y")){
                        searchDefinition(wordPrompt);
                    }
                    else{
                        searchDefinition("");}

                    cc="";
                    break;
                case 'r':
                    removeWord();break;
                case 'd':
                    addDefinition();break;
                case 'b':
                    addType();break;
                case 's':
                    displayStatsCommand();break;
                case 't':
                    System.out.println("do you want to search the word previously defined by the word search prompt\n" +
                            "y:yes\n" +
                            "n:no");
                    cc=userInput.next();
                    if(cc.equals("y")){
                        searchTypeSpeech(wordPrompt);
                    }
                    else{
                        searchTypeSpeech("");}

                    cc="";break;
                case 'w':
                    System.out.println("do you want to search the word previously defined by the word search prompt\n" +
                            "y:yes\n" +
                            "n:no");
                    cc=userInput.next();
                    if(cc.equals("y")){
                        searchWord(wordPrompt);
                    }
                    else{
                 searchWord("");}
                    cc="";break;
                case 'l':

                    loadDataCommand();break;
                case 'p':
                    wordPrompt=chooseWordPrompt();break;
                case 'q':
                    break;
                default:
                    System.out.println("you have entered the wrong choice");break;
            }
            //at last we get the choice again
//            System.out.println("please give the choice\n" +
//                    "y:continue program\n" +
//                    "q:exit the processing");
            //choice=userInput.next();
        }

    }

    @Override
    public char mainMenuPrompt() {
String option;
System.out.println("Enter your choice of operation");
        System.out.println("l:load data/many words from the file into dictionary");
        System.out.println("p:change the word prompt");
        System.out.println("w:search some word");
        System.out.println("t:search type of speech");
        System.out.println("f:Search definition");
        System.out.println("a:add some word");
        System.out.println("r:remove some word");
        System.out.println("d:add definition to some word");
        System.out.println("b:add type of speech to some word");
        System.out.println("s:display statistics");
        System.out.println("q:quit the program");
option=userInput.nextLine();
return Character.toLowerCase(option.charAt(0));

    }

    @Override
    public void loadDataCommand() {
        System.out.println("please give the filename");
        String filename=userInput.nextLine().trim();
        try{
            backend.loadData(filename);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("unable to open the file");
        }
    }

    @Override
    public String chooseWordPrompt() {
        String word="";
        while(true) {
            System.out.println("please enter the new word choice");
            word = userInput.nextLine();
            if (word != "") {
                break;
            }
        }
        return word;
    }

    @Override
    public void searchWord(String prompt) {


        String word="";
        if(prompt!=""){
            word=prompt;userInput.nextLine();}
        else {
            while (true) {
                System.out.println("please enter word to add");userInput.nextLine();
                word = userInput.nextLine();
                if (word != "") {
                    break;
                }
            }
        }
        try{
            List<String> definitions=backend.getDefinition(word);
            for(String def:definitions)
            {
                System.out.println(def);
            }
        }
        catch(NoSuchElementException e)
        {
            System.out.println("word doesn't exist in the dictionary");
        }
        try{
            List<String> types=backend.getTypeSpeech(word);
            for(String type:types)
            {
                System.out.println(type);
            }
        }
        catch(NoSuchElementException e)
        {
            System.out.println("word doesn't exist in the dictionary");
        }
    }

    @Override
    public void searchTypeSpeech(String prompt) {
        String word="";
        if(prompt!=""){
            word=prompt;userInput.nextLine();
        }
        else {
            while (true) {
                System.out.println("please enter word to add");userInput.nextLine();
                word = userInput.nextLine();
                if (word != "") {
                    break;
                }
            }
        }
        try{
            List<String> types=backend.getTypeSpeech(word);
            for(String type:types)
            {
                System.out.println(type);
            }
        }
        catch(NoSuchElementException e)
        {
            System.out.println("word doesn't exist in the dictionary");
        }
    }


    @Override
    public void addWord() {
        String word="";String definition="";String type="";
        while(true) {
            System.out.println("please enter word to add");
            word = userInput.nextLine();
            if (word != "") {
                break;
            }
        }
        while(true){
        System.out.println("please enter definition of word to add");
        definition=userInput.nextLine();
        if(definition!=""){
            break;
        }
        }
        while(true){
        System.out.println("please enter type of speech of word to add");
         type=userInput.nextLine();
        if(type!="") {
            break;
        }
        }
        backend.insert(word,definition,type);
    }





    @Override
    public void removeWord() {
        String word="";
        while(true) {
            System.out.println("please enter word to add");
            word = userInput.nextLine();
            if (word != "") {
                break;
            }
        }
        try{
            backend.remove(word);
        }
        catch(NoSuchElementException e)
        {
            System.out.println("word not found in the dictionary");
        }
    }



    @Override
    public void displayStatsCommand() {
        if(backend.getStatistics()!=""){
        System.out.println(backend.getStatistics());}
        else{
            System.out.println("no statistics to present");
        }
    }

    @Override
    public void addDefinition() {
        String word="";String definition;
        while(true) {
            System.out.println("please enter word to add");
            word = userInput.nextLine();
            if (word != "") {
                break;
            }
        }
        while(true){
            System.out.println("please enter definition of word to add");
            definition=userInput.nextLine();
            if(definition!=""){
                break;
            }
        }
        try{
            backend.addDefinition(word,definition);
        }
        catch(NoSuchElementException e)
        {
            System.out.println("word not found in the dictionary");
        }
    }

    @Override
    public void searchDefinition(String prompt) {
        String word="";
        if(prompt!="")
        {
            word=prompt;userInput.nextLine();
        }
        else {
            while (true) {
                System.out.println("please enter word to add");userInput.nextLine();
                word = userInput.nextLine();
                if (word != "") {
                    break;
                }
            }
        }
        try{
            List<String> definitions=backend.getDefinition(word);
            for(String def:definitions)
            {
                System.out.println(def);
            }
        }
        catch(NoSuchElementException e)
        {
            System.out.println("word doesn't exist in the dictionary");
        }
    }

    @Override
    public void addType() {
        String word="";String type;
        while(true) {
            System.out.println("please enter word to add");
            word = userInput.nextLine();
            if (word != "") {
                break;
            }
        }
        while(true){
            System.out.println("please enter type of speech of word to add");
            type=userInput.nextLine();
            if(type!=""){
                break;
            }
        }
        try{
            backend.addType(word,type);
        }
        catch(NoSuchElementException e)
        {
            System.out.println("word not found in the dictionary");
        }
    }


}
