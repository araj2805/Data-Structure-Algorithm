package Stack;

import java.util.Stack;

public class RemovekDigits {

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
    }

    private static String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {

            while (stack.isEmpty() == false && k > 0 && stack.peek() > digit) {
                k--;
                stack.pop();
            }

            stack.push(digit);
        }


        StringBuilder res = new StringBuilder();
        boolean isZero = true;

        for (char digit : stack) {

            if (digit == '0' && isZero == true) {
                continue;
            }

            isZero = false;

            res.append(digit);
        }

        if (res.length() == 0)
            return "0";

        return res.toString();
    }
}
