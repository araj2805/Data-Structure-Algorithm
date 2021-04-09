package Template;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Template3 {
    static class FastReader {

        BufferedReader br;
        StringTokenizer st;


        /*
         *  I/O Template
         * */

        public FastReader() throws IOException {
            br = new BufferedReader(new InputStreamReader(System.in));
            br.read();
        }

        public static void main(String[] args) throws IOException {
            FastReader sc = new FastReader();
            int tt = sc.nextInt();
            if (tt-- > 0) {
                int n = sc.nextInt();
                System.out.println(solve(n));
            }

        }

        private static long solve(int n) {
            long mod = 1000000009;

            long[] dp = new long[1000001];

            dp[0] = 0;
            dp[1] = 0;
            dp[2] = 1;
            dp[3] = 1;

            for (int i = 4; i <= 1000000; i++)
                dp[i] = (dp[i - 2] + dp[i - 3]) % mod;

            return dp[n] % mod;
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}

