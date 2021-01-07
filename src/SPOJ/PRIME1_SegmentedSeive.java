package SPOJ;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PRIME1_SegmentedSeive {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);


        int tt = sc.nextInt();

        while (tt-- > 0) {
            long l = sc.nextLong(), r = sc.nextLong();

            boolean[] primesList = segmentedSieve(l, r);

            for (int i = 0; i < primesList.length; i++) {
                if (primesList[i] == true) {
                    System.out.println(l + i);
                }
            }
            System.out.println();
        }

    }

    private static boolean[] segmentedSieve(long l, long r) {

        long lim = (long) Math.sqrt(r);

        boolean[] mark = new boolean[(int) (lim + 1)];

        Arrays.fill(mark, true);

        List<Long> primes = new ArrayList<>();

        for (long i = 2; i * i <= r; i++) {
            if (mark[(int) i]) {
                primes.add(i);

                for (long j = i * i; j * j <= r; j += i) {
                    mark[(int) j] = false;
                }
            }
        }

        boolean[] isPrime = new boolean[(int) (r - l + 1)];
        Arrays.fill(isPrime, true);

        for (long i : primes) {
            for (long j = Math.max(i * i, (l + i - 1) / i * i); j <= r; j += i) {
                isPrime[(int) (j - l)] = false;
            }
        }

        if (l == 1)
            isPrime[0] = false;

        return isPrime;
    }

}

