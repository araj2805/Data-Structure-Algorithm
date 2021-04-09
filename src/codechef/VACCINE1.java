package codechef;

import java.util.Scanner;

public class VACCINE1 {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int d1 = sc.nextInt(), v1 = sc.nextInt(), d2 = sc.nextInt(), v2 = sc.nextInt(), p = sc.nextInt();

            int count = 0;

            if (d2 != 1 && d1 > d2)
                count += d2 - 1;
            else if (d1 != 1 && d2 > d1)
                count += d1 - 1;
            else if (d1 == d2)
                count += d1 - 1;

            while (p > 0) {
                if (d1 < d2) {
                    int prod = v1;
                    p = p - v1;
                    count++;
                    d1++;

                } else if (d2 < d1) {
                    int prod = v2;
                    p = p - v2;
                    count++;
                    d2++;
                } else if (d1 == d2) {
                    int prod = v1 + v2;
                    p = p - prod;
                    count++;
//                    d1++;
//                    d2++;

                }
            }

            System.out.println(count);
        }
    }
}
