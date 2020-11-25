package codeforces;

import java.util.Scanner;

public class BeautifulYear271A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        while (n <= 9011) {
            n++;

            if (Integer.toString(n).chars().distinct().count() == 4)
                break;
        }

        System.out.println(n);

    }
}
