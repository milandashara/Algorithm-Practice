package babylon;

import problems.mst.Stack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by milanashara on 5/20/17.
 *
 * Longest Subarray
 */
public class Solution1 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        int output = maxLength(new int[]{1,2,3,4},4);


            System.out.println(output);




    }

    /*
     * Complete the function below.
     */
    static int maxLength(int[] a, int k) {
        int sum = 0;
        int count = 0;

        for (int i = 0; i < a.length; i++) {

            if ((sum + a[i]) <= k) {
                sum += a[i];
                count++;
            }

            else if(sum!=0)
            {
                sum = sum - a[i - count] + a[i];
            }
        }
        return count;

    }




}
