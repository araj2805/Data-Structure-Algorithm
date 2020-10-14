package codeforces;

/*
import java.util.Scanner;

public class IWannaBeTheGuy469A {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int p = sc.nextInt();

        int[] xLevel = new int[p];

        for (int i = 0; i < p; i++)
            xLevel[i] = sc.nextInt();

        int q = sc.nextInt();

        int[] yLevel = new int[q];

        for (int i = 0; i < q; i++)
            yLevel[i] = sc.nextInt();

        System.out.println(isReachable(n, p, xLevel, q, yLevel) == true ? "I become the guy." : "Oh, my keyboard!");
    }

    private static boolean isReachable(int n, int p, int[] xLevel, int q, int[] yLevel) {
        

        return false;
    }
}
*/

import java.util.Scanner;

class C {
    public static void main(String[] A) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), a = 0, x, r[] = new int[n];
        for (; a++ < 2; ) for (x = s.nextInt(); x-- > 0; ) if (r[s.nextInt() - 1]++ < 1) n--;
        System.out.print(n > 0 ? "Oh, my keyboard!" : "I become the guy.");
    }
}
