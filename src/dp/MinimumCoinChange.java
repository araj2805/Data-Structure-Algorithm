package dp;

/*
 * Given an infinite supply of ‘n’ coin denominations and a total money amount, we are asked to find the minimum number of coins needed to make up that amount.
 * */
public class MinimumCoinChange {

    public static void main(String[] args) {

        int[] denominations = {1, 2, 3};
        System.out.println(countChange(denominations, 5));
        System.out.println(countChange(denominations, 11));
        System.out.println(countChange(denominations, 7));
        denominations = new int[]{3, 5};
        System.out.println(countChange(denominations, 7));

    }

    private static int countChange(int[] denominations, int sum) {
        int[] dp = new int[sum + 1];
        return solveCountChange(dp, denominations, sum);
    }

    private static int solveCountChange(int[] dp, int[] denominations, int sum) {

        if (sum < 0)
            return -1;
        if (sum == 0)
            return 0;

        if (dp[sum] != 0)
            return dp[sum];

        int min = Integer.MAX_VALUE;
        for (int coin : denominations) {
            int res = solveCountChange(dp, denominations, sum - coin);

            if (res >= 0 && min > res)
                min = res + 1;
        }

        dp[sum] = min == Integer.MAX_VALUE ? -1 : min;

        return dp[sum];

    }
}
