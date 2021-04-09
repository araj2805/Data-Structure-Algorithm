package mathematics;

import java.util.Arrays;
import java.util.Scanner;

public class SievePrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Range till prime number is needed : ");
        int n = sc.nextInt();
        boolean[] sievePrimeList = new boolean[(int) 1e6 + 1];

        Arrays.fill(sievePrimeList, true);
        solvePrime(n, sievePrimeList);

        for (int i = 0; i < n; i++) {
            if (sievePrimeList[i] == true) {
                System.out.print(i + " ");
            }
        }

    }

    private static void solvePrime(int n, boolean[] sievePrimeList) {
        sievePrimeList[0] = sievePrimeList[1] = false;

//        Marking all even number as non prime as they are not
        for (int i = 4; i <= 1e6; i = i + 2) {
            sievePrimeList[i] = false;
        }
//  Now checking for i and cancelling all its multiples.
        for (long i = 3; i * i <= 1e6; i = i + 2) {
            if (sievePrimeList[(int) i] == true) {
                for (long j = i * i; j <= 1e6; j = j + i)
                    sievePrimeList[(int) j] = false;
            }
        }

    }
}
