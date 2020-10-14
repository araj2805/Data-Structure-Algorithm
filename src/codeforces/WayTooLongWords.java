package codeforces;

import java.util.Scanner;

// 71A
public class WayTooLongWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();

            if (s.length() <= 10)
                System.out.println(s);
            else {
                String res = String.valueOf(s.charAt(0) + "" + String.valueOf(s.length() - 2) + "" + s.charAt(s.length() - 1) + "");
                System.out.println(res);
            }
        }
    }
}
