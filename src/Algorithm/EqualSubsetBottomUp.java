package Algorithm;

public class EqualSubsetBottomUp {

    public static void main(String[] args) {
        EqualSubsetBottomUp ps = new EqualSubsetBottomUp();
        int[] num = {1, 5, 11, 5};
        System.out.println(ps.canPartition(num));
        /*num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));*/
    }

    public boolean canPartition(int[] nums) {

        int sum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++)
            sum += nums[i];


        // Base condition 0
        if (sum % 2 != 0)
            return false;

        sum = sum / 2;

        boolean[][] dp = new boolean[n][sum + 1];


        //Base COndition = 1
        for (int i = 0; i < n; i++)
            dp[i][0] = true;

        //Base COndition = 2
        for (int s = 1; s <= sum; s++)
            dp[0][s] = (nums[0] == s ? true : false);

        // Filling matrix
        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= sum; s++) {
                if (dp[i - 1][s])              //Not picking element at index i
                    dp[i][s] = dp[i - 1][s];
                else if (s >= nums[i])        // Picking element at index i
                    dp[i][s] = dp[i - 1][s - nums[i]];
            }
        }

        return dp[n - 1][sum];

    }
}
