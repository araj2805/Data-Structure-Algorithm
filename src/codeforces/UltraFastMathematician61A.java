package codeforces;

import java.util.Scanner;

public class UltraFastMathematician61A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next(), b = sc.next(), ans = "";

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                ans += "1";
            else
                ans += "0";
        }

        System.out.println(ans);
    }
}
