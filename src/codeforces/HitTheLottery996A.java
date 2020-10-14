package codeforces;

import java.util.Scanner;

public class HitTheLottery996A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count = 0;

        while (n != 0) {
            if (n >= 100) {
                count++;
                n = n - 100;
            } else if (n >= 20) {
                count++;
                n -= 20;
            } else if (n >= 10) {
                count++;
                n -= 10;
            } else if (n >= 5) {
                count++;
                n -= 5;
            } else if (n >= 1) {
                count++;
                n -= 1;
            }
        }

        System.out.println(count);

    }
}
