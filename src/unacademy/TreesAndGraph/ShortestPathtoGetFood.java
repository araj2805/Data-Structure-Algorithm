package unacademy.TreesAndGraph;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.ca/2021-03-13-1730-Shortest-Path-to-Get-Food/
public class ShortestPathtoGetFood {

    public static void main(String[] args) {
        char[][] grid1 = {

                {'X', 'X', 'X', 'X', 'X', 'X'}, {'X', '*', 'O', 'O', 'O', 'X'}, {'X', 'O', 'O', '#', 'O', 'X'}, {'X', 'X', 'X', 'X', 'X', 'X'}

        };

        char[][] grid2 = {

                {'X', 'X', 'X', 'X', 'X'}, {'X', '*', 'X', 'O', 'X'}, {'X', 'O', 'X', '#', 'X'}, {'X', 'X', 'X', 'X', 'X'}

        };

        char[][] grid3 = {

                {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}, {'X', '*', 'O', 'X', 'O', '#', 'O', 'X'}, {'X', 'O', 'O', 'X', 'O', 'O', 'X', 'X'}, {'X', 'O', 'O', 'O', 'O', '#', 'O', 'X'}, {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}

        };

        System.out.println(new ShortestPathtoGetFood().getFood(grid1));
        System.out.println(new ShortestPathtoGetFood().getFood(grid2));
        System.out.println(new ShortestPathtoGetFood().getFood(grid3));
    }


    public int getFood(char[][] grid) {

        int n = grid.length, m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '*') {
                    q.offer(new Pair(i, j));
                    visited[i][j] = true;
                    break;
                }
            }
        }

        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};

        int steps = 0;


        while (q.isEmpty() == false) {

            int size = q.size();

            for (int k = 0; k < size; k++) {
                Pair currPair = q.poll();

                if (grid[currPair.x][currPair.y] == '#')
                    return steps;

                for (int i = 0; i < 4; i++) {
                    int xNew = currPair.x + x[i];
                    int yNew = currPair.y + y[i];

                    if (xNew >= 0 && xNew < n && yNew >= 0 && yNew < m && grid[xNew][yNew] != 'X' && visited[xNew][yNew] == false) {
                        q.offer(new Pair(xNew, yNew));
                        visited[xNew][yNew] = true;
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    private class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
