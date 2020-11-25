package codeforces;

import java.util.Scanner;

public class BuyTheString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt(), c0 = sc.nextInt(), c1 = sc.nextInt(), h = sc.nextInt();

            char[] sArray = sc.next().toCharArray();

            int coin = 0, minCoin = 0;

            coin = coinCal(sArray, n, c0, c1);

            minCoin = coin;

            if (c0 > c1 && c0 > h) {
                int offset = 0;
                for (int i = 0; i < n; i++) {
                    if (sArray[i] == '0') {
                        sArray[i] = '1';
                        offset += h;
                    }
                }

                coin = coinCal(sArray, n, c0, c1);

                minCoin = Math.min(minCoin, coin + offset);
            } else if (c1 > c0 && c1 > h) {
                int offset = 0;
                for (int i = 0; i < n; i++) {
                    if (sArray[i] == '1') {
                        sArray[i] = '0';
                        offset += h;
                    }
                }

                coin = coinCal(sArray, n, c0, c1);

                minCoin = Math.min(minCoin, coin + offset);
            }

            System.out.println(minCoin);

        }

    }

    private static int coinCal(char[] sArray, int n, int c0, int c1) {
        int coin = 0;
        for (int i = 0; i < n; i++) {
            if (sArray[i] == '0')
                coin += c0;
            else
                coin += c1;
        }

        return coin;
    }
}
