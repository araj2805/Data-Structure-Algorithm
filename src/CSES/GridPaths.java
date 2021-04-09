package CSES;

import java.util.Scanner;

public class GridPaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[][] arr = new char[n][n];

        double mod = 1e9 + 7;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().toCharArray();
        }

        int[][] grid = new int[n][n];

        if (arr[0][0] == '.')
            grid[0][0] = 1;

        for (int j = 1; j < n; j++) {
            if (arr[0][j] == '*') {
                grid[0][j] = 0;
            } else
                grid[0][j] = grid[0][j - 1];
        }

        for (int i = 1; i < n; i++) {
            if (arr[i][0] == '*') {
                grid[i][0] = 0;
            } else
                grid[i][0] = grid[i - 1][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == '*')
                    grid[i][j] = 0;
                else
                    grid[i][j] = (int) ((grid[i - 1][j] % mod + grid[i][j - 1] % mod) % mod);
            }
        }

        System.out.println(grid[n - 1][n - 1]);

    }
}
