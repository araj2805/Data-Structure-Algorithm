package Algorithm;

public class SubSetBottomUp {
    public static void main(String[] args) {
        SubSetBottomUp ss = new SubSetBottomUp();
        int[] num = {1, 2, 3, 7};
        System.out.println(ss.canPartition(num, 6));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ss.canPartition(num, 10));
        num = new int[]{1, 3, 4, 8};
        System.out.println(ss.canPartition(num, 6));
    }

    private boolean canPartition(int[] num, int sum) {

        int n = num.length;
        boolean dp[][] = new boolean[n][sum + 1];

        // Base Condition
        for (int i = 0; i < n; i++)
            dp[i][0] = true;

        for (int s = 1; s <= sum; s++)
            dp[0][s] = (num[0] == s ? true : false);

        // Filling matrix
        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= sum; s++) {
                if (dp[i - 1][s])
                    dp[i][s] = dp[i - 1][s];
                else if (s >= num[i])
                    dp[i][s] = dp[i - 1][s - num[i]];
            }
        }

        return dp[n - 1][sum];
    }
}
