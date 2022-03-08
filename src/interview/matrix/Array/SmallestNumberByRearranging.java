package interview.matrix.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmallestNumberByRearranging {

    public static void main(String[] args) {
        SmallestNumberByRearranging s = new SmallestNumberByRearranging();

        System.out.println(s.minimum_number(846903));
    }

    public static int minimum_number(int num) {
        List<Integer> arr = new ArrayList<>();

        while (num > 0) {
            arr.add(num % 10);
            num = num / 10;
        }

        arr.sort((o1, o2) -> o1.compareTo(o2));

        int i = 0;

        while (arr.get(i) == 0) {
            i++;
        }

        Collections.swap(arr, 0, i);

        int sum = 0;

        for (Integer integer : arr) {
            sum = sum * 10 + integer;
        }

        return sum;
    }

}
