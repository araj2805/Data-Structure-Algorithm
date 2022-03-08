package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {
    public static void main(String[] args) {

        System.out.println(nextPermutation(new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 5, 2, 7, 6}))));
        System.out.println(nextPermutation(new ArrayList<Integer>(Arrays.asList(new Integer[]{251, 844, 767, 778, 658, 337, 10, 252, 632, 262, 707, 506, 701, 475, 410, 696, 631, 903, 516, 149, 344, 101, 42, 891, 991}))));

    }

    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> nums) {

        int n = nums.size() - 1;

        int index = n - 1;

        while (index >= 0 && nums.get(index) >= nums.get(index + 1))
            index--;

        if (index < 0)
            reverse(nums, 0, n);
        else {
            int i = n;
            for (; i > index; i--) {
                if (nums.get(i) > nums.get(index))
                    break;
            }

            Collections.swap(nums, i, index);

            reverse(nums, index + 1, n);
        }

        return nums;
    }

    public static void reverse(ArrayList<Integer> nums, int i, int j) {

        while (i <= j) {
            Collections.swap(nums, i, j);
            i++;
            j--;
        }
    }
}
