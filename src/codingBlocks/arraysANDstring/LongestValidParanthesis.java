package codingBlocks.arraysANDstring;

import java.util.Scanner;
import java.util.Stack;

/*
*

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
Input Format

Single String
Constraints

1<=|S|<=10^5
Output Format

Single Integer
Sample Input

(())))))))))))))

Sample Output

4
* */
public class LongestValidParanthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        Stack<Integer> s = new Stack();
        int count = 0, ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                s.push(count);
                count = 0;
            } else if (str.charAt(i) == ')') {
                if (s.isEmpty())
                    count = 0;
                else {
                    Integer top = s.pop();
                    count += top + 2;
                    ans = Math.max(ans, count);
                }
            }

        }

        System.out.println(ans);
    }
}
