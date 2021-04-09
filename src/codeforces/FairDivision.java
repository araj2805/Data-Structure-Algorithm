package codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class FairDivision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int alice = 0, bob = 0;
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            Arrays.sort(a);

            for (int i = n - 1; i >= 0; i--) {
                int ele = a[i];
                if (alice > bob) {
                    bob += ele;
                } else {
                    alice += ele;
                }
            }


            if (alice == bob)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
