package codingBlocks.arraysANDstring;

import java.util.Scanner;

/*
*
*

You are given an N X M matrix. Your task is to calculate the total number of ways to reach the bottom right point if you are currently at top left point i.e. from (1,1 to N,M). You can only move towards right or towards bottom
Input Format

First line contains T,the number of test cases. Then T lines follow each containing 2 integers N and M
Constraints

1<=T<=100
1<=N,M<=11
Output Format

Print T lines where i'th line corresponds to the total number of ways possible in the i'th test case
Sample Input

2
3 3
2 8

Sample Output

6
8
* */
public class NumberOfPaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tt = sc.nextInt();

        while (tt-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();

            int[][] mat = new int[n][m];

            System.out.println(solve(mat, n, m));
        }
    }

    private static int solve(int[][] mat, int n, int m) {

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < m; j++)
            dp[0][j] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[n - 1][m - 1];
    }
}
