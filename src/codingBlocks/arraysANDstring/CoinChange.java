package codingBlocks.arraysANDstring;

import java.util.Scanner;

public class CoinChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int amount = sc.nextInt(), n = sc.nextInt();
        int[] coins = new int[n];

        for (int i = 0; i < n; i++)
            coins[i] = sc.nextInt();

        System.out.println(noOfWays(amount, coins, n));
    }

    private static int noOfWays(int amount, int[] coins, int n) {

        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i - 1])
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][amount];
    }
}
