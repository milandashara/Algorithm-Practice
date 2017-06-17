package bit_manipulation;

/**
 * Created by mukesh on 17/6/17.
 */
public class NumberOfOnesInBinary {


    public static int ones(int x){
        int sum = 0;

        while (x > 0){
            sum+=x&1;
            x>>=1;
        }
        return sum;
    }

    public static void main(String arg[]){
        System.out.println(ones(1));
    }
}
