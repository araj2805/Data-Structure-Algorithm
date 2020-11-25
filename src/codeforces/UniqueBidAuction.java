package codeforces;

import java.util.Scanner;

public class UniqueBidAuction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long t = sc.nextLong();
        while (t-- > 0) {
            long n = sc.nextLong();
            int[] arr = new int[(int) n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            int winner = -1, min = Integer.MAX_VALUE;

            int[] map = new int[(int) n + 1];

            for (int i = 0; i < n; i++) {
                map[arr[i]]++;
            }

            for (int i = 0; i < n; i++) {
                if ((map[arr[i]] == 1) && min > arr[i]) {
                    min = arr[i];
                    winner = i + 1;
                }
            }

            System.out.println(winner);

        }
    }
}
