package Sorting;

// worst case : O(n^2) : Best case : O(n)
public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {5, 9, -1, 7, 6, -8};
        sort(nums);

        for (int i : nums)
            System.out.print(i + " ");
    }

    public static void sort(int[] nums) {
        int n = nums.length;

//        Picking up element from unsorted region
        for (int i = 1; i < n; i++) {
//  storing element whcih need to be placed at it's correct position
            int key = nums[i];
//            intialistion of stating of sorted region
            int j = i - 1;

            while (j >= 0 && nums[j] > key) {
//                shifting the element to right in sorted region
                nums[j + 1] = nums[j];
                j--;
            }
//            placing element in correct position of sorted region
            nums[j + 1] = key;
        }
    }
}
