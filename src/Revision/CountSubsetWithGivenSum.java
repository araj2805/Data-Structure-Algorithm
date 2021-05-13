package Revision;

public class CountSubsetWithGivenSum {
    public static void main(String[] args) {
        System.out.println(countSubset(new int[]{2, 3, 5, 6, 8, 10}, 10));
    }

    private static int countSubset(int[] nums, int sum) {

        int[][] dp = new int[nums.length + 1][sum + 1];

//        SUm = 0 then there is one way to make subset that's not chossing any element
        for (int i = 0; i < nums.length + 1; i++)
            dp[i][0] = 1;

        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (j >= nums[i - 1])
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }

        }


        return dp[nums.length][sum];
    }

}
