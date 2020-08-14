package dp;

public class CoinChange {
    public static void main(String[] args) {
        int[] denominations = {1, 2, 3};
        int sum = 5;
        System.out.println(countChange(denominations, sum));

        /*
         * Bottom Up
         * */

        int[][] memo = new int[denominations.length + 1][sum + 1];

        // when sum is zero then one way to pick coin
        for (int i = 0; i <= denominations.length; i++)
            memo[i][0] = 1;

        for (int i = 1; i <= sum; i++)
            memo[0][i] = 0;


        for (int i = 1; i <= denominations.length; i++) {
            for (int j = 1; j <= sum; j++) {
                memo[i][j] = memo[i - 1][j];

                if (denominations[i - 1] <= j)
                    memo[i][j] += memo[i][j - denominations[i - 1]];
            }
        }

        System.out.println(memo[denominations.length][sum]);
    }

    private static int countChange(int[] denominations, int sum) {
        int[][] dp = new int[denominations.length + 1][sum + 1];
        return solveCountChange(dp, denominations, sum, denominations.length);
    }

    private static int solveCountChange(int[][] dp, int[] denominations, int sum, int n) {


        if (sum == 0)
            return 1;
        if (n == 0)
            return 0;

        if (dp[n][sum] != 0) {
//            System.out.println(dp[n][sum]);
            return dp[n][sum];
        }

        int res = solveCountChange(dp, denominations, sum, n - 1);

        if (sum >= denominations[n - 1])
            res += solveCountChange(dp, denominations, sum - denominations[n - 1], n);

        dp[n][sum] = res;
        return dp[n][sum];
    }

}
