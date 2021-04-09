package Sorting;

import java.util.Scanner;

public class ExploringRuins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] arr = sc.next().toCharArray();
        int n = arr.length;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != '?')
                continue;
            if ((i > 0 && arr[i - 1] == 'a') || (i + 1 < n && arr[i + 1] == 'a'))
                arr[i] = 'b';
            else
                arr[i] = 'a';


        }

        System.out.println(new String(arr));
    }
}
