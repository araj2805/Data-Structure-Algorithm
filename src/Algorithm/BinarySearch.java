package Algorithm;

import java.util.Scanner;

public class BinarySearch {

    public static int binarySearch(int[] a, int low, int high, int key) {
        if (low <= high) {
            int mid = (low + (high)) / 2;

            if (a[mid] == key)
                return 1;

            if (a[mid] > key)
                return binarySearch(a, low, mid - 1, key);
            if (a[mid] < key)
                return binarySearch(a, mid + 1, high, key);
        }


        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        while (test > 0) {
            test--;
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            System.out.println(binarySearch(a, 0, n - 1, k));
        }
    }
}
