package Revision;

import java.util.Stack;

public class ValidPranthesis {

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    public static boolean isValid(String s) {

        Stack<Character> sc = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            Character ch = s.charAt(i);

            if (sc.isEmpty()) {
                if (ch == ')' || ch == ']' || ch == '}')
                    return false;
                else
                    sc.push(ch);
            } else if ((sc.peek() == '(' && ch == ')') || (sc.peek() == '[' && ch == ']') || (sc.peek() == '{' && ch == '}'))
                sc.pop();
            else
                sc.push(ch);
        }


        return sc.isEmpty() == true;
    }
}
