package dp;

/*
 * We are given a ribbon of length ‘n’ and a set of possible ribbon lengths. Now we need to cut the ribbon into the maximum number of pieces that comply with the above-mentioned possible lengths. Write a method that will return the count of pieces.
 * */
public class MaximumRibbonCut {
    public static void main(String[] args) {
        int[] ribbonLengths = {2, 3, 5};
        System.out.println(countRibbonPieces(ribbonLengths, 5));
        ribbonLengths = new int[]{2, 3};
        System.out.println(countRibbonPieces(ribbonLengths, 7));
        ribbonLengths = new int[]{5, 3, 7};
        System.out.println(countRibbonPieces(ribbonLengths, 13));
        ribbonLengths = new int[]{3, 5};
        System.out.println(countRibbonPieces(ribbonLengths, 7));
    }

    private static int countRibbonPieces(int[] ribbonLengths, int sum) {
        int[] dp = new int[sum + 1];
        return solveCountRibbon(dp, ribbonLengths, sum);
    }

    private static int solveCountRibbon(int[] dp, int[] ribbonLengths, int sum) {

        if (sum == 0)
            return 0;
        if (sum < 0)
            return -1;

        if (dp[sum] != 0)
            return dp[sum];

        int max = Integer.MIN_VALUE;
        for (int ribbon : ribbonLengths) {
            int res = solveCountRibbon(dp, ribbonLengths, sum - ribbon);

            if (res >= 0 && max < res)
                max = res + 1;
        }

        dp[sum] = max == Integer.MIN_VALUE ? -1 : max;

        return dp[sum];

    }

}
