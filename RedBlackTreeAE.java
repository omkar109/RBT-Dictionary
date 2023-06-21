import java.util.NoSuchElementException;
public class RedBlackTreeAE<nodeType extends Comparable<nodeType>> extends RedBlackTree<nodeType> implements RedBlackTreeInterface<nodeType>  {
    public RedBlackTreeAE(){

        super();
    }// week 3
    //public RedBlackTreeInterface(); week 4


    /**
     * gets the node that is equal to the argument
     *     If the node is not found, returns null
    */
    @Override
    public nodeType get(nodeType node) {
        /**
        String s = super.toInOrderString();
        String check = "";

        for(int i=0;i<s.length();i++){

            if (s.substring(i, i+1).equals("[")||s.substring(i,i+1).equals(",") || s.substring(i,i+1).equals(" ")) {

                if (check.length()==0){
                    continue;
                }
                if(check.equals(node)){
                    return node;
                }
                check = "";
            }
            check+=s.substring(i,i+1);

        }
        */

        findNodeWithData(node);
        Node<nodeType> r = findNodeWithData(node);
        if (r==null){
            return null;
        }
        return r.data;
    }

    /**
     * removes the node that is equal to the argument, found by the get method
     *      Throws exception if no such node exists.
     * @throws NoSuchElementException
     */

    @Override
    public boolean removeNode(nodeType node) throws NoSuchElementException {


        if(get(node)==null){
            throw new NoSuchElementException("Node does not exist");
        }


        Node<nodeType> del = findNodeWithData(node);
        boolean hasRightChild = (del.context[2] != null);
        boolean hasLeftChild = (del.context[1] != null);
        Node<nodeType>rep;
        if(del.context[0]==null){

        }
        if (hasLeftChild &&hasRightChild){
            rep = findMinOfRightSubtree(del);
        }
        else if (hasRightChild){
          rep = del.context[2];
        }
        else if(hasLeftChild){
            rep = del.context[1];
        }
        else{
            rep = null;
        }

        if(del.blackHeight==1&&(rep==null||rep.blackHeight==1)){

            RBTDelete_fix(del);

        }
        else{
            remove(node);
        }

return true;


    }

    protected void RBTDelete_fix(Node<nodeType> node){

        if(node.isRightChild()){
            remove(node.data);

            Node<nodeType> sib = node.context[0].context[1];
            if(sib.blackHeight==0){

                node.context[0].blackHeight = 0;

                sib.blackHeight = 0;

                rotate(node.context[0].context[1],node.context[0]);
                sib = node.context[0].context[1];

            }
            if((sib.context[1]==null ||sib.context[1].blackHeight==1)&&(sib.context[2]==null ||sib.context[2].blackHeight==1)){
                node.context[0].context[1].blackHeight = 0;
                node = node.context[0];
            }
            else{
                if((sib.context[1]==null||sib.context[1].blackHeight==0)){
                    try{
                        node.context[0].context[1].context[2].blackHeight = 1;
                    }
                    catch( Exception e){
                    }
                    node.context[0].context[1].blackHeight = 0;
                    rotate(node.context[0].context[1].context[2],node.context[0].context[1]);
                    sib = node.context[0].context[1];

                }
                node.context[0].context[1].blackHeight = node.context[0].blackHeight;
                node.context[0].blackHeight = 1;
                try{
                    node.context[0].context[1].context[1].blackHeight = 1;
                }
                catch( Exception e){
                }

                rotate(node.context[0].context[1],node.context[0]);

            }

        }
        else if(!node.isRightChild()){
            remove(node.data);
            //sibling
            Node<nodeType> sib = node.context[0].context[2];

            if(sib.blackHeight==0){

                node.context[0].blackHeight = 0;

                sib.blackHeight = 0;

                rotate(node.context[0].context[2],node.context[0]);
                sib = node.context[0].context[2];

            }
            if((sib.context[1]==null ||sib.context[1].blackHeight==1)&&(sib.context[2]==null ||sib.context[2].blackHeight==1)){
                node.context[0].context[2].blackHeight = 0;
                node = node.context[0];
            }
            else{
                if((sib.context[2]==null||sib.context[2].blackHeight==0)){
                    try{
                        node.context[0].context[2].context[1].blackHeight = 1;
                    }
                    catch( Exception e){
                    }
                    node.context[0].context[2].blackHeight = 0;
                    rotate(node.context[0].context[2].context[1],node.context[0].context[2]);
                    sib = node.context[0].context[2];

                }
                node.context[0].context[2].blackHeight = node.context[0].blackHeight;
                node.context[0].blackHeight = 1;
                try{
                    node.context[0].context[2].context[2].blackHeight = 1;
                }
                catch( Exception e){
                }

                rotate(node.context[0].context[2],node.context[0]);

            }

        }






    }
    private void rotate(Node<nodeType> child, Node<nodeType> parent) throws IllegalArgumentException {

        //temp value
        String rol = "None";


        //Checking if the child is on the left or right of the parent

        if (child.equals(parent.context[2])) {
            //System.out.println("right");
            rol = "right";

        }
        else if(child.equals(parent.context[1])) {
            //System.out.println("left");
            rol = "left";
        }
        else if(!child.context[0].equals(parent)){
            throw new IllegalArgumentException();

        }


        //RIGHT ROTATION
        if(rol.equals("left")) {


            //setting the left child of parent to null
            parent.context[1] = null;

            //making a temp value
            Node<nodeType> temp = child.context[2];

            //replacing the parent with the child
            replaceNode(parent, child);

            child.context[2] = parent;

            parent.context[1] = null;
            parent.context[1] = temp;




        }//LEFT ROTATION
        else {

            //setting the right child of parent to null
            parent.context[2] = null;

            //System.out.println(toLevelOrderString());
            Node<nodeType> temp = child.context[1];

            //replacing the parent with the child
            replaceNode(parent, child);


            child.context[1] = parent;



            parent.context[2] = null;
            parent.context[2] = temp;

        }

    }




}

