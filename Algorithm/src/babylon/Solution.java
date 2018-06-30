package babylon;

import problems.mst.Stack;

/**
 * Created by milanashara on 5/20/17.
 *
 * Braces
 */
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        String result[] = braces(new String[]{"{}","{(})"});


        for (String s:result){
            System.out.println(s);
        }



    }

    static String[] braces(String[] values) {
        String[] outputStrArray = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            String value = values[i];
            outputStrArray[i] = checkBalancedParentheses(value)?"YES":"NO";

        }
        return outputStrArray;
    }

    private static boolean checkBalancedParentheses(String value){
        Stack<String> stack = new Stack<String>();
        boolean isBalanaced = false;

        for(int i=0; i < value.length(); i++){
            String str = ""+value.charAt(i);


            if(str.equals("(") || str.equals("[") || str.equals("{")){
                stack.push(str);
            }


            if(str.equals(")") || str.equals("]") || str.equals("}")){

                if(stack.isEmpty()){
                    return false;
                }
                String opening = stack.peek();
                if(str.equals(")") && opening.equals("(")){
                    stack.pop();
                }
                if(str.equals("]") && opening.equals("[")){
                    stack.pop();
                }
                if(str.equals("}") && opening.equals("{")){
                    stack.pop();
                }
            }
        }

        if(value.length() > 0 && stack.isEmpty()){
            isBalanaced = true;
        }

        return isBalanaced;
    }




}
