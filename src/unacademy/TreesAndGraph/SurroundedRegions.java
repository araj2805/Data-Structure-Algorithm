package unacademy.TreesAndGraph;

public class SurroundedRegions {
    public void solve(char[][] board) {

        int n = board.length, m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = '-';
            }
        }

        for (int i = 0; i < n; i++)
            if (board[i][0] == '-')
                dfs(board, i, 0, '-', 'O');
        for (int i = 0; i < n; i++)
            if (board[i][m - 1] == '-')
                dfs(board, i, m - 1, '-', 'O');
        for (int j = 0; j < m; j++)
            if (board[0][j] == '-')
                dfs(board, 0, j, '-', 'O');
        for (int j = 0; j < m; j++)
            if (board[n - 1][j] == '-')
                dfs(board, n - 1, j, '-', 'O');

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '-')
                    board[i][j] = 'X';
            }
        }

    }

    private void dfs(char[][] grid, int row, int col, char prevChar, char newChar) {

        if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0)
            return;

        if (grid[row][col] != prevChar)
            return;

        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};

        grid[row][col] = newChar;

        for (int i = 0; i < 4; i++) {
            dfs(grid, row + x[i], col + y[i], prevChar, newChar);
        }

    }

}

