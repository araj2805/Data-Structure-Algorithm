package codeforces;

import java.util.Scanner;

public class SupercentralPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] points = new int[n][2];

        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            boolean left = false, right = false, upper = false, lower = false;
            int x = points[i][0], y = points[i][1];
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;

                if (points[j][0] > x && points[j][1] == y)
                    right = true;
                if (points[j][0] < x && points[j][1] == y)
                    left = true;
                if (points[j][0] == x && points[j][1] < y)
                    lower = true;
                if (points[j][0] == x && points[j][1] > y)
                    upper = true;

            }
            if (left && right && lower && upper)
                ans++;
        }

        System.out.println(ans);

    }
}
