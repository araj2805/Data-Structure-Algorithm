package CSES;

import java.util.Scanner;

public class BookShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x = sc.nextInt();

        int[] prices = new int[n], pages = new int[n];

        for (int i = 0; i < n; i++)
            prices[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            pages[i] = sc.nextInt();

        System.out.println(maximumNumberOfPages(prices, pages, n, x));
    }

    private static int maximumNumberOfPages(int[] prices, int[] pages, int n, int amount) {

        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {

                // Book is not able tp\o be picked so not selecting it.
                dp[i][j] = dp[i - 1][j];

                if (prices[i - 1] <= j) // book can be able to either picked up or not
                {
                    dp[i][j] = Math.max(dp[i - 1][j], pages[i - 1] + dp[i - 1][j - prices[i - 1]]);
                }


            }
        }

        return dp[n][amount];
    }
}
