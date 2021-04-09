package CSES;

import java.util.Arrays;
import java.util.Scanner;

public class MinimizingCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), x = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++)
            coins[i] = sc.nextInt();

        System.out.println(minCoins(coins, n, x));
    }

    private static int minCoins(int[] coins, int n, int x) {

        int[] dp = new int[x + 1];

        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= n; j++) {
                if (i - coins[j - 1] >= 0)
                    dp[i] = Math.min(dp[i], dp[i - coins[j - 1]] + 1);
            }
        }


        return dp[x] == Integer.MAX_VALUE - 1 ? -1 : dp[x];
    }
}
