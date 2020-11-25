package codeforces;

import java.util.Scanner;

public class Tram116A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int t = 0, c = 0;
        while (n-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt();
            c = c - a;
            t = Math.max(t, c);
            c = c + b;
            t = Math.max(t, c);
        }

        System.out.println(t);
    }
}
