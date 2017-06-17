package puzzle;

/**
 * Created by mukesh on 17/6/17.
 */
public class MinNumCoinChange {


    public static int change(int x,int coins[]){

        if (x == 0) return 0;

        int min=x;

        for (int coin:coins){

            if (x-coin >= 0){

                int c = change(x-coin,coins);

                if (min > c +1){
                    min = c +1;
                }

            }

        }


        return min;
    }


    public static void main(String arg[]){

        int coins[]={10,5,1,25};

        int x=32;

        System.out.println(change(x,coins));

    }




}
