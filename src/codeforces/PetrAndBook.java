package codeforces;

import java.util.Scanner;

public class PetrAndBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] read = new int[7];

        for (int i = 0; i < 7; i++)
            read[i] = sc.nextInt();

        long sum = 0;
        int index = -1, i = 0;

        while (true) {
            sum += read[i % 7];
            if (sum >= n) {
                index = (i % 7) + 1;
                break;
            }
            i++;
        }

        System.out.println(index);
    }
}
