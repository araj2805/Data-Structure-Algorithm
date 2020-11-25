package codeforces;

import java.util.Scanner;

public class Borze32B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.')
                System.out.print("0");

            else if (i + 1 < s.length() && s.charAt(i) == '-' && s.charAt(i + 1) == '.') {
                System.out.print("1");
                i++;
            } else if (i + 1 < s.length() && s.charAt(i) == '-' && s.charAt(i + 1) == '-') {
                System.out.print("2");
                i++;
            }
        }
    }
}
