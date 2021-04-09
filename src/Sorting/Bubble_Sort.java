package Sorting;

// worst case : O(n^2) : Best case : O(n^2)
public class Bubble_Sort {
    public static void main(String[] args) {
        int[] nums = {5, 9, -1, 7, 6, -8};
        sort(nums);

        for (int i : nums)
            System.out.print(i + " ");
    }

    public static void sort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    // worst case : O(n^2) : Best case : O(n)
    public static void optimise_bubble_sort(int[] nums) {
        int n = nums.length;

        boolean isSwap = false;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    isSwap = true;
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            if (isSwap == false)
                break;
        }
    }
}
