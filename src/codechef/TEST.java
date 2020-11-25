package codechef;

import java.util.Scanner;

public class TEST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();

            if (n == 42)
                break;
            else
                System.out.println(n);
        }

    }
}
