package lazada;


import java.util.Arrays;
import java.util.Stack;

/**
 * Created by milanashara on 4/1/17.
 * Longest substring with valid password
 *
 */
public class Solution1 {


    public static int solution(String S) {
        // write your code in Java SE 8

        int length = Arrays.stream(S.split("[0-9]+"))
                .filter(s -> s.matches("(.+)?[A-Z](.+)?"))
                .sorted((s1, s2) -> s2.length() - s1.length())
                .findFirst()
                .orElse("")
                .length();

        if (length == 0){
            length = -1;
        }

        return length;

//        int maxLength = 0;
//        int start = 0;
//        int end =0;
//        boolean hasUpper = false;
//
//        for (int i =0;i< S.length();i++){
//
//            char c = S.charAt(i);
//
//
//            if (maxLength < i){
//                start = i;
//                maxLength = i -
//            }
//            if (isDigit(c)){
//
//            }else {
//                if (isUpperCase(c)){
//                    hasUpper = true;
//                }else {
//
//                }
//            }
//
//        }


    }

    public boolean isDigit(char c){
        if ((c >= '0' && c <= '9')){
            return true;
        }
        return false;
    }

    public boolean isUpperCase(char c){
        if ((c >= 'A' && c <= 'Z')){
            return true;
        }
        return false;
    }


    public static void main(String args[] ) throws Exception {
            System.out.println(solution("a0Baa0abc1dD"));
    }


}


