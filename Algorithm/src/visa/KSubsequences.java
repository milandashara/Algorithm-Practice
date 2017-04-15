package visa;

/**
 * Created by milanashara on 3/5/17.
 */
public class KSubsequences {

    static long kSub(int k, int[] nums) {

        //inititalize
        long[] modCountPrefix = new long[k];
        for(int i = 0; i < k; i++)
        {
            modCountPrefix[i] = 0;
        }
        modCountPrefix[0] = 1;


        int sumPrefix = 0;
        for(int i = 0; i < nums.length; i++)
        {
            sumPrefix += nums[i];
            sumPrefix %= k;
            modCountPrefix[sumPrefix] += 1;
        }

        long result = 0;
        for(int mod = 0; mod < k; mod++)
        {
            result += modCountPrefix[mod] * (modCountPrefix[mod] - 1) / 2;
        }

        return result;
    }

    public static void main(String args[]){
        int[] ints = {1,2,3,4,1};
        kSub(3,ints);
    }
}
