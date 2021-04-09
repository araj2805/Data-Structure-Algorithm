package Sorting;

// worst case : O(n^2) : Best case : O(n^2)
public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {5, 9, -1, 7, 6, -8};
        sort(nums);

        for (int i : nums)
            System.out.print(i + " ");
    }

    public static void sort(int[] nums) {
        int n = nums.length;

//        Moving element to the boundary end
        for (int i = 0; i < n - 1; i++) {
//            Store the first element index as first smallest element in  unsorted region
            int minElem_idx = i;
//            Searching minimum element in unsorted region
            for (int j = i + 1; j < n; j++) {
//                getting the smallest element index in unsorted region
                if (nums[j] < nums[minElem_idx]) {
                    minElem_idx = j;
                }
            }
//            Swap the minimum element whose index minElemm_idx with the first element in unsorted region i.e i
            int temp = nums[minElem_idx];
            nums[minElem_idx] = nums[i];
            nums[i] = temp;
        }
    }
}
