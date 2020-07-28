package recusionbacktracking;

import java.util.Scanner;

public class Nqueens {
    public static void main(String[] args) {

        System.out.println("Enter number : ");
        Scanner scanner = new Scanner(System.in);

        Integer n = scanner.nextInt();

        boolean solveNqueens = solveNqueens(n);

    }

    private static boolean solveNqueens(Integer n) {

        int[][] board = new int[n][n];

        if (nQueenSolution(board, 0, board.length) == false) {
            System.out.println("Solution doesn't exist");
            return false;
        }
        return true;
    }

    private static void printBoard(int[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1)
                    System.out.print("Q ");
                else
                    System.out.print("_ ");
            }
            System.out.println();
        }
    }


    private static boolean nQueenSolution(int[][] board, int row, int n) {

        /*
         *   ROW = board.length;
         *   COL = col; (@Param)
         * */

        // Base condition
        if (n == row) {
            printBoard(board);
            System.out.println();
            return false;
        }

        // starting from this row and trying to place queen in all its all columns one by one : board[0].length = column size
        for (int i = 0; i < board[0].length; i++) {

            // Checking if the current position is safe for queen placement
            if (isSafe(board, row, i) == true) {
                // Setting that queen is placed as it's safe
                board[row][i] = 1;

                // Now checking for it's sub structure search space and it's automatically check for all search space and if it's giving solution make it into solution else discard and back track it.
                if (nQueenSolution(board, row + 1, n) == true) {
                    return true;
                }
                /* Back Track : it means for currently it's not possible solution so we make it to initial configuration If placing queen in board[i][col]
                                  doesn't lead to a solution then
                                  remove queen from board[i][col]*/
                board[row][i] = 0;

            }

        }
        /* If the queen can not be placed in any row in
           this colum col, then return false */
        return false;
    }

    /*
     * No checking if the current position is safe to place queen; Queen movement : upward, upwardRight, upwardLeft; Here we are not considering downward because we are filling row by row so no queen were present downside
     * */
    private static boolean isSafe(int[][] board, int row, int col) {

        int i = row;
        int j = col;

        // checking for upward direction
        for (i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }

        i = row;
        j = col;

        // checking for upward right direction
        while (i >= 0 && j <= board.length - 1) {
            if (board[i][j] == 1)
                return false;
            i--;
            j++;
        }

        i = row;
        j = col;

        // Checking for upward left direction
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1)
                return false;

            i--;
            j--;
        }


        return true;
    }

}
