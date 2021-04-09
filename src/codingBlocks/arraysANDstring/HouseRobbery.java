package codingBlocks.arraysANDstring;

import java.util.Scanner;

/*
*

A professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping him from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money he can rob tonight without alerting the police.
Input Format

First line contains integer t as number of testcases. Second line contains integer n as size of array. Third line contains a single integer as element of array.
Constraints

None
Output Format

Print the maximum money as output.
Sample Input

1
4
1 2 3 1

Sample Output

4
* */
public class HouseRobbery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tt = sc.nextInt();

        while (tt-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];

            for (int i = 0; i < n; i++)
                nums[i] = sc.nextInt();

            System.out.println(solve(nums));
        }
    }

    private static int solve(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n + 1];

        dp[1] = nums[0];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[n];
    }
}
