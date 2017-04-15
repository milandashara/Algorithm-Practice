package booking;


import java.util.Scanner;

/**
 * Created by milanashara on 4/1/17.
 *
 * Delta encoding
 */
public class Solution3 {



    public static void main(String args[] ) throws Exception {

        Scanner in = new Scanner(System.in);
        int number = 0;
        int nextnumber = 0;
        boolean isFirst = true;
        while (in.hasNext()) {


            if (isFirst) {
                number = in.nextInt();
                System.out.print(number + " ");
                isFirst= false;
                nextnumber = in.nextInt();
                int delta = nextnumber - number;

                if (delta < -127 || delta > 127) {
                    System.out.print("-128 " + delta + " ");
                } else {
                    System.out.print(delta + " ");
                }
                number = nextnumber;




            }else {
                nextnumber = in.nextInt();
                int delta = nextnumber - number;

                if (delta < -127 || delta > 127) {
                    System.out.print("-128 " + delta + " ");
                } else {
                    System.out.print(delta + " ");
                }

                number = nextnumber;
            }



        }
        in.close();
    }


}
