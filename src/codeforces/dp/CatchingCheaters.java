package codeforces.dp;

import java.util.Scanner;

public class CatchingCheaters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();
        String a = sc.next(), b = sc.next();

        int[][] dp = new int[n + 1][m + 1];

        int ans = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 2, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - 1][j], dp[i][j - 1]) - 1);
                }

                ans = Math.max(ans, dp[i][j]);
            }
        }

        System.out.println(ans);
    }
}
