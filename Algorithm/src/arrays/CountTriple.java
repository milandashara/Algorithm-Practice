package arrays;

import java.util.Arrays;

/**
 * Created by milan on 16/6/17.
 */
public class CountTriple {

    public static int countTriplet(int a[]){

        int count = 0;

        for (int i = 0;i < a.length; i++){

            for (int j = i+1; j < a.length; j++){

                for (int k=j+1; k < a.length; k++){

                    if (a[i]+a[j]+a[k] == 0){
                        count++;
                    }

                }

            }

        }

        return count;
    }


    public static int countTriplet1(int a[]){

        int count = 0;

        Arrays.sort(a);

        for (int i = 0;i < a.length; i++){

            int l=i+1;
            int r = a.length -1;

            while (l < r){

                if (a[i] + a[l] + a[r] > 0){
                    r--;
                }else if (a[i] + a[l] + a[r] < 0){
                    l++;
                }else {
                    count++;
                    r--;
                }

            }

        }

        return count;
    }

    public static void main(String s[]){


        int a[] = {-2,0,-1,3,0,0};
        System.out.println(countTriplet(a));
        int b[] = {-2,0,-1,3,0,0};
        System.out.println(countTriplet1(b));

    }
}
