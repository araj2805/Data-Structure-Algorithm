package Revision;

public class CountSubsetWithGivenDiff {
    public static void main(String[] args) {
        System.out.println(countSubset(new int[]{1, 1, 2, 3}, 1));
    }

    private static int countSubset(int[] nums, int diff) {

        int sum = 0;
        for (int i : nums)
            sum += i;

        sum = (diff + sum) / 2;
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++)
            dp[i][0] = 1;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (j >= nums[i - 1])
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }


        return dp[n][sum];
    }
}
