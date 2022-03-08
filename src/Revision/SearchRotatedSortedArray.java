package Revision;

public class SearchRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public static int search(int[] nums, int target) {


        int low = 0, high = nums.length - 1;


        while (low < high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high])
                low = mid + 1;
            else
                high = mid;
        }


        int start = low;

        if (nums[start] <= target && nums[nums.length - 1] >= target) {
            low = start;
            high = nums.length - 1;
        } else {
            low = 0;
            high = start - 1;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return -1;
    }
}
