package Algorithm;

public class MinSubsetSumDiffBottomUp {
    public static void main(String[] args) {
        MinSubsetSumDiffBottomUp ps = new MinSubsetSumDiffBottomUp();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartition(num));
    }

    private int canPartition(int[] num) {

        int n = num.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += num[i];
        }

        Boolean[][] dp = new Boolean[n][sum / 2 + 1];

        // Let num be larger subset and s1 and s2 be subset of it

        // Base Condition - for sum = 0  every element can be done
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Base Condition
        for (int s = 1; s <= sum / 2; s++) {
            dp[0][s] = (s == num[0] ? true : false);
        }

        // Filling table - Bottom Up
        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= sum / 2; s++) {
                if (s >= num[i]) {
                    dp[i][s] = dp[i - 1][s - num[i]];
                } else {
                    dp[i][s] = dp[i - 1][s];
                }
            }
        }

        int sum1 = 0;
        // Find the largest index in the last row which is true i.e sum of s2
        for (int i = sum / 2; i >= 0; i--) {
            if (dp[n - 1][i] == true) {
                sum1 = i;
                break;
            }
        }
        // Finding sum of s1
        int sum2 = sum - sum1;
        // returning the minimum subset sum difference
        return Math.abs(sum2 - sum1);
    }
}
