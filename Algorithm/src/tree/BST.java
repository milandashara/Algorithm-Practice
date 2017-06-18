package tree;

/**
 * Created by mukesh on 18/6/17.
 */
public class BST {


    public static boolean isBST(Node node){
            return isBST(node,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public static boolean isBST(Node node, Integer min, Integer max){

        if (node == null) return true;

        if (node.value < min || node.value > max){
            return false;
        }

        return isBST(node.left,min,node.value)&& isBST(node.right,node.value+1,max);
    }

}

class Node{
    public int value;

    public Node left;

    public Node right;

}