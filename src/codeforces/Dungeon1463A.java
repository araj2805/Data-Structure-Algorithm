package codeforces;

import java.util.Scanner;

public class Dungeon1463A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long tt = sc.nextLong();

        while (tt-- > 0) {

            long a = sc.nextLong(), b = sc.nextLong(), c = sc.nextLong();

            System.out.println(check(a, b, c) == true ? "YES" : "NO");
        }
    }

    private static boolean check(long a, long b, long c) {

        if (a == 0 || b == 0 || c == 0)
            return false;
        long ans = 0;

        ans += (a - 1) + (b - 1) + (c - 1);

        if (ans != 0 && ans % 6 == 0)
            return true;

        return false;
    }
}
