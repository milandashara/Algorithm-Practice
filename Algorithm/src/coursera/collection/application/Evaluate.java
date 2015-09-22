package coursera.collection.application;

import coursera.collection.LinkedStack;

import java.util.Scanner;

/**
 * Created by milanashara on 22/9/2015.
 */
public class Evaluate {
    public static void main(String[] args) {
        LinkedStack<String> ops = new LinkedStack<String>();
        LinkedStack<Double> vals = new LinkedStack<Double>();
        Scanner scanner = new Scanner(System.in);
        String s = null;
        while (!(s = scanner.next().trim()).equals("exit")) {

            if (s.equals("(")) ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            } else vals.push(Double.parseDouble(s));
        }
        System.out.println(vals.pop());
    }
}
