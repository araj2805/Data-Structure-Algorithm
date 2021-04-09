package codeforces;

import java.util.Scanner;

public class CardsforFriends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int w = sc.nextInt(), h = sc.nextInt(), n = sc.nextInt();

            int count = 1, pow = 1;

            while (w % 2 == 0 || h % 2 == 0) {
                if (w % 2 == 0) {
                    w = w / 2;
                    pow = pow * 2;
                } else if (h % 2 == 0) {
                    h = h / 2;
                    pow = pow * 2;
                }
            }


            System.out.println(pow >= n ? "YES" : "NO");
        }
    }
}
