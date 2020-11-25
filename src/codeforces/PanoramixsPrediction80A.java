package codeforces;

import java.util.Scanner;

public class PanoramixsPrediction80A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();

        for (int i = n + 1; i <= m; i++) {
            if (isPrime(i)) {
                System.out.println(i == m ? "YES" : "NO");
                return;
            }
        }
        System.out.println("NO");
    }

    private static boolean isPrime(int n) {

        if (n <= 1)
            return false;
        else if (n == 2)
            return true;
        else if (n % 2 == 0)
            return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;


    }
}
