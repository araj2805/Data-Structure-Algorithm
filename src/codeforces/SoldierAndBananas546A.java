package codeforces;

import java.util.Scanner;

public class SoldierAndBananas546A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt(), n = sc.nextInt(), w = sc.nextInt();

        System.out.println((k * ((w * (w + 1)) / 2)) - n > 0 ? (k * ((w * (w + 1)) / 2)) - n : 0);
    }
}
