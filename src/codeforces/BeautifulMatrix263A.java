package codeforces;

import java.util.Scanner;

public class BeautifulMatrix263A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] grid = new int[5][5];
        int x = 0, y = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }

        System.out.println(solve(x, y));

    }

    private static int solve(int x, int y) {
        int res = 0;

        while (x < 5 && y < 5) {
            while (x < 2) {
                res++;
                x++;
            }
            if (x == 2 && y == 2)
                return res;
            while (y < 2) {
                res++;
                y++;
            }
            if (x == 2 && y == 2)
                return res;

            while (x > 2) {
                x--;
                res++;
            }
            if (x == 2 && y == 2)
                return res;
            while (y > 2) {
                y--;
                res++;
            }
            if (x == 2 && y == 2)
                return res;
        }


        return res;
    }
}
