package Revision;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {

        System.out.println(increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
    }

    public static boolean increasingTriplet(int[] nums) {


        int[] leftMin = new int[nums.length];
        int[] rightMax = new int[nums.length];

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            leftMin[i] = min;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            max = Math.max(max, nums[i]);
            rightMax[i] = max;
        }


        for (int i = 0; i < nums.length; i++) {
            if (leftMin[i] < nums[i] && nums[i] < rightMax[i])
                return true;
        }

        return false;
    }
}
