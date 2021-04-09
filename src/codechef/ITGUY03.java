package codechef;

import java.util.Scanner;

public class ITGUY03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int tt = sc.nextInt();
            while (tt-- > 0) {
                String n = String.valueOf(sc.nextInt());
                int flah = 0;
                for (int i = 0; i < n.length(); i++) {
                    if ((n.charAt(i) - '0') % 2 == 0) {
                        flah = 1;
                        break;
                    }
                }

                System.out.println(flah);
            }

        }
    }
}
