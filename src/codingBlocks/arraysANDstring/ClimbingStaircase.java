package codingBlocks.arraysANDstring;

import java.util.Scanner;

/*
*

Reaching to the top of a staircase, it takes n steps.
The task can be accomplished either by climbing 1 step or 2 steps at a time.
In how many different ways can you climb to the top.
Note: n will be a positive integer.
Input Format

First line contains an integer n.
Constraints

None
Output Format

Print the total number of distinct ways you can climb to top.
Sample Input

2

Sample Output

2

* */
public class ClimbingStaircase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n + 1];

        System.out.println(solve(n, dp));
    }

    private static int solve(int n, int[] dp) {

//        Base Case
        if (n <= 1)
            return n;
        if (n == 2)
            return n;

        if (dp[n] != 0)
            return dp[n];

        dp[n] = solve(n - 1, dp) + solve(n - 2, dp);

        return dp[n];
    }
}
