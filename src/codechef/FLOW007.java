package codechef;

import java.util.Scanner;

public class FLOW007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();

                System.out.println(reverse(n));

            }
        }
    }

    private static int reverse(int n) {

        int res = 0;

        while (n > 0) {
            int rem = n % 10;
            res = res * 10 + rem;
            n = n / 10;
        }

        return res;
    }
}
