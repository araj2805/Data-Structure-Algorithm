package interviewbit;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AddOneToNumber {

    public static void main(String[] args) {
//        System.out.println(plusOne(new ArrayList<>(Arrays.asList(new Integer[]{1, 1, 0}))));
//        System.out.println(plusOne(new ArrayList<>(Arrays.asList(new Integer[]{9, 9, 9}))));
//        System.out.println(plusOne(new ArrayList<>(Arrays.asList(new Integer[]{0, 0, 1}))));


        List<Integer> res = Arrays.asList(new Integer[]{1, 1, 0});
        List<Integer> res1 = Arrays.asList(new Integer[]{1, 2, 3});

        Arrays.stream(plusOne(res1.stream().mapToInt(value -> value).toArray())).forEach(val -> System.out.print(val + " "));

    }

    public static ArrayList<Integer> plusOne(ArrayList<Integer> nums) {

        int i = 0, carry = 1;

        while (i < nums.size() && nums.get(i) == 0)
            nums.remove(i);

        for (i = nums.size() - 1; i >= 0; i--) {
            int sum = nums.get(i) + carry;
            nums.set(i, sum % 10);
            carry = sum / 10;

            if (carry == 0)
                break;
        }

        if (carry != 0)
            nums.add(0, carry);

        return nums;
    }

    public static int[] plusOne(int[] nums) {

        int carry = 1;

        List<Integer> res = new ArrayList<Integer>(Arrays.stream(nums).boxed().collect(Collectors.toList()));

        for (int i = nums.length - 1; i >= 0; i--) {

            int sum = nums[i] + carry;
            res.set(i, sum % 10);
            carry = sum / 10;

            if (carry == 0)
                break;
        }

        if (carry != 0)
            res.add(0, carry);

        int j = 0;

        while (j < res.size() && res.get(j) == 0)
            res.remove(j);

        return res.stream().mapToInt(value -> value).toArray();

    }

}
