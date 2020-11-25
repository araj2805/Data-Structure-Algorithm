package codeforces;

import java.util.Scanner;

public class WrongSubtraction977A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), k = sc.nextInt();

        int rem;
        while (k-- > 0) {
            rem = n % 10;

            if (rem != 0) {
                n -= 1;
            } else {
                n = n / 10;
            }
        }

        System.out.println(n);
    }
}
