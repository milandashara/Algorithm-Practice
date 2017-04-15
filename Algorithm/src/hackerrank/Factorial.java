package hackerrank;


import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by milanashara on 3/4/17.
 */
public class Factorial {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        BigInteger factorial=BigInteger.valueOf(n);
        while (n>1){
            factorial = factorial.multiply((BigInteger.valueOf(n-1)));
            n--;
        }
        System.out.println(factorial.toString());
        in.close();
    }
}
