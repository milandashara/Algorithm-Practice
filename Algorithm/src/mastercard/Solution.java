package mastercard;

/**
 * Created by milanashara on 5/20/17.
 *
 * reduced fraction sum
 */
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        String result[] = fractionSum(new String[]{"722/148+360/176",
                "978/1212+183/183",
                "358/472+301/417",
                "780/309+684/988",
                "258/840+854/686"});


        for (String s:result){
            System.out.println(s);
        }



    }

    static String[] fractionSum(String[] str) {


        String result[]=new String[str.length];
        int i = 0;
        for (String s:str){


            String fraction[]=s.split("\\+");

            result[i] = sum(fraction[0],fraction[1]);


          i++;
        }

        return result;
    }

    static String sum(String s1,String s2){
        String xy[] = s1.split("/");
        String uv[] = s2.split("/");

        int x = Integer.parseInt(xy[0]);
        int y = Integer.parseInt(xy[1]);

        int u = Integer.parseInt(uv[0]);
        int v = Integer.parseInt(uv[1]);


        int num=(x*v) + (u * y);
        int den=y*v;
        int gcd = gcd(num,den);
        num /= gcd;
        den /= gcd;
        return num+"/"+den;
        //return asFraction(num,den);
    }


    public static int gcm(int a, int b) {
        return b == 0 ? a : gcm(b, a % b); // Not bad for one line of code :)
    }

    public static String asFraction(int a, int b) {
        int gcm = gcm(a, b);
        return (a / gcm) + "/" + (b / gcm);
    }






    // return gcd(|m|, |n|)
    private static int gcd(int m, int n) {
        if (m < 0) m = -m;
        if (n < 0) n = -n;
        if (0 == n) return m;
        else return gcd(n, m % n);
    }




}
