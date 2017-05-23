package finantix;

import java.util.Scanner;

/**
 * @author milanashara
 *
 */
public class Solution {

    public static void main(String[] args) {

            System.out.print(isFairAndSquare(new Scanner(System.in)));
    }

    static String isFairAndSquare(Scanner in) {
        String result = "";
        int count = 0;
        int n = in.nextInt();
        for(int i=0;i<n;i++){

            for (int j=0;j<2;j++){
                int number = in.nextInt();
                if(isPalindroma(number)){
                    String numberSqrt = ""+Math.sqrt(number);
                    try {


                        Double numberSqrtInt = Double.parseDouble(numberSqrt);

                        if (isPalindroma(numberSqrtInt.intValue())){
                            count++;
                        }

                    }catch (Exception e){

                    }
                }


            }
            result = result + "Case #"+(i+1)+":"+count + "\n";
            count = 0;

        }

        return result;
    }

    public static boolean isPalindroma(int n){
        int r,sum=0,temp;

        temp=n;
        while(n>0){
            r=n%10;  //getting remainder
            sum=(sum*10)+r;
            n=n/10;
        }
        if(temp==sum)
            return true;
        else
            return false;
    }






}
