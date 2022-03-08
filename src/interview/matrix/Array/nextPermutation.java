package interview.matrix.Array;

import java.util.ArrayList;

public class nextPermutation {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> nextPermutation(ArrayList<Integer> nums) {

        if (nums.size() == 1)
            return nums;

        int i = nums.size() - 2;

        while (i >= 0 && nums.get(i) >= nums.get(i + 1)) {
            i--;
        }

        if (i < 0) {
            reverse(nums, 0, nums.size() - 1);
            return nums;
        }

        int j = i; // This denotes the first smallest number in after decreasing sequence, we need to increase it's value;

        i = nums.size() - 1;

        while (nums.get(j) > nums.get(i))
            i--;

        // Now we get the element which is just greater than jth element

        swap(nums, i, j);

        reverse(nums, j + 1, nums.size() - 1);
        return nums;
    }

    private void swap(ArrayList<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);

    }

    private void reverse(ArrayList<Integer> nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
