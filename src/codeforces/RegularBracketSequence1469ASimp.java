package codeforces;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class RegularBracketSequence1469ASimp {
    public static void main(String args[]) throws IOException {


        Scanner sc = new Scanner(System.in);


        int t = sc.nextInt();
        while (t-- > 0) {

            String str = sc.next();

            System.out.println(solve(str));
        }
    }

    private static String solve(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                s.push('(');
            } else if (str.charAt(i) == '?') {
                if (s.isEmpty()) {
                    s.push('?');
//                    return "NO";
                } else if (s.peek() == '(' || s.peek() == '?') {
                    s.pop();
                } else
                    s.push('?');

            } else if (str.charAt(i) == ')') {
                if (s.isEmpty())
                    return "NO";
                else if (s.peek() == '(' || s.peek() == '?')
                    s.pop();
                else
                    s.push(')');

            }

        }


        return s.isEmpty() == true ? "YES" : "NO";
    }
}
