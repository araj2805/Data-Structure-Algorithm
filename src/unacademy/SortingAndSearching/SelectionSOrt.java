package unacademy.SortingAndSearching;

import java.util.Arrays;

public class SelectionSOrt {

    public static void main(String[] args) {
        int[] nums = new int[]{21, 6, 9, 33, 9};
        int[] nums1 = new int[]{5, 2, 6, 7, 2, 1, 0, 3};

        selection_sort(nums1);

        Arrays.stream(nums1).forEach(value -> System.out.print(value + " "));
    }

    public static void selection_sort(int[] nums) {
        System.out.println("lenght " + nums.length);

        for (int k = 0; k < nums.length; k++) {
            int min_index = find_min_index(nums, k);

            int temp = nums[k];
            nums[k] = nums[min_index];
            nums[min_index] = temp;
        }
    }

    private static int find_min_index(int[] nums, int start) {

        int res = start;
        for (int i = start + 1; i < nums.length; i++) {
            if (nums[res] > nums[i])
                res = i;
        }

        return res;
    }
}
