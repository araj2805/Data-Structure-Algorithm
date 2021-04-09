package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ACBALL {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String x = br.readLine().trim();
            String y = br.readLine().trim();

            StringBuilder z = new StringBuilder();

            int n = x.length();

            for (int i = 0; i < n; i++) {

                if (x.charAt(i) == y.charAt(i)) {
                    if (x.charAt(i) == 'W')
                        z.append("B");
                    else
                        z.append("W");
                } else {
                    z.append("B");
                }
            }

            System.out.println(z);

        }
    }
}
