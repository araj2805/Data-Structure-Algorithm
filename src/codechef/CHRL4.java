package codechef;
/*
Wrong Answer
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CHRL4 {
    public static void main(String[] args) throws IOException {

        long mod = (long) (1e9 + 7);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().trim().split(" ");

        int n = Integer.parseInt(token[0]), k = Integer.parseInt(token[1]);

        String[] tok1 = br.readLine().trim().split(" ");
        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(tok1[i]);


        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (i - j <= k && i - j >= 1) {
                    dp[i] = Math.min(dp[i], dp[j] * nums[i]);
                }
            }
        }

        System.out.println(dp[n - 1] % mod);

    }
}
