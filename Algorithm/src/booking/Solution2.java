package booking;


import java.util.*;

/**
 * Created by milanashara on 4/1/17.
 * Polygon
 *
 */
public class Solution2 {



    public static void main(String args[] ) throws Exception {

        Scanner in = new Scanner(System.in);
        long squares =0;
        long rectangle =0;
        long polygon =0;
        while (in.hasNext()){

            String words = in.nextLine();
//            if (words==null || words.isEmpty()){
//                in.close();
//                break;
//            }
            String[] splited = words.split("\\s+");



            if (splited[0].equals(splited[2]) && splited[1].equals(splited[3])){
                if (splited[0].equals(splited[1])){
                    squares++;
                }else{
                    boolean isInvalid = false;
                    for (String s:splited){
                        if (Integer.parseInt(s) <= 0){
                            polygon++;
                            isInvalid = true;
                            break;
                        }
                    }
                    if (!isInvalid)
                    rectangle++;
                }
            }
            else {
                polygon++;
            }
        }
        System.out.print(squares+" "+rectangle+" "+polygon);


    }


}
