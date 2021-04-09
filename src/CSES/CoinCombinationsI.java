package CSES;

import java.util.Scanner;

public class CoinCombinationsI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt(), x = sc.nextInt();
        long[] coins = new long[(int) n];

        for (int i = 0; i < n; i++)
            coins[i] = sc.nextLong();

        System.out.println(noOfWays(coins, n, x));
    }

    private static long noOfWays(long[] coins, long n, long x) {

        long[] dp = new long[(int) (x + 1)];

        dp[0] = 1;

        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] > i)
                    continue;
                dp[i] = (dp[i] + dp[(int) (i - coins[j])]) % 1000000007;
            }
        }


        return dp[(int) x] % 1000000007;
    }
}
