package agoda;

import problems.mst.Stack;

/**
 * Created by mukesh on 28/5/17.
 */
public class Main {

    public static void main(String arg[]){
        String prefixs[] = {"+12","+1**23/14"};
        String resultArr[] = prefixToPostFix(prefixs);

        for (String resultStr: resultArr){
            System.out.println(resultStr);
        }
    }

    public static String[] prefixToPostFix(String[] prefixes){

        String result[] = new String[prefixes.length];
        Stack stack = new Stack();

        for(int j = 0; j<prefixes.length;j++){
            String prefix = prefixes[j];
            String postFix="";

            for (int i=0;i<prefix.length();i++){

                char c1  = prefix.charAt(i);
                char c2 = 'a';
                char c3 =  'a';
                if (i <= prefix.length() -3) {

                     c2 = prefix.charAt(i + 1);
                     c3 = prefix.charAt(i + 2);
                }

                if (i <= prefix.length() -3 && Character.isDigit(c2) && Character.isDigit(c3) && isOperator(c1)){
                    postFix = postFix + c2 + c3 + c1;

                    i=i+2;
                }else {
                    if (isOperator(c1)){
                        stack.push(c1);
                    }else if (Character.isDigit(c1)){
                        postFix = postFix + c1;
                    }
                }


            }

            while (!stack.isEmpty()){
                postFix = postFix + stack.pop();
            }
            result[j] = postFix;

        }
        return result;
    }

    private static boolean isOperator(char c){
        char[] operators = {'+','-','/','*'};
        boolean isOp = false;
        for(int i=0; i<operators.length; i++){
            if(c == operators[i]){
                isOp = true;
                break;
            }
        }
        return isOp;
    }
}
