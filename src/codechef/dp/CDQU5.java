package codechef.dp;

import java.io.IOException;
import java.util.Scanner;

public class CDQU5 {

    /*
     *  Main Method : public static void main
     * */

    public static void main(String args[]) throws IOException {

        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int T = sc.nextInt();
            while (T-- > 0) {

                int n = sc.nextInt();
                System.out.println((String.valueOf(solve(n))));
            }
        }

    }

    private static long solve(int n) {
        long mod = 1000000009;

        long[] dp = new long[1000001];

        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= 1000000; i++)
            dp[i] = (dp[i - 2] + dp[i - 3]) % mod;

        return dp[n] % mod;
    }


}