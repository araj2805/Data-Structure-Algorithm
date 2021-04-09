package codingBlocks.arraysANDstring;

import java.util.Scanner;

public class RegexMatching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next(), pattern = sc.next();

        System.out.println(solve(str, pattern) == true ? 1 : 0);
    }

    private static boolean solve(String str, String pattern) {

        boolean[][] dp = new boolean[str.length() + 1][pattern.length() + 1];

        int n = str.length(), m = pattern.length();
        dp[0][0] = true;

        for (int j = 1; j <= m; j++) {
            if (pattern.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 2];
            else
                dp[0][j] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (pattern.charAt(j - 2) == str.charAt(i - 1) || pattern.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else
                    dp[i][j] = false;
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print(dp[i][j] == true ? 1 + " " : 0 + " ");
            }
            System.out.println();
        }


        return dp[n][m];
    }
}
