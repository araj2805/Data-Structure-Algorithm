package Stack;

import java.util.Stack;

public class BalanceParathesis {

    public static Boolean isBalanceParanthesis(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else {
                if (stack.isEmpty())
                    return false;
                else if (isCheck(str.charAt(i), stack.peek()) == false)
                    return false;
                else
                    stack.pop();
            }
        }
        return (stack.isEmpty() == true);


    }

    private static boolean isCheck(char charAt, Character peek) {
        if (charAt == '}' && peek == '{')
            return true;
        else if (charAt == ')' && peek == '(')
            return true;
        else if (charAt == ']' && peek == '[')
            return true;

        return false;
    }

    public static void main(String[] args) {
        String input = "[])(";

        System.out.println(isBalanceParanthesis(input));
    }
}
