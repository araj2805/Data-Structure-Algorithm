package Revision;

import java.util.Arrays;
import java.util.List;

/*
 * Idea is all about simple selection sort. At each step compare i with j i.e ij with ji and if ji > ij then swap i and j for each and every element
 *
 * */

public class LargestNumber {
    public static void main(String[] args) {
        System.out.println(largestNumber(Arrays.asList(new Integer[]{3, 30, 34, 5, 9})));
    }

    public static String largestNumber(final List<Integer> A) {

        String[] nums = new String[A.size()];

        for (int i = 0; i < A.size(); i++)
            nums[i] = String.valueOf(A.get(i));

        Arrays.sort(nums, (a, b) -> {
            return (b + a).compareTo(a + b);
        });

        if (nums[0].equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder();

        for (String s : nums)
            sb.append(s);

        return sb.toString();
    }
}
