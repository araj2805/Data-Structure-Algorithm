package CSES;

import java.util.Scanner;

public class CoinCombinationsII {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(), x = sc.nextLong();
        long[] coins = new long[(int) n];

        for (int i = 0; i < n; i++)
            coins[i] = sc.nextLong();

        System.out.println(noOfWays(coins, n, x));
    }


    private static long noOfWays(long[] coins, long n, long sum) {

        long[][] dp = new long[(int) n + 1][(int) sum + 1];


        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (long i = 1; i <= n; i++) {
            for (long j = 1; j <= sum; j++) {

                dp[(int) i][(int) j] = dp[(int) (i - 1)][(int) j] % 1000000007;

                if (coins[(int) (i - 1)] <= j) {
                    dp[(int) i][(int) j] = (dp[(int) i][(int) (j - coins[(int) (i - 1)])] % 1000000007 + dp[(int) (i - 1)][(int) j] % 1000000007) % 1000000007;
                }


            }
        }


        return dp[(int) n][(int) sum] % 1000000007;
    }
}
