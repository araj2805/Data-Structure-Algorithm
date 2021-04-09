package codingBlocks.arraysANDstring;

import java.util.Arrays;
import java.util.Scanner;

/*
*

We have an array of positive integers. The task is to print the maximum length of Bitonic subsequence.
A bitonic sequence is any sequence which first increases in magnitude and then at a certain point it starts to decrease in magnitude.
For eg: 1 2 3 2 1 is a bitonic sequence while 1 2 3 2 1 2 3 is not, since it first increases, then decreases and then again increases.
Input Format

First line of each input contains T(no. of testcase)
For each testcase first line contains 'n' length of array
For each testcase next 'n' lines contains element a[i]
Constraints

1<=T<=100
1<=N<=100
1<=Ai<=200
Output Format

For each testcase , in a new line, print the length of longest Bitonic sequence.
Sample Input

2
9
1 3 5 7 4 3 5 2 6
11
4 5 6 3 2 7 8 5 4 6 3

Sample Output

7
8

Explanation

In the first test case we can select numbers 1 3 5 7 4 3 2 => ans =7.
In the second testcase we can select numbers 4 5 6 7 8 5 4 3 => ans=8

* */
public class BiotonicSubsequenece {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tt = sc.nextInt();
        while (tt-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];

            for (int i = 0; i < n; i++)
                nums[i] = sc.nextInt();

            System.out.println(solve(nums, n));
        }

    }

    private static int solve(int[] nums, int n) {

        int[] left = new int[n], right = new int[n];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    left[i] = Math.max(left[i], left[j] + 1);
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }

        int ans = 0;

        for (int i = 1; i < n - 1; i++) {
            if (left[i] > 1 && right[i] > 1)
                ans = Math.max(ans, (left[i] + right[i] - 1));
        }

        return ans;
    }
}
