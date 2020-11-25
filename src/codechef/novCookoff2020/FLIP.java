package codechef.novCookoff2020;

import java.util.Scanner;

public class FLIP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int t = sc.nextInt();

            while (t-- > 0) {
                char[] a = sc.next().toCharArray(), b = sc.next().toCharArray();
                int n = a.length;

                int count = 0;

                for (int i = 0; i < n; i++) {
                    if (a[i] == b[i])
                        continue;

                    int j = i;

                    while (j < n && a[j] != b[j]) {
                        a[j] = b[j];
                        j += 2;
                    }

                    count++;
                }

                System.out.println(count);

            }
        }
    }
}
