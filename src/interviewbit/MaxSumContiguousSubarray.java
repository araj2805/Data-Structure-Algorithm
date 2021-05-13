package interviewbit;

import java.util.List;

public class MaxSumContiguousSubarray {
    public static void main(String[] args) {

    }

    public static int maxSubArray(final List<Integer> nums) {

        int maxSoFar = nums.get(0);
        int maxOverall = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            maxSoFar = Math.max(maxSoFar + nums.get(i), nums.get(i));
            maxOverall = Math.max(maxOverall, maxSoFar);
        }

        return maxOverall;
    }
}
