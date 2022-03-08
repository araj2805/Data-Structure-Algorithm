package Revision;

public class EqualSUmPartition {

    public static void main(String[] args) {

    }

    static int equalPartition(int N, int nums[]) {
        int sum = 0;
        for (int i : nums)
            sum += i;

        if (sum % 2 != 0)
            return 0;

        sum = sum / 2;

        boolean[][] dp = new boolean[N + 1][sum + 1];

        for (int j = 0; j < sum + 1; j++)
            dp[0][j] = false;

        for (int i = 0; i <= N; i++)
            dp[i][0] = true;


        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[N][sum] ? 1 : 0;
    }
}
