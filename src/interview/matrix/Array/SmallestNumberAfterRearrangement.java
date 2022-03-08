package interview.matrix.Array;

import java.util.Arrays;

public class SmallestNumberAfterRearrangement {
    public static void main(String[] args) {
        System.out.println(smallestNumber(new int[]{1, 2, 1, 12, 33, 211, 50}));
        System.out.println(smallestNumber(new int[]{0, 0, 0, 0, 0, 0, 0, 0}));
        System.out.println(smallestNumber(new int[]{0, 0, 0, 0, 1, 0, 0, 0}));
        System.out.println(smallestNumber(new int[]{0, 2, 0, 0, 10, 0, 5, 6}));
    }

    public static String smallestNumber(int[] nums) {

        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (a, b) -> (a + b).compareTo(b + a));

//        Edge case when array contains all zero
        if (arr[0].equals("0") && arr[arr.length - 1].equals("0"))
            return "0";

//        This is edge case when it's asked that ans should not start with zero
        /*int i = 0;
        while (arr[i].equals("0"))
            i++;

        String temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;*/

        StringBuilder sb = new StringBuilder();

        boolean hasNonZeroEncounter = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("0") == true && hasNonZeroEncounter == false) {
//                Do nothing as it's staring zeros and haven't encounter any non zero element.
            } else {
                hasNonZeroEncounter = true;
                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }

}
