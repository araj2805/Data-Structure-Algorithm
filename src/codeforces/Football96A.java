package codeforces;

import java.util.Scanner;

public class Football96A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int zero = 1, one = 1;
        boolean flag = false;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i) && s.charAt(i) == '0') {
                one = 0;
                zero++;
            } else if (s.charAt(i - 1) == s.charAt(i) && s.charAt(i) == '1') {

                zero = 0;
                one++;
            } else {
                zero = 1;
                one = 1;
            }


            if (one == 7 || zero == 7) {
                flag = true;
                break;
            }

        }

        if (flag == true)
            System.out.println("YES");
        else
            System.out.println("NO");


    }
}