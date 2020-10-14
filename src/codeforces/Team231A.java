package codeforces;

import java.util.Scanner;

public class Team231A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] grid = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++)
                grid[i][j] = scanner.nextInt();
        }
        int res = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 1)
                    count++;
            }
            if (count >= 2)
                res++;

        }
        System.out.println(res);
    }
}
