package unacademy.TreesAndGraph;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/find-shortest-distance-guard-bank/
public class WallsAndGates {
    public static void main(String[] args) {
        char[][] grid = {
                {'O', 'O', 'O', 'O', 'G'},
                {'O', 'W', 'W', 'O', 'O'},
                {'O', 'O', 'O', 'W', 'O'},
                {'G', 'W', 'W', 'W', 'O'},
                {'O', 'O', 'O', 'O', 'G'}
        };

        int[][] ans = new WallsAndGates().findDistance(grid);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

    }


    int[][] findDistance(char[][] grid) {

        int n = grid.length, m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();

        boolean[][] visited = new boolean[n][m];

        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'G') {
                    ans[i][j] = 0;
                    q.offer(new Pair(i, j));
                    visited[i][j] = true;
                } else if (grid[i][j] == 'W')
                    ans[i][j] = -1;
            }
        }


        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};

        int level = 0;

        while (q.isEmpty() == false) {
            int size = q.size();
            ;

            for (int k = 0; k < size; k++) {

                Pair currPair = q.poll();

                for (int i = 0; i < 4; i++) {
                    int xNew = currPair.x + x[i];
                    int yNew = currPair.y + y[i];

                    if (xNew >= 0 && xNew < n && yNew >= 0 && yNew < m && grid[xNew][yNew] == 'O' && visited[xNew][yNew] == false) {
                        ans[xNew][yNew] = level + 1;
                        q.offer(new Pair(xNew, yNew));
                        visited[xNew][yNew] = true;

                    }
                }

            }
            level++;
        }

        return ans;
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
