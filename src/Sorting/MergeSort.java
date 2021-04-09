package Sorting;

// BestCase : O(nlogn) | WorstCase : O(nlogn)  Space : O(n)
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {5, 9, -1, 7, 6, -8};
        mergeSort_divide(nums, 0, nums.length - 1);

        for (int i : nums)
            System.out.print(i + " ");
    }

    public static void mergeSort_divide(int[] nums, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            mergeSort_divide(nums, low, mid);
            mergeSort_divide(nums, mid + 1, high);

            mergeSort_conquer(nums, low, mid, high);
        }
    }

    private static void mergeSort_conquer(int[] nums, int low, int mid, int high) {
        int[] temp = new int[low + high + 1];

        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[j++];
        }

        while (i <= mid)
            temp[k++] = nums[i++];

        while (j <= high)
            temp[k++] = nums[j++];
        int idx = 0;

        for (int p = low; p <= high; p++)
            nums[p] = temp[idx++];

    }
}
