package hackerrank;

import java.util.Scanner;

/**
 * Created by milanashara on 4/15/17.
 *
 *
 *
 *
 */
public class StairCase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for(int i=0;i<n;i++){
            for(int j=n-i-1;j>0;j--){
                System.out.print(" ");
            }
            for(int k=0;k<=i;k++){
                System.out.print("#");
            }

            System.out.println();
        }
    }
}
