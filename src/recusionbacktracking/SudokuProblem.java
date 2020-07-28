package recusionbacktracking;

public class SudokuProblem {
    public static void main(String[] args) {

        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        sudoku(board, board.length);
    }

    private static boolean sudoku(int[][] board, int n) {

        // considering any of the cell is empty
        boolean isEmpty = true;
        int row = -1, col = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    // co ordinates of cell which is presently empty
                    row = i;
                    col = j;

                    // Now we attempt to fill the empty cell so mark it false
                    isEmpty = false;
                    break;
                }
            }

            // we have found a empty ecll and now we are attempting to fill that cell.
            if (isEmpty == false)
                break;
        }

        /*
         *  BASE CONDITION :
         * This means while checking the board  there is not empty cell so all the cell are filled.
         * */
        if (isEmpty == true) {

            printBoard(board);
            return true;
        }

        /*
         *  Now for the particular empty cell we are trying to fill number from 1 to 9 . So we'll try for wit each number and find
         *  weather the particular number make sudoku safe or not. If safe the proceed with next blank cell or else we';; continue same
         *  process with different number between 1 to 9
         * */
        for (int i = 1; i <= n; i++) {
            if (isSafe(board, row, col, i) == true) {
                // If safe then we'll fix the element and proceed with next recursion step
                board[row][col] = i;

                if (sudoku(board, n) == true)
                    return true;

                board[row][col] = 0;

            }

        }

        return false;

    }

    private static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    private static boolean isSafe(int[][] board, int row, int col, int value) {

        // Checking for the value in current row if already there then return false
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == value)
                return false;
        }

        // Checking for the value in current column and if already there the return false
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == value)
                return false;
        }

        // Now checking for the sub matrix

        int offset = (int) Math.sqrt(board.length);

        int rowStart = row - row % offset;
        int colStart = col - col % offset;

        for (int i = rowStart; i < rowStart + offset; i++) {
            for (int j = colStart; j < colStart + offset; j++) {
                if (board[i][j] == value)
                    return false;
            }
        }


        return true;
    }
}
