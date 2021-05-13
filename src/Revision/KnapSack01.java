package Revision;

public class KnapSack01 {
    static int knapSack(int W, int wt[], int val[], int n) {
        // your code here

        int[][] dp = new int[wt.length + 1][W + 1];


//        Intialization
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i == 0 || j == 0)
                    dp[i][j] = 0;


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {

                if (j >= wt[i - 1]) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else
                    dp[i][j] = dp[i - 1][j];

            }
        }


        return dp[n][W];
    }

}
