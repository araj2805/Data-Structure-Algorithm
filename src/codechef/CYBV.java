package codechef;

import java.util.Scanner;

public class CYBV {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int tt = sc.nextInt();

            while (tt-- > 0) {
                int n = sc.nextInt(), k = sc.nextInt();

                System.out.println(k / n);
            }
        }
    }
}
