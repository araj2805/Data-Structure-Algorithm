package Algorithm;

public class CountOfSubsetSumBottomUp {

    public static void main(String[] args) {
        CountOfSubsetSumBottomUp ss = new CountOfSubsetSumBottomUp();
        int[] num = {1, 1, 2, 3};
        System.out.println(ss.countSubsets(num, 4));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ss.countSubsets(num, 9));
    }

    private Integer countSubsets(int[] num, int sum) {
        int n = num.length;
        Integer[][] dp = new Integer[n][sum + 1];

        // Base condition 1
        for (int index = 0; index < n; index++) {
            dp[index][0] = 1;
        }

        // Base Condititon 2
        for (int s = 1; s <= sum; s++) {
            dp[0][s] = (s == num[0] ? 1 : 0);
        }

        // Filling the dp table in bottom up manner

        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= sum; s++) {
                // excluding the element
                dp[i][s] = dp[i - 1][s];

                // including the element
                if (s >= num[i]) {
                    dp[i][s] += dp[i - 1][s - num[i]];
                }

//                dp[i][s] = sum1+sum2;
            }
        }

        return dp[n - 1][sum];
    }
}
