package codeforces;

import java.util.Scanner;

public class JzzhuChildren450A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        int[] nums = new int[n];


        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            nums[i] = (nums[i] + m - 1) / m;
        }

        int last = -1, MaxEle = Integer.MIN_VALUE;


        for (int i = 0; i < n; i++) {
            if (nums[i] >= MaxEle) {
                MaxEle = nums[i];
                last = i + 1;
            }
        }

        System.out.println(last);
    }
}
