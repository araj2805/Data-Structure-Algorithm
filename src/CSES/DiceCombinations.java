package CSES;

import java.util.Scanner;

public class DiceCombinations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(noOfWays(n));

    }

    private static int noOfWays(int n) {

        int[] dp = new int[n + 1];

        // Base Case
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) { // Filling Dp States
            for (int k = 1; k <= 6; k++) { // Throwing Dice Value
                if (k > i) continue;
                dp[i] = (dp[i] % 1000000007 + dp[i - k] % 1000000007) % 1000000007;
            }
        }

        /*for(int i = 0; i <= 6 ; i++) {
            for(int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }*/

        return (dp[n]) % 1000000007;
    }
}
