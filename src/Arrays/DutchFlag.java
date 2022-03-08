package Arrays;

/*
 * Given an array A[] consisting 0s, 1s and 2s. The task is to write a function that sorts the given array. The functions should put all 0s first, then all 1s and all 2s in last.
 *
 * https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 * */
public class DutchFlag {

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};

        dutchFlag(nums);

        for (int i : nums)
            System.out.print(i + "  ");
    }

    private static void dutchFlag(int[] nums) {
        int low = -1, mid = 0, high = nums.length, n = nums.length;

        while (mid < n && low < mid && mid < high) {

            switch (nums[mid]) {
                case 0: {
                    low++;
                    swap(nums, low, mid);
                    mid++;
                    break;
                }
                case 1: {
                    mid++;
                    break;
                }

                case 2: {
                    high--;
                    swap(nums, mid, high);
                    break;
                }
            }
        }
    }

    private static void swap(int[] nums, int low, int mid) {
        int temp = nums[low];
        nums[low] = nums[mid];
        nums[mid] = temp;
    }
}
