package codechef;

import java.util.Scanner;

public class EVENPSUM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int tt = sc.nextInt();

            while (tt-- > 0) {
                long a = sc.nextLong(), b = sc.nextLong(), count = 0, i = 1, j = 1;

                long e1 = 0, e2 = 0, o1 = 0, o2 = 0;

                if (a % 2 == 0) {
                    e1 = a / 2;
                    o1 = a / 2;
                } else {
                    e1 = a / 2;
                    o1 = (a / 2) + 1;
                }

                if (b % 2 == 0) {
                    e2 = b / 2;
                    o2 = b / 2;
                } else {
                    e2 = b / 2;
                    o2 = (b / 2) + 1;
                }

                System.out.println((long) (e1 * e2 + o1 * o2));

                long var = Integer.MAX_VALUE;

                System.out.println((long) (var * var));
            }
        }
    }
}
