package codingBlocks.arraysANDstring;

import java.util.Scanner;

/*
*

Goku has been given n zeni(currency of toki toki city) with values c1, c2, c3 …. cn, and a target amount S. He has been given two symbols - and + . For each zeni, he has to choose one from + and - as its new symbol. He has to find out number of ways he can make sum of zeni equal to S. If he is able to find the answer correctly, he will be given tasty food for free.
Now goku is a big foodie but is not good at problem solving, so he wants your help.
Input Format

First line contains two integers n and target, i.e number of zeni and target amount, next line contains n integers depicting the value of each ith zeni.
Constraints

0 < n <= 20, where n is the size of array.
Sum of elements in given array will not exceed 1000.
The output is guaranteed to fit in 32 bit integer.
Output Format

A single integer denoting the number of ways to make target amount.
Sample Input

5 3
1 1 1 1 1

Sample Output

5

Explanation

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
There are 5 ways to assign symbols to make the sum of zeni be target 3.

* */
public class TargetSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), target = sc.nextInt(), sum = 0;
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }

        System.out.println(targetSumWays(nums, (target + sum) / 2, n));
    }

    private static int targetSumWays(int[] nums, int target, int n) {

        int[][] dp = new int[n + 1][target + 1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        /*for (int i = 0; i <= n; i++){

            for(int j = 0; j <= target; j++){
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }*/


        return dp[n][target];
    }
}
