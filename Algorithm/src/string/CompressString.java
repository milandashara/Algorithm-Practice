package string;

/**
 * Created by mukesh on 18/6/17.
 */
public class CompressString {

    public static String compress(String str){

        String out = "";

        int sum = 1;

        for (int i=0;i< str.length() -1;i++){

            if (str.charAt(i) == str.charAt(i+1)) {
                sum++;
            }
            else{
                out = out + str.charAt(i)+sum;
                sum=1;

            }
        }

        out = out + str.charAt(str.length()-1)+sum;

        return out.length() < str.length() ? out:str;

    }


    public static void main(String arg[]){
        System.out.println(compress("aaabccc"));
    }
}
