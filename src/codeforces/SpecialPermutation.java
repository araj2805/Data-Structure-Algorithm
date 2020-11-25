package codeforces;

import java.util.Scanner;

public class SpecialPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] arr = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                arr[i] = i;
            }


            if (n % 2 != 0) {
                for (int i = 2; i < n; i += 2) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
                int temp = arr[1];
                arr[1] = arr[n];
                arr[n] = temp;

                for (int i = 1; i <= n; i++) {
                    System.out.print(arr[i] + " ");
                }
            } else {
                for (int i = 1; i <= n; i += 2) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }

                for (int i = 1; i <= n; i++) {
                    System.out.print(arr[i] + " ");
                }
            }


            System.out.println();
        }
    }
}
