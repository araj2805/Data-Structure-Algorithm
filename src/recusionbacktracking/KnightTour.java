package recusionbacktracking;

public class KnightTour {

    public static void main(String[] args) {
        boolean solveKnightTour = solveKnightTour(8);
        if (solveKnightTour)
            System.out.println("Success");
        else
            System.out.println("Fail");
    }

    private static boolean solveKnightTour(int n) {
        int[][] sol = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                sol[i][j] = -1;

        int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

        sol[0][0] = 0;

        return knightTourSolution(0, 0, 1, sol, xMove, yMove, n);

    }

    private static boolean knightTourSolution(int x, int y, int move, int[][] sol, int[] xMove, int[] yMove, int n) {

        if (move == n * n) {
            printBoard(sol);
            return true;
        }

        int next_x, next_y;

        for (int i = 0; i < 8; i++) {
            next_x = x + xMove[i];
            next_y = y + yMove[i];

            if (isSafe(sol, next_x, next_y, n) == true) {
                sol[next_x][next_y] = move;

                if (knightTourSolution(next_x, next_y, move + 1, sol, xMove, yMove, n) == true)
                    return true;

                sol[next_x][next_y] = -1;
            }
        }

        return false;
    }

    private static void printBoard(int[][] sol) {
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol[0].length; j++)
                System.out.print(sol[i][j] + " _ ");
            System.out.println();
        }
    }

    private static boolean isSafe(int[][] sol, int next_x, int next_y, int n) {

        if (next_x >= 0 && next_x < n && next_y >= 0 && next_y < n && sol[next_x][next_y] == -1)
            return true;

        return false;
    }
}
