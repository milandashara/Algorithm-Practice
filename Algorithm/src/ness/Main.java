package ness;

/**
 * Created by mukesh on 4/6/17.
 */
public class Main {

    public static void main(String arg[]){

    }

    public static int[] solution(int nums[],int maxes[]){
        int result[] = new int[maxes.length];

        for (int i=0;i<maxes.length;i++){

            int count = 0;
            for (int j=0;j<nums.length;j++){
                if (nums[j] <= maxes[i]){
                    count++;
                }
            }

            result[i] = count;
        }

        return result;
    }

}
