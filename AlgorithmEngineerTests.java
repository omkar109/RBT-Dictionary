import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
//import org.junit.Test;
//import static org.junit.Assert.assertEquals;
import java.util.LinkedList;
import java.util.Stack;

public class AlgorithmEngineerTests {

    @Test
    public void Test1(){
        RedBlackTreeAE<Integer> rbt = new RedBlackTreeAE<Integer>();

        rbt.insert(10);
        rbt.insert(14);
        rbt.insert(5);
        rbt.insert(8);


        rbt.removeNode(14);


        assertEquals("[ 8, 5, 10 ]", rbt.toLevelOrderString());

    }
    @Test
    public void Test2(){
        RedBlackTreeAE<Integer> rbt = new RedBlackTreeAE<Integer>();

        rbt.insert(10);
        rbt.insert(5);
        rbt.insert(14);
        rbt.insert(2);
        rbt.insert(9);
        //rbt.insert(2);

        rbt.root.context[1].blackHeight = 0;
        rbt.root.context[1].context[1].blackHeight = 1;
        rbt.root.context[1].context[2].blackHeight = 1;


        rbt.removeNode(5);

        assertEquals(rbt.toLevelOrderString(), "[ 10, 9, 14, 2 ]");

    }
    @Test
    public void Test3(){

        RedBlackTreeAE<Integer> rbt = new RedBlackTreeAE<Integer>();

        rbt.insert(10);
        rbt.insert(5);
        rbt.insert(14);
        rbt.insert(2);
        rbt.insert(9);


        rbt.remove(5);

        assertEquals(rbt.toLevelOrderString(), "[ 10, 9, 14, 2 ]");

    }
    @Test
    public void Test4(){

        RedBlackTreeAE<Integer> rbt = new RedBlackTreeAE<Integer>();

        rbt.insert(10);
        rbt.insert(5);
        rbt.insert(14);



        assertEquals(rbt.get(13), null);

    }
    @Test
    public void Test5(){
        RedBlackTreeAE<Integer> rbt = new RedBlackTreeAE<Integer>();

        rbt.insert(10);
        rbt.insert(5);
        rbt.insert(14);



        assertEquals(rbt.get(5), 5);

        //Testing the get method

    }



}

