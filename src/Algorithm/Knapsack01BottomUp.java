package Algorithm;

public class Knapsack01BottomUp {
    public static void main(String[] args) {
        Knapsack01BottomUp ks = new Knapsack01BottomUp();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
//        maxProfit = ks.solveKnapsack(profits, weights, 6);
//        System.out.println("Total knapsack profit ---> " + maxProfit);
    }

    private int solveKnapsack(int[] profits, int[] weights, int capacity) {

        // Base condition
        if (capacity <= 0 || profits.length == 0 || profits.length != weights.length)
            return 0;

        int n = profits.length;
        // intitalize dp array with default value 0
        int dp[][] = new int[n][capacity + 1];

        // BAse Condition when capacity = 0 then profit  = 0
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        //Base Condition when capacity >= 1st element then profit = profit of 1st element
        for (int c = 0; c <= capacity; c++) {
            if (c >= weights[0])
                dp[0][c] = profits[0];
        }

        // filling up dp table
        for (int i = 1; i < n; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0, profit2 = 0;

                // if element is  picking - inclusion
                if (weights[i] <= c) {

                    profit2 = dp[i - 1][c - weights[i]] + profits[i];
                }

                // if element is not picking - exclusion
                profit1 = dp[i - 1][c];

                // storing maxm profit for the same
                dp[i][c] = Math.max(profit1, profit2);
            }
        }

        return dp[n - 1][capacity];
    }
}
