package codeforces;

import java.util.Scanner;

public class BearAndBigBrother791A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt(), b = sc.nextInt();

        int count = 0;

        if (l == b) {
            System.out.println(1);
            return;
        }

        while (l <= b) {
            l = l * 3;
            b = b * 2;
            count++;
        }

        System.out.println(count);
    }
}
