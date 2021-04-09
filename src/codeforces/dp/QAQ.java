package codeforces.dp;

import java.util.Scanner;

public class QAQ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next(), b = "QAQ";

        int n = a.length(), ans = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (a.charAt(i) == 'Q' && a.charAt(j) == 'A' && a.charAt(k) == 'Q')
                        ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
