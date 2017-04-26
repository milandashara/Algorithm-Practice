package lazada;


import java.util.Arrays;
import java.util.Stack;

/**
 * Created by milanashara on 4/1/17.
 * Parenthesis
 *
 */
public class Solution2 {


    public static int solution(String S) {
        // write your code in Java SE 8

        //Stack stack = new Stack();
        int K = 0;

        for (char c: S.toCharArray()){

            switch (c){

                case ')':
                    K++;
                    break;
            }
        }

        return K;


    }




    public static void main(String args[] ) throws Exception {
            System.out.println(solution("))"));
    }


}


