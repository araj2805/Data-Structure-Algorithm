package codechef;

import java.util.Scanner;

public class ANITGUY9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int tt = sc.nextInt();

            while (tt-- > 0) {
                int n = sc.nextInt();
                long temp = n, sum = 0;
                while (temp > 0) {
                    sum += temp % 10;
                    temp = temp / 10;
                }

                System.out.println(n % sum == 0 ? "YES" : "NO");
            }
        }
    }
}
