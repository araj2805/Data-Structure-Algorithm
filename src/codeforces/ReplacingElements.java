package codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class ReplacingElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        outer:
        while (t-- > 0) {
            int n = sc.nextInt(), d = sc.nextInt();

            int[] nums = new int[n];

            for (int i = 0; i < n; i++)
                nums[i] = sc.nextInt();
            Arrays.sort(nums);
            int first = nums[0], second = nums[1];

            for (int i = 0; i < n; i++) {
                if (nums[i] > d) {
                    if (first + second <= d)
                        nums[i] = first + second;
                }
            }

            int flag = 0;

            for (int i = 0; i < n; i++) {
                if (nums[i] > d)
                    flag = 1;
            }

            System.out.println(flag == 0 ? "YES" : "NO");
        }
    }
}
