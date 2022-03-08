package Revision;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetSum {

    public static void main(String[] args) {


        System.out.println(solve(new ArrayList<Integer>(Arrays.asList(new Integer[]{3, 34, 4, 12, 5, 2})), 9));
    }

    public static int solve(ArrayList<Integer> nums, int sum) {

        boolean[][] dp = new boolean[nums.size() + 1][sum + 1];

        for (int j = 0; j <= sum; j++)
            dp[0][j] = false;
        for (int i = 0; i <= nums.size(); i++)
            dp[i][0] = true;

        for (int i = 1; i < nums.size() + 1; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= nums.get(i - 1)) {
                    dp[i][j] = dp[i - 1][j - nums.get(i - 1)] || dp[i - 1][j];
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }


        return dp[nums.size()][sum] ? 1 : 0;
    }
}
