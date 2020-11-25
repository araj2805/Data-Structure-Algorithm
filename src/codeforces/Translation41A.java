package codeforces;

import java.util.Scanner;

public class Translation41A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next(), t = sc.next();

        if (s.length() != t.length()) {
            System.out.println("NO");
            return;
        }
        int i = 0, j = s.length() - 1;

        while (i >= 0 && i < s.length() && j < s.length() && j >= 0) {
            if (s.charAt(i) != t.charAt(j)) {
                System.out.println("NO");
                return;
            }

            i++;
            j--;
        }

        System.out.println("YES");
    }
}
