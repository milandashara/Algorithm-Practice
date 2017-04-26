//package booking;
//
//
//import java.util.Stack;
//
///**
// * Created by milanashara on 4/1/17.
// * Balanced Parenthesis
// *
// */
//public class Solution6 {
//
//    public static boolean isBalanceParaenthesis(String s){
//        Stack stack = new Stack();
//
//        for (int i=0;i<s.length();i++){
//            char c=s.charAt(i);
//
//            switch (c){
//                case '(':
//                    stack.push(c);
//                case ')':
//                    if (stack.isEmpty() || !stack.contains('(')){
//                    return false;
//                    }
//                    while (!stack.isEmpty() && stack.peek() !='(' ){
//                        stack.pop();
//                    }
//                    if (!stack.isEmpty() && stack.peek() == '('){
//                        stack.pop();
//                    }
//                default:
//                    stack.push(c);
//            }
//        }
//
//        if (stack.isEmpty() || !stack.contains('(') || !stack.contains(')')){
//            return true;
//        }
//
//        return false;
//    }
//
//
//
//
//    public static void main(String args[] ) throws Exception {
//            System.out.println(isBalanceParaenthesis("(a(bc)dd"));
//    }
//
//
//}
//
//
