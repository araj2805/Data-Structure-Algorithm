package codingBlocks.arraysANDstring;

import java.util.Scanner;

public class MaximumPathSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(), n = sc.nextInt();

        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        System.out.println(minimumPathSum(grid, m, n));


    }

    private static int minimumPathSum(int[][] grid, int m, int n) {

        for (int i = 1; i < m; i++)
            grid[i][0] += grid[i - 1][0];

        for (int j = 1; j < n; j++)
            grid[0][j] += grid[0][j - 1];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }
}
