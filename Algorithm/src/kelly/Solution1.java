package kelly;

/**
 * Created by mukesh on 5/6/17.
 */
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution1 {
    public int solution(int[] A) {
        // write your code in Java SE 8

        Arrays.sort(A);

        int diff = Integer.MAX_VALUE;
        for(int i=0;i<A.length-1;i++){
            int temp = Math.abs(A[i] - A[i+1]);
            if(temp < diff){
                diff = temp;
            }

        }

        return diff;
    }
}