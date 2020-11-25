package codeforces;

import java.util.Scanner;

public class Elephant617A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), count = 0;

        while (n > 0) {
            if (n >= 5) {
                count++;
                n = n - 5;
            } else if (n >= 4) {
                count++;
                n = n - 4;
            } else if (n >= 3) {
                count++;
                n = n - 3;
            } else if (n >= 2) {
                count++;
                n = n - 2;
            } else if (n >= 1) {
                count++;
                n = n - 1;
            }

        }

        System.out.println(count);
    }
}
