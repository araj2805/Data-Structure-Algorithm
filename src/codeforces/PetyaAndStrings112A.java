package codeforces;

import java.util.Scanner;

public class PetyaAndStrings112A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.next().toLowerCase();
        String b = scanner.next().toLowerCase();

        System.out.println(compareString(a, b));
    }

    private static int compareString(String a, String b) {

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) > b.charAt(i))
                return 1;
            else if (a.charAt(i) < b.charAt(i))
                return -1;
        }

        return 0;
    }
}
