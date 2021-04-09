package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ADACRA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String str = br.readLine();

            int u = 0, d = 0;

            for (int i = 0; i < str.length(); i++) {
                if (i == 0 && str.charAt(i) == 'U')
                    u = 1;
                else if (i == 0 && str.charAt(i) == 'D')
                    d = 1;

                if (i > 0 && str.charAt(i) != str.charAt(i - 1)) {
                    if (str.charAt(i) == 'U')
                        u++;
                    else
                        d++;
                }
            }

            System.out.println(Math.min(d, u));
        }
    }
}
