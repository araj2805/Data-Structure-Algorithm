package codechef.dp;

import java.util.Scanner;

public class SUBINC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int tt = sc.nextInt();

            while (tt-- > 0) {
                int n = sc.nextInt();
                int[] nums = new int[n];

                for (int i = 0; i < n; i++) {
                    nums[i] = sc.nextInt();
                }

                long count = 1;
                long[] dp = new long[n];
                dp[0] = 1;

                for (int i = 1; i < n; i++) {
                    if (nums[i - 1] <= nums[i]) {
                        dp[i] = dp[i - 1] + 1;
                    } else
                        dp[i] = 1;

                    count += dp[i];
                }

                System.out.println(count);
            }
        }


    }
}