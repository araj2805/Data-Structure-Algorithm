package Sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {5, 9, -1, 7, 6, -8};
        quickSort(nums, 0, nums.length - 1);

        for (int i : nums)
            System.out.print(i + " ");
    }

    //    So qucik sort happens in 3 step 1) chose pivot element and get it correct index in sorted array and then recursively call for both parts
    private static void quickSort(int[] nums, int low, int high) {

        if (low < high) {

            int correctIndex_pivot = quickSort_partition(nums, low, high);

            quickSort(nums, low, correctIndex_pivot - 1);
            quickSort(nums, correctIndex_pivot + 1, high);
        }
    }

    private static int quickSort_partition(int[] nums, int low, int high) {

        int pivot = nums[high];

        int i = low - 1, j = low;

        while (j < high && nums[j] < pivot) {
            i++;

            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;

            j++;
        }


        int temp = nums[i + 1];
        nums[i + 1] = nums[high];
        nums[high] = temp;


        return i + 1;
    }
}
