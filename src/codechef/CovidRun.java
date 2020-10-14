package codechef;

import java.util.Scanner;

//Problem Code: CVDRUN
public class CovidRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = 0;
        if (scanner.hasNextInt())
            t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int step = scanner.nextInt();
            int start = scanner.nextInt();
            int location = scanner.nextInt();

            System.out.println(isSafe(n, step, start, location) == false ? "NO" : "YES");
        }

        scanner.close();
    }

    private static boolean isSafe(int n, int step, int start, int location) {

        int i = start, c = 0;

        while (c == 0) {
            if (i == location)
                return true;
            i = (i + step) % n;

            if (i == start)
                c = 1;
        }

        return false;
    }
}
