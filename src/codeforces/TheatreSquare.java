package codeforces;

import java.util.Scanner;

public class TheatreSquare {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        long n = scan.nextLong();
        long m = scan.nextLong();

        long a = scan.nextLong();

        System.out.println(((n + a - 1) / a) * ((m + a - 1) / a));

    }
}
