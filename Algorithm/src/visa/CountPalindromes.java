package visa;

/**
 * Created by milanashara on 3/5/17.
 */
public class CountPalindromes {

    static int countPalindromes(String s) {
        int result = 0;
        int length = s.length();

        for(int i = 0; i < length; i++) {
            for(int j = 1; j <= length - i; j++) {
                if(isPalindrome(s.substring(i, i + j))) {
                    ++result;
                }
            }
        }

        return result;
    }

    private static boolean isPalindrome(String s) {
        StringBuffer stringBuffer = new StringBuffer(s);
        StringBuffer reverse = new StringBuffer(s);
        reverse.reverse();
        return stringBuffer.toString().equals(reverse.toString());
    }



    public static void main(String arg[]){
        System.out.println(countPalindromes("aaa"));
    }
}
