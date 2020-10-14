package codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class HelpfulMaths339A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        String[] arr = str.split("\\+");

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        for (String s : arr) {
            sb.append(s + "+");
        }

        str = sb.toString().substring(0, sb.toString().length() - 1);

        System.out.println(str);
    }
}
