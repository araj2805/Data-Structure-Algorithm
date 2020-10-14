package codeforces;

import java.util.Scanner;

public class WordCapitalization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] arr = sc.next().toCharArray();

        arr[0] = Character.toUpperCase(arr[0]);

        System.out.println(arr);

    }
}
