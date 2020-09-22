package codeforces;

import java.util.Scanner;

public class NewYearAndHurry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();


        int sum = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            sum += i * 5;

            if (k + sum <= 240) {
                count++;
            } else
                break;
        }

        System.out.print(count);
    }
}
