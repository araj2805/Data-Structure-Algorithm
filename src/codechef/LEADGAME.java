package codechef;

import java.util.Scanner;

public class LEADGAME {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int n = sc.nextInt();

            int lead = 0, winner = 0, x = 0, y = 0;
            while (n-- > 0) {
                int a = sc.nextInt(), b = sc.nextInt();
                x = x + a;
                y = y + b;
                if (x > y && x - y > lead) {
                    winner = 1;
                    lead = x - y;

                } else if (y > x && y - x > lead) {
                    winner = 2;
                    lead = y - x;
                }

            }

            System.out.println(winner + " " + lead);
        }
    }
}
