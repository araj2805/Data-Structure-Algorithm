package codeforces;


import java.util.Scanner;

// 391A
public class GeneticEngineering {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int i = 0, j = 1;
        int n = str.length();

        int count = 1, res = 0;

        while (i < n && j < n && i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                count++;
                j++;
            } else {
                if (count % 2 == 0)
                    res++;
                count = 1;
                i = j;
                j++;
            }
        }

        if (count % 2 == 0)
            res++;

        System.out.print(res);
    }

}
