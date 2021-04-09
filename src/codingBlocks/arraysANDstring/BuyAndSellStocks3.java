package codingBlocks.arraysANDstring;

import java.util.Scanner;

/*
*
*  THIS WILL APPLY FOR K TRANSACTIONS ALSO.

Given an array of stock prices, your task is to find the max profit you can make by buying and selling at most two time, that is transactions can be made <=2 times. Also the transactions shouldn't overlap, i.e. you can buy second stock only after selling the first stock.
Input Format

First line contains the number of elements N in the array. Second line contains N elements denoting the price of the stock on i'th day.
Constraints

N<=100000
Output Format

Print on a single line the
Sample Input

8
3 3 5 0 0 3 1 4

Sample Output

6

Explanation

Buy on 4th day and sell on 6th day, profit = 3-0 =3
Buy on 6th day and sell on 8th day, profit = 4-1 =3
There for total profit =3+3 =6

* */
public class BuyAndSellStocks3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        System.out.println(maxProfit(nums));
    }

    private static int maxProfit(int[] prices) {

        int[][] profits = new int[3][prices.length];

        for (int t = 1; t < 3; t++) {
            int max = Integer.MIN_VALUE;

            for (int d = 1; d < prices.length; d++) {
                max = Math.max(max, profits[t - 1][d - 1] - prices[d - 1]);

                profits[t][d] = Math.max(profits[t][d - 1], max + prices[d]);
            }
        }

        return profits[2][prices.length - 1];
    }

}
