package codechef.novCookoff2020;

import java.util.Scanner;

public class IPCCERT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
            int eligible = 0;
            while (n-- > 0) {
                int watchTime = 0, q = 0;
                ;
                for (int i = 0; i <= k; i++) {
                    if (i < k) {
                        watchTime += sc.nextInt();
                    } else if (i == k)
                        q = sc.nextInt();

                }
                if (watchTime >= m && q <= 10)
                    eligible++;
            }

            System.out.println(eligible);
        }

    }
}
