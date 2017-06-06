package kelly;

/**
 * Created by mukesh on 5/6/17.
 */
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int evenCount = 0;

        for(int n:A){

            if((n & 1) == 0){
                evenCount++;
            }
        }

        int oddCount = A.length - evenCount;

        long temp = (evenCount * (evenCount -1) / 2) + (oddCount * (oddCount -1) / 2);

        if(temp > 1000000000)
            return -1;

        return (int)temp;
    }
}
