package interview.matrix.Array;

import java.util.Arrays;
import java.util.List;

public class LargestNumber {
    public static void main(String[] args) {
        LargestNumber lr = new LargestNumber();

        System.out.println(lr.largestNumber(Arrays.asList(3, 30, 34, 5, 9)));
    }

    public String largestNumber(final List<Integer> nums) {

        String[] arr = new String[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            arr[i] = String.valueOf(nums.get(i));
        }

        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        String str = "";

        for (String s : arr) {
            str += s;
        }


        return str;

    }
}
