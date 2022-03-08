package Arrays;

/*
 *
 * Move all negative numbers to beginning and positive to end with constant extra space
 * https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/
 * */


public class MoveNegative {
    public static void main(String[] args) {

//        int[] nums = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        int[] nums = {-12, 11, 13, -5, 6, -7, 5, -3, -6};

        moveNegative(nums);

        binSort(nums);

        for (int i : nums)
            System.out.print(i + "  ");

    }

    private static void binSort(int[] nums) {

        int i = -1;
        for (int j = 0; j < nums.length; j++) {

            if (nums[j] == 0) {
                i++;
                swap(nums, i, j);
            }

        }
    }

    private static void moveNegative(int[] nums) {
        int i = -1;

        for (int j = 0; j < nums.length; j++) {

            if (nums[j] < 0) {
                i++;
                swap(nums, i, j);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
