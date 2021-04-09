package codeforces;

import java.util.Scanner;

public class EffectiveApproach227B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int[] map = new int[n + 1];

        for (int i = 0; i < n; i++) {
            map[arr[i]] = i + 1;
        }

        int q = sc.nextInt();

        long ford = 0, bkd = 0;
        while (q-- > 0) {
            int b = sc.nextInt();

            ford += map[b];
            bkd += n - map[b] + 1;

        }
        System.out.println(ford + " " + bkd);
    }
}
