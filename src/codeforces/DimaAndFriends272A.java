package codeforces;

import java.util.Scanner;

public class DimaAndFriends272A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), sum = 0, c = 0;
        for (int i = 0; i < n; i++)
            sum += sc.nextInt();

        for (int i = 1; i <= 5; i++) {
            if ((sum + i) % (n + 1) != 1)
                c++;
        }

        System.out.println(c);
    }
}
