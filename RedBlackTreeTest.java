import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RedBlackTreeTest {

  @Test
  public void testColorSwapScenarios() {
    /*Tests following scenario:
     *  (Before fix)           15(black)                (After fix)      10(black)
     *                          /     \                                     /   \
     *                     10(red)   20(black)  -->                    5(red)  15(red)
     *                       /                                                    \
     *                    5(red)                                                  20(black)
     */
    RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
    tree.insert(new Integer(15));
    tree.insert(new Integer(20));
    tree.insert(new Integer(10));
    tree.findNodeWithData(new Integer(20)).blackHeight = 1;
    tree.insert(new Integer(5));

    Assertions.assertEquals(tree.findNodeWithData(new Integer(10)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(5)).blackHeight, 0);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(15)).blackHeight, 0);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(20)).blackHeight, 1);
    Assertions.assertEquals(tree.toLevelOrderString(), "[ 10, 5, 15, 20 ]");
    
    
    /*Tests following scenario:
     *  (Before fix)           15(black)                (After fix)      20(black)
     *                          /     \                                     /   \
     *                     10(black)   20(red)  -->                    15(red)  25(red)
     *                                   \                               /         \
     *                                  25(red)                    10(black)
     */
    tree = new RedBlackTree<Integer>();
    tree.insert(new Integer(15));
    tree.insert(new Integer(20));
    tree.insert(new Integer(10));
    tree.findNodeWithData(new Integer(10)).blackHeight = 1;
    tree.insert(new Integer(25));

    Assertions.assertEquals(tree.findNodeWithData(new Integer(20)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(25)).blackHeight, 0);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(15)).blackHeight, 0);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(10)).blackHeight, 1);
    Assertions.assertEquals(tree.toLevelOrderString(), "[ 20, 15, 25, 10 ]");
    
    
    /*Tests following scenario:
     *  (Before fix)           15(black)                (After fix)      12(black)
     *                          /     \                                     /   \
     *                     10(red)   20(black)  -->                    10(red)  15(red)
     *                         \         \                               /         \
     *                       12(red)                                              20(black)
     */
    tree = new RedBlackTree<Integer>();
    tree.insert(new Integer(15));
    tree.insert(new Integer(10));
    tree.insert(new Integer(20));
    tree.findNodeWithData(new Integer(20)).blackHeight = 1;
    tree.insert(new Integer(12));

    Assertions.assertEquals(tree.findNodeWithData(new Integer(12)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(10)).blackHeight, 0);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(15)).blackHeight, 0);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(20)).blackHeight, 1);
    Assertions.assertEquals(tree.toLevelOrderString(), "[ 12, 10, 15, 20 ]");
    
    
    /*Tests following scenario:
     *  (Before fix)           15(black)                (After fix)      17(black)
     *                          /     \                                     /   \
     *                     10(black)   20(red)  -->                    15(red)  20(red)
     *                                   /                               /         \
     *                              17(red)                         10(black)              
     */
    tree = new RedBlackTree<Integer>();
    tree.insert(new Integer(15));
    tree.insert(new Integer(10));
    tree.insert(new Integer(20));
    tree.findNodeWithData(new Integer(10)).blackHeight = 1;
    tree.insert(new Integer(17));

    Assertions.assertEquals(tree.findNodeWithData(new Integer(17)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(15)).blackHeight, 0);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(20)).blackHeight, 0);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(10)).blackHeight, 1);
    Assertions.assertEquals(tree.toLevelOrderString(), "[ 17, 15, 20, 10 ]");
  }
  
  @Test
  public void testRecolorScenarios() {
    /*Tests following scenario:
     *  (Before fix)           15(black)                (After fix)      15(black)
     *                          /     \                                     /   \
     *                     10(red)   23(red)  -->                    10(black)  23(black)
     *                        /          /                               /         \
     *                    6(red)                                     6(red)              
     */
    RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
    tree.insert(new Integer(15)); 
    tree.insert(new Integer(10)); 
    tree.insert(new Integer(23));
    tree.insert(new Integer(6));  
    
    Assertions.assertEquals(tree.findNodeWithData(new Integer(15)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(23)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(10)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(6)).blackHeight, 0);
    Assertions.assertEquals(tree.toLevelOrderString(), "[ 15, 10, 23, 6 ]");
    
    
    /*Tests following scenario:
     *  (Before fix)           15(black)                (After fix)      15(black)
     *                          /     \                                     /   \
     *                     10(red)   23(red)  -->                    10(black)  23(black)
     *                        /          \                               /         \
     *                                  28(red)                                  28(red)              
     */
    tree = new RedBlackTree<Integer>();
    tree.insert(new Integer(15));
    tree.insert(new Integer(10)); 
    tree.insert(new Integer(23)); 
    tree.insert(new Integer(28));  
    
    Assertions.assertEquals(tree.findNodeWithData(new Integer(15)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(23)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(10)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(28)).blackHeight, 0);
    Assertions.assertEquals(tree.toLevelOrderString(), "[ 15, 10, 23, 28 ]");
    
    
    /*Tests following scenario:
     *  (Before fix)           15(black)                (After fix)      15(black)
     *                          /     \                                     /   \
     *                     10(red)   23(red)  -->                    10(black)  23(black)
     *                         \          \                               \        \
     *                        12(red)                                     12(red)              
     */
    tree = new RedBlackTree<Integer>();
    tree.insert(new Integer(15));
    tree.insert(new Integer(10)); 
    tree.insert(new Integer(23)); 
    tree.insert(new Integer(12));  
    
    Assertions.assertEquals(tree.findNodeWithData(new Integer(15)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(23)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(10)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(12)).blackHeight, 0);
    Assertions.assertEquals(tree.toLevelOrderString(), "[ 15, 10, 23, 12 ]");
    
    
    /*Tests following scenario:
     *  (Before fix)           15(black)                (After fix)      15(black)
     *                          /     \                                     /   \
     *                     10(red)   23(red)  -->                    10(black)  23(black)
     *                                  /                               \        /
     *                              18(red)                                    18(red)              
     */
    tree = new RedBlackTree<Integer>();
    tree.insert(new Integer(15));
    tree.insert(new Integer(10)); 
    tree.insert(new Integer(23)); 
    tree.insert(new Integer(18));  
    
    Assertions.assertEquals(tree.findNodeWithData(new Integer(15)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(23)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(10)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(18)).blackHeight, 0);
    Assertions.assertEquals(tree.toLevelOrderString(), "[ 15, 10, 23, 18 ]");
  }
  
  @Test
  public void testComplexInsertion() {
    RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
    tree.insert(new Integer(7)); //Inserted as black root
    Assertions.assertEquals(tree.findNodeWithData(new Integer(7)).blackHeight, 1);
    
    tree.insert(new Integer(14)); //Inserted as red right child of root
    Assertions.assertEquals(tree.findNodeWithData(new Integer(14)).blackHeight, 0);
    
    tree.insert(new Integer(18)); //Inserted as red right child of 14, triggers left rotation + colorswap
    Assertions.assertEquals(tree.findNodeWithData(new Integer(7)).blackHeight, 0);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(14)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(18)).blackHeight, 0);
    
    tree.insert(new Integer(23)); //Inserted as red right child of 18, triggers recolor + repair
    Assertions.assertEquals(tree.findNodeWithData(new Integer(7)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(14)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(18)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(23)).blackHeight, 0);
    
    tree.insert(new Integer(1)); //Inserted as red left child of 7
    Assertions.assertEquals(tree.findNodeWithData(new Integer(1)).blackHeight, 0);
    
    tree.insert(new Integer(11)); //Inserted as red right child of 7
    Assertions.assertEquals(tree.findNodeWithData(new Integer(11)).blackHeight, 0);
    
    tree.insert(new Integer(20)); //Inserted as red left child of 20, triggers two rotations + color swap
    Assertions.assertEquals(tree.findNodeWithData(new Integer(14)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(7)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(20)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(1)).blackHeight, 0);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(11)).blackHeight, 0);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(18)).blackHeight, 0);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(23)).blackHeight, 0);
    Assertions.assertEquals(tree.toLevelOrderString(), "[ 14, 7, 20, 1, 11, 18, 23 ]");

    tree.insert(new Integer(29)); //Inserted as red right child of 23, triggers recolor
    Assertions.assertEquals(tree.findNodeWithData(new Integer(20)).blackHeight, 0);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(29)).blackHeight, 0);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(18)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(23)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(14)).blackHeight, 1);
    Assertions.assertEquals(tree.toLevelOrderString(), "[ 14, 7, 20, 1, 11, 18, 23, 29 ]");
    
    tree.insert(new Integer(25)); //Inserted as red left child of 29, triggers two rotations and color swap
    Assertions.assertEquals(tree.findNodeWithData(new Integer(20)).blackHeight, 0);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(29)).blackHeight, 0);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(18)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(23)).blackHeight, 0);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(25)).blackHeight, 1);
    Assertions.assertEquals(tree.toLevelOrderString(), "[ 14, 7, 20, 1, 11, 18, 25, 23, 29 ]");
    
    tree.insert(new Integer(27)); //Inserted as red left child of 29, triggers color swap then check
    Assertions.assertEquals(tree.findNodeWithData(new Integer(20)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(14)).blackHeight, 0);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(25)).blackHeight, 0);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(7)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(18)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(23)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(29)).blackHeight, 1);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(1)).blackHeight, 0);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(11)).blackHeight, 0);
    Assertions.assertEquals(tree.findNodeWithData(new Integer(27)).blackHeight, 0);
    Assertions.assertEquals(tree.toLevelOrderString(), "[ 20, 14, 25, 7, 18, 23, 29, 1, 11, 27 ]");
    
    
  }

}
