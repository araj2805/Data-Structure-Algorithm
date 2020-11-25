package codeforces;

import java.util.Scanner;

public class NonSubstringSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt(), q = sc.nextInt();
            String s = sc.next();

            while (q-- > 0) {
                int l = sc.nextInt(), h = sc.nextInt();

                l--;
                h--;

                boolean flag = false;

                for (int i = 0; i < l; i++) {
                    if (s.charAt(i) == s.charAt(l)) {
                        flag = true;
                    }
                }

                for (int i = h + 1; i < s.length(); i++) {
                    if (s.charAt(i) == s.charAt(h)) {
                        flag = true;
                    }
                }


                System.out.println(flag == true ? "YES" : "NO");
            }
        }
    }
}
