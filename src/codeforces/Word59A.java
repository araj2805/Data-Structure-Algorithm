package codeforces;

import java.util.Scanner;

public class Word59A {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int lowerCount = 0, capCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                lowerCount++;
            else
                capCount++;
        }

        if (lowerCount >= capCount)
            System.out.println(s.toLowerCase());
        else
            System.out.println(s.toUpperCase());
    }
}
