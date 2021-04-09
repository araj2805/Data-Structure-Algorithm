package codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class CanceltheTrains1453A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long tt = sc.nextLong();

        while (tt-- > 0) {
            long n = sc.nextLong(), m = sc.nextLong();
            long[] arr1 = new long[(int) n];
            long[] arr2 = new long[(int) m];

            for (int i = 0; i < n; i++)
                arr1[i] = sc.nextLong();
            for (int i = 0; i < m; i++)
                arr2[i] = sc.nextLong();

            int res = 0;
            for (int i = 0; i < n; i++) {
                long val = arr1[i];

                int index = Arrays.binarySearch(arr2, val);

                if (index >= 0)
                    res++;
            }
            System.out.println(res);
        }
    }
}
