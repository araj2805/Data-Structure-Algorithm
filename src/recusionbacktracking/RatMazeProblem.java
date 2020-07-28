package recusionbacktracking;

public class RatMazeProblem {
    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};
        int n = maze.length;
        ratMaze(maze, n);
    }

    private static boolean ratMaze(int[][] maze, int n) {

        int sol[][] = new int[n][n];

        boolean solveRatMaze = solveRatMaze(0, 0, maze, sol, n);
        if (solveRatMaze) {
            System.out.println("success");
        } else
            System.out.println("failed");
        return solveRatMaze;
    }

    private static boolean solveRatMaze(int x, int y, int[][] maze, int[][] sol, int n) {

        if (x == n - 1 && y == n - 1 && maze[n - 1][n - 1] == 1) {
            sol[n - 1][n - 1] = 1;
            printBoard(sol);
            return true;
        }

        if (isSafe(maze, x, y, n) == true) {

            sol[x][y] = 1;

            // checking for right side
            if (solveRatMaze(x + 1, y, maze, sol, n) == true)
                return true;
            // checking for down side
            if (solveRatMaze(x, y + 1, maze, sol, n) == true)
                return true;

            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    private static void printBoard(int[][] sol) {

        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol[0].length; j++)
                System.out.print(sol[i][j] + " ");
            System.out.println();
        }
    }

    private static boolean isSafe(int[][] maze, int x, int y, int n) {

        if (x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1)
            return true;
        return false;
    }
}
