package dp;

/*
 * Given a stair with ‘n’ steps, implement a method to count how many possible ways are there to reach the top of the staircase, given that, at every step you can either take 1 step, 2 steps, or 3 steps.
 * */
public class Staircase {
    public static void main(String[] args) {
        System.out.println(step(4));
        System.out.println(step(5));
        System.out.println(step(6));
    }

    private static int step(int n) {

        int[] dp = new int[n + 1];

        return countWays(n, dp);
    }

    private static int countWays(int n, int[] dp) {

        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        if (dp[n] != 0)
            return dp[n];
        dp[n] = countWays(n - 1, dp) + countWays(n - 2, dp) + countWays(n - 3, dp);

        return dp[n];
    }

}
