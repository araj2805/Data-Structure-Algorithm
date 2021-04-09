package codeforces;

import java.util.Scanner;

public class LongJumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];

            for (int i = 0; i < n; i++)
                nums[i] = sc.nextInt();
            int[] dp = new int[n];

            int res = 0;

            dp[n - 1] = nums[n - 1];

            for (int i = n - 2; i >= 0; i--) {

                dp[i] = nums[i] + (nums[i] + i >= n ? 0 : dp[nums[i] + i]);

                res = Math.max(res, dp[i]);
            }

            System.out.println(Math.max(res, dp[n - 1]));
        }
    }
}
