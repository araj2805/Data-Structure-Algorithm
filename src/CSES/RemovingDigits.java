package CSES;

import java.util.Arrays;
import java.util.Scanner;

public class RemovingDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(numberOfStep(n));
    }

    private static int numberOfStep(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (char c : String.valueOf(i).toCharArray()) {
                dp[i] = Math.min(dp[i], dp[i - (c - '0')] + 1);
            }
        }

        return dp[n];
    }
}
