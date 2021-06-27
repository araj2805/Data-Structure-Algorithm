package unacademy.dp;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//https://www.codechef.com/UADPIP01/problems/GOODSTR
public class GoodSubsequences {
    public static long mod = (long) (1e9 + 7);

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(in, out);
        out.close();
    }

    public static void solve(InputReader sc, PrintWriter pw) {

        int t = sc.nextInt();

        while (t-- > 0) {

            String s = sc.next();

            int regex = 3;
            long[][] dp = new long[s.length()][regex];

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                for (int j = 0; j < 3; j++) {

                    if (i > 0)
                        dp[i][j] = dp[i - 1][j];
                }
                dp[i][ch - 'a'] = multiply(dp[i][ch - 'a'], 2, mod);

                if (ch == 'a') {
                    dp[i][ch - 'a']++;
                    dp[i][ch - 'a'] %= mod;
                } else if (i > 0) {
                    dp[i][ch - 'a'] = add(dp[i][ch - 'a'], dp[i][ch - 'a' - 1], mod);
                }


            }
            pw.println(dp[s.length() - 1][regex - 1]);
        }


    }

    static long add(long a, long b, long m) {
        return (((a % m) + (b % m)) % m);
    }

    static long subtract(long a, long b, long m) {
        return (((a % m) - (b % m) + m) % m);
    }

    static long multiply(long a, long b, long mod) {
        return (((a % mod) * (b % mod)) % mod);
    }

    static long divide(long a, long b, long m) {
        long temp = modInverse(b, m);
        return multiply(a, temp, m);
    }


    static String reverse(String s) {
        return (new StringBuilder(s)).reverse().toString();
    }

    static void inputArray(int[] nums, int n, InputReader sc) {
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
    }

    static void sieveOfEratosthenes(int n, int factors[]) {
        factors[1] = 1;
        for (int p = 2; p * p <= n; p++) {
            if (factors[p] == 0) {
                factors[p] = p;
                for (int i = p * p; i <= n; i += p)
                    factors[i] = p;
            }
        }
    }

    static void sort(int ar[]) {
        int n = ar.length;
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++)
            a.add(ar[i]);
        Collections.sort(a);
        for (int i = 0; i < n; i++)
            ar[i] = a.get(i);
    }

    static void sort1(long ar[]) {
        int n = ar.length;
        ArrayList<Long> a = new ArrayList<>();
        for (int i = 0; i < n; i++)
            a.add(ar[i]);
        Collections.sort(a);
        for (int i = 0; i < n; i++)
            ar[i] = a.get(i);
    }

    static long ncr(long n, long r, long mod) {
        if (r == 0)
            return 1;
        long val = ncr(n - 1, r - 1, mod);
        val = (n * val) % mod;
        val = (val * modInverse(r, mod)) % mod;
        return val;
    }


    static long lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    static boolean isPrime(long n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        return true;
    }

    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static long fast_pow(long base, long n, long M) {
        if (n == 0)
            return 1;
        if (n == 1)
            return base % M;
        long halfn = fast_pow(base, n / 2, M);
        if (n % 2 == 0)
            return (halfn * halfn) % M;
        else
            return (((halfn * halfn) % M) * base) % M;
    }

    static long modInverse(long n, long M) {
        return fast_pow(n, M - 2, M);
    }

    static class Pair1 {
        long a;
        long b;

        Pair1(long a, long b) {
            this.a = a;
            this.b = b;
        }
    }

    static class Pair implements Comparable<Pair> {
        int a;
        int b;
        // int i;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
            // this.i = i;
        }

        public int compareTo(Pair p) {
            if (a != p.a)
                return a - p.a;
            return b - p.b;
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
