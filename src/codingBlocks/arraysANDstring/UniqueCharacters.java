package codingBlocks.arraysANDstring;

import java.util.Scanner;

/*


Ramu has an array of strings. He want to find a string s such that it is a concatenation of sub-sequence of given array and have unique characters.Since,he has just started coding so he needs your help.
A sub-sequence of an array is a set of elements that can be obtained by deleting some elements(posssibly none) from the array and keeping the order same.
Print the maximum possible length of s.
Input Format

The first line of input contains an interger n -the length of array.Next n lines contains the element(strings) of the array
Constraints

1 <= n <= 18, 1 <= arr[i].length<= 26
Output Format

Print one integer - the maximum length of s.
Sample Input

3
ab
cd
ab

Sample Output

4


* */
public class UniqueCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.next();

        System.out.println(uniqueCharacter(arr, n));

    }

    private static int uniqueCharacter(String[] arr, int n) {
        return helper(arr, 0, "");
    }

    private static int helper(String[] arr, int i, String s) {

        if (i == arr.length) {
            if (s.length() > 26)
                return 0;

            int[] freq = new int[26];

            for (int k = 0; k < s.length(); k++) {
                if (freq[s.charAt(k) - 'a'] == 1)
                    return 0;
                freq[s.charAt(k) - 'a']++;
            }

            return s.length();
        }

        int op1 = Integer.MIN_VALUE, op2 = op1;
//            int op1 = 0, op2 = 0;

        // Including character
        if (arr[i].length() + s.length() <= 26) {
            op1 = helper(arr, i + 1, s + arr[i]);
        }

        op2 = helper(arr, i + 1, s);

        return Math.max(op1, op2);

    }
}
