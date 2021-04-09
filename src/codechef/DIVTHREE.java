package codechef;

import java.util.Scanner;

public class DIVTHREE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int tt = sc.nextInt();

            while (tt-- > 0) {
                long n = sc.nextLong(), k = sc.nextLong(), d = sc.nextLong();

                long sum = 0;
                for (int i = 0; i < n; i++)
                    sum += sc.nextLong();

                long possibility = sum / k;

                System.out.println(possibility >= d ? d : possibility);
            }
        }
    }
}
