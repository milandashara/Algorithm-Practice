package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by milan on 16/6/17.
 */
public class ZeroSumSubArray {

    public static int[] zeroSum(int a[]) {

        int sumArray[] = new int[a.length];
        Map<Integer, Integer> sumArrayValueIndexMap = new HashMap<>();


        int sum = 0;
        int start = Integer.MIN_VALUE;
        int end = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];



            if (sumArrayValueIndexMap.containsKey(sum)) {
                int tempstart = sumArrayValueIndexMap.get(sum) + 1;
                int tempend = i;

                if (tempstart > start) {
                    start = tempstart;
                }

                if (tempend < end) {
                    end = tempend;
                }
                break;
            }

            sumArrayValueIndexMap.put(sum, i);







        }
        System.out.println(start+","+end);
        if (start == Integer.MIN_VALUE || end == Integer.MAX_VALUE) {
            return null;
        } else {
            int result[] = new int[end - start+1];
            int temp = 0;
            for (int j = start; j <= end; j++) {

                result[temp] = a[j];
                temp++;

            }
            return result;
        }
    }


    public static void main(String arg[]){
        int a[]={1,2,-5,1,2,-1};
        int result[]=zeroSum(a);

        for (int temp:result){
            System.out.println(temp);
        }

    }

}
