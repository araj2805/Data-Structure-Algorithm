/*
package Algorithm;

public class MaximumSubArraySum {

    public static int maxCrosingSubarray (int[] nums , int low , int mid , int high)
    {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0,i = 0;

        while (low <= mid)
        {
            sum += nums[mid--];
            if(sum > leftSum)
            {
                leftSum = sum;
            }
        }

        sum = 0;

        int rightSum = Integer.MAX_VALUE;
        mid = mid + 1;

        while(mid <= high)
        {
            sum += nums[mid++];
            if(sum > rightSum)
            {
                rightSum = sum;
            }
        }

        return leftSum + rightSum;
    }

    public static int maxSubArray(int[] nums , int low , int high)
    {

        if(low == high)
            return nums[low];

        int mid = ((low + high)/2);

        return ( Math.max(maxCrosingSubarray(nums , low , high),Math.max(maxCrosingSubarray(nums , low , mid) , maxCrosingSubarray(nums , mid+1 , high))));
    }

    public static int maxSubArray(int[] nums) {

        return maxSubArray(nums,0,nums.length-1);

    }

    
}
*/
