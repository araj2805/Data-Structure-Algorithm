package dp;

import java.util.Scanner;

public class ShottingGame {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int tt = sc.nextInt();
        while (tt-- > 0) {
            int x = sc.nextInt(), y = sc.nextInt(), n = sc.nextInt(), w = sc.nextInt(), P1 = sc.nextInt(), P2 = sc.nextInt();

            double p1 = P1 * 0.01, p2 = P2 * 0.01;

            double[][] dp = new double[n + 1][w + 1];

            for (int i = 0; i <= n; i++)
                dp[i][0] = 1;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= w; j++) {
                    dp[i][j] = Math.max((p1 * dp[i - 1][Math.max(j - x, 0)] + (1 - p1) * dp[i - 1][j]), (p2 * dp[i - 1][Math.max(j - y, 0)] + (1 - p2) * (dp[i - 1][j])));
                }
            }

            System.out.printf("%.6f\n", dp[n][w] * 100);

        }

    }
}
