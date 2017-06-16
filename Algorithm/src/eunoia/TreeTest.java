package eunoia;
/*
   1. Only write your code in the methods that have the comment 'write your code here' or in the section 'write optional helper functions here'
   2. Do not modify anything else
   3. If your code cannot compile or fails the test cases in 'main()', you will not receive a response from us
*/

import java.util.*;
import java.util.regex.*;

public class TreeTest {
    public static void main(String... args) {

		/*
		   Consider the following tree:

		         1
		      /  |  \
		     2   4   6
		   / |  / \  |  \  
		  3  9 5  7  11 12
		      / \      / | \
		     13 16    14 23 17
		       / \
		      24 32


		  Assuming the numbers are the ids of each node, the tree can be written down as follows:

		  1(2,4,6) 2(3,9) 4(5,7) 6(11,12) 5(13,16) 12(14,23,17) 16(24,32)

		  In the example above, for the group 1(2,4,6), node 2, 4 and 6 are the child nodes of
		  node 1. Note that extra whitespaces should be accepted. Assume ids are positive integers only.
		*/

        Tree first = new Tree("1(2,4,6) 2(3,9) 4(5,7)  6(11,12) 5(13,16)   12(14,23,17) 16(24,32)");
        assertTrue(first.getDepthOfNodeWithId(1) == 1);
        assertTrue(first.getDepthOfNodeWithId(4) == 2);
        assertTrue(first.getDepthOfNodeWithId(5) == 3);
        assertTrue(first.getDepthOfNodeWithId(12) == 3);
        assertTrue(first.getDepthOfNodeWithId(16) == 4);
        assertTrue(first.getDepthOfNodeWithId(23) == 4);
        assertTrue(first.getDepthOfNodeWithId(32) == 5);

		/*
		      2
		   / | | \ 
		  5  4 3  1
		  |     \
		  7      9
		 / \   /  \
		12 10 11  14
		    |
		    13
		   / | \
		 16  8  15
		*/

        Tree second = new Tree("2(5,4,3,1)  5(7)   3(9) 7(12,10)   9(11,14)  10(13) 13(16,8,15)");
        assertTrue(second.getDepthOfNodeWithId(2) == 1);
        assertTrue(second.getDepthOfNodeWithId(5) == 2);
        assertTrue(second.getDepthOfNodeWithId(3) == 2);
        assertTrue(second.getDepthOfNodeWithId(12) == 4);
        assertTrue(second.getDepthOfNodeWithId(11) == 4);
        assertTrue(second.getDepthOfNodeWithId(13) == 5);
        assertTrue(second.getDepthOfNodeWithId(8) == 6);
    }

    private static void assertTrue(boolean v) {
        if(!v) {
            Thread.dumpStack();
            System.exit(0);
        }
    }
}

class Tree {
    private Node root;

    public Tree(String treeData) {

        String parentChilds[] = treeData.split("\\s+");

        Node parent = null;
        for (int j=0;j<parentChilds.length;j++){
            String parentChild = parentChilds[j];
            parent = null;

            //get all digits from string. 1st element will be parent
            List<Integer> tempList = new ArrayList<>();
            Pattern p = Pattern.compile("-?\\d+");
            Matcher m = p.matcher(parentChild);
            while (m.find()) {
               tempList.add(Integer.parseInt(m.group()));
            }

            //i=0 is parent. 1st element in list is parent
            for (int i=0;i<tempList.size();i++){

                int id = tempList.get(i);

                if (i==0){//find parent node or create root node


                    if (parent==null && j!=0) {
                        parent = findNode(root,id);

                    }

                    if (parent == null && j== 0){
                        if (j==0) {
                            root = new Node(id);
                            parent = root;
                        }

                    }


                }else {//create new node and set it as child to parent


                            Node newPode = new Node(id,parent);
                            parent.appendChild(newPode);

                }


            }

        }


        // write your code here
    }



    public int getDepthOfNodeWithId(int id) {
        int depth=0;

        if (root == null)
            return depth;

        depth++;

        Node node = findNode(root,id);

        while (node != root){
            depth++;
            node = node.getParent();
        }


        return depth;
    }


    /**
     * returns node if found else returns null
     * @param node
     * @param id
     * @return
     */
    public Node findNode(Node node,Integer id){

        if(node != null){
            if(node.getId() == id){
                return node;
            } else {

                for (Node node1:node.getChildren()){

                    Node foundNode = findNode( node1,id);
//                    if(foundNode == null) {
//                        foundNode = findNode(name, node.right);
//                    }

                    if (foundNode != null)
                        return foundNode;
                    //return foundNode;

                }


            }
        } else {
            return null;
        }

        return null;

    }



    // write optional helper functions here
}

class Node {
    private Node parent;
    private List<Node> children;
    private int id;

    public Node(int id) {
        this.id = id;
        this.children = new ArrayList<Node>();
    }

    public Node(int id, Node parent) {
        this(id);
        this.parent = parent;
        this.children = new ArrayList<Node>();
    }

    public Node getParent(){
        return parent;
    }


    public void appendChild(Node child) {
        children.add(child);
    }

    public int getId() {
        return id;
    }

    public List<Node> getChildren() {
        return Collections.unmodifiableList(children);
    }
}