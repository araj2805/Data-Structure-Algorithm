package Algorithm;

public class KnapsackTopDown {
    public static void main(String[] args) {
        KnapsackTopDown ks = new KnapsackTopDown();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }

    private int solveKnapsack(int[] profits, int[] weights, int capacity) {
        Integer[][] dp = new Integer[profits.length][capacity + 1];
        return this.solveKnapsackTopDown(dp, profits, weights, capacity, 0);
    }

    private int solveKnapsackTopDown(Integer[][] dp, int[] profits, int[] weights, int capacity, int currentIndex) {

        // Base Condition
        if (capacity <= 0 || currentIndex >= profits.length)
            return 0;

        // Checking if it is already exist or not
        if (dp[currentIndex][capacity] != null)
            return dp[currentIndex][capacity];

        int profit1 = 0;
        // Checking if present weight is greater than capacity
        if (weights[currentIndex] <= capacity)
            // taking currentIndex element and adding it's profit in profit
            profit1 = profits[currentIndex] + solveKnapsackTopDown(dp, profits, weights, capacity - weights[currentIndex], currentIndex + 1);


        int profit2 = solveKnapsackTopDown(dp, profits, weights, capacity, currentIndex + 1);

        // storing maximum profit for each currentIndex and capacity
        dp[currentIndex][capacity] = Math.max(profit1, profit2);

        return dp[currentIndex][capacity];

    }
}
