package Stack;

import java.util.Stack;

public class ScoreOfParanthesis {
    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("(()(()))"));
        System.out.println(scoreOfParentheses("()()"));
        System.out.println(scoreOfParentheses("(())"));
        System.out.println(scoreOfParentheses("()"));
    }

    private static int scoreOfParentheses(String str) {

        Stack<String> s = new Stack<>();
        int res = 0;

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '(') {
                s.push("(");
            } else {
                if (s.peek() == "(") {
                    s.pop();
                    s.push("1");
                } else {
                    int c = 0;

                    while (s.peek() != "(") {
                        c += Integer.parseInt(s.pop());
                    }

                    c = c * 2;

                    s.pop();
                    s.push(String.valueOf(c));
                }
            }

        }

        while (s.isEmpty() == false) {
            res += Integer.parseInt(s.pop());
        }


        return res;
    }
}
