package codeforces;

import java.util.Scanner;

public class GeorgeAndAccommodation467A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 0;
        while (n-- > 0) {
            int p = sc.nextInt();
            int q = sc.nextInt();

            if (q - p >= 2)
                count++;
        }

        System.out.println(count);
    }
}
