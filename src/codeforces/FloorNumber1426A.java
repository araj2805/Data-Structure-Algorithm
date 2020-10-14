package codeforces;

import java.util.Scanner;

public class FloorNumber1426A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt(), x = sc.nextInt();

            int floor = ((n - 2) + x - 1) / x; // celing function for a /b = (a + b -1) / b;

            if (floor < 0)
                floor = 0;

            System.out.println(floor + 1);
        }
    }
}
