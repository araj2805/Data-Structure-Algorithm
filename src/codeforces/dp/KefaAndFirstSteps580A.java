package codeforces.dp;

import java.util.Scanner;

public class KefaAndFirstSteps580A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int count = 1, max = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] <= nums[i]) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
        }

        System.out.println(max);
    }
}
