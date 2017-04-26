package lazada;


import javax.xml.soap.Node;
import java.util.*;

/**
 * Created by milanashara on 4/1/17.
 * Num of distinct value that appear on path from root to leaf
 *
 */

class Tree {
    public int x;
    public Tree l;
    public Tree r;

    public Tree(int x) {
        this.x = x;
    }

    public Tree(){

    }
}


public class Solution3 {



//    private static Map<Integer,Integer> visited = new HashMap<>();
//    private static int count_distinct=0;
//    private static int maximum=0;


//    public int solution1(Tree T) {
//        // write your code in Java SE 8
//        if(T==null)
//            return 0;
//
//        if(visited.getOrDefault(T.x,0)==0) {
//            count_distinct++;
//            visited.put(T.x,0);
//        }
//
//
//        maximum=Math.max(maximum, count_distinct);
//        visited.put(T.x,visited.get(T.x)+1);
//
//        solution(T.l);
//
//        solution(T.r);
//
//        visited.put(T.x,visited.get(T.x)-1);
//        if(visited.getOrDefault(T.x,0)==0)
//            count_distinct--;
//
//        return count_distinct;
//
//
//    }

    public static int solution(Tree T) {
        // write your code in Java SE 8

         Map<Integer,Integer> visited = new HashMap<>();
         int count_distinct=0;
         int maximum=0;

        if (T == null) {
            return 0;
        }

        //keep the nodes in the path that are waiting to be visited
        Stack<Tree> stack = new Stack<Tree>();
        Tree node = T;

        //first node to be visited will be the left one
        while (node != null) {

//            if(visited.getOrDefault(T.x,0)==0) {
//                count_distinct++;
//                visited.put(T.x,1);
//            }
//            if (node !=null && (node.l == null && node.r == null)){
//                maximum=Math.max(maximum, count_distinct);
//                count_distinct--;
//            }

            stack.push(node);
            node = node.l;
        }

        // traverse the tree
        while (stack.size() > 0) {

            // visit the top node
            node = stack.pop();
            //System.out.print(node.x + " ");
            if(visited.getOrDefault(node.x,0)==0) {
                count_distinct++;
                visited.put(node.x,1);
            }else {
                visited.put(node.x,visited.get(node.x)+1);
            }


            //maximum=Math.max(maximum, count_distinct);

            if (node !=null && (node.l == null && node.r == null)){
                maximum=Math.max(maximum, count_distinct);
//                if(visited.getOrDefault(node.x,0)>1) {
//                    count_distinct--;
//                    visited.put(node.x,visited.get(node.x)-1);
//                }

            }else {
                //count_distinct--;
                //visited.put(T.x,visited.getOrDefault(T.x,0)-1);
            }


            if (node.l != null) {
                node = node.r;

                // the next node to be visited is the leftmost
                while (node != null) {
                    stack.push(node);
                    node = node.l;
                }
            }


        }
        return maximum;

    }




    public static void main(String args[] ) throws Exception {

        Tree tree = new Tree();
        tree.x =5;
        tree.l = new Tree(5);
        tree.r = new Tree(6);
        tree.l.l = new Tree(7);
        System.out.println(solution(tree));
    }


}


