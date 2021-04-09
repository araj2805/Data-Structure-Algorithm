package codeforces;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class EvenOddGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            Integer[] nums = new Integer[n];

            for (int i = 0; i < n; i++)
                nums[i] = sc.nextInt();

            Arrays.sort(nums, Collections.reverseOrder());

            long count = 0;

            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    if (nums[i] % 2 == 0) {
                        count += nums[i];
                    }
                } else {
                    if (nums[i] % 2 != 0)
                        count -= nums[i];
                }
            }

            if (count == 0)
                System.out.println("Tie");
            else if (count > 0)
                System.out.println("Alice");
            else
                System.out.println("Bob");
        }
    }
}
