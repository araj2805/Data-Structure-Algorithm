package unacademy.TreesAndGraph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int freshOranges = 0;
        Queue<Pair> q = new LinkedList<>();

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    freshOranges++;
                else if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }

        if (freshOranges == 0)
            return 0;

        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};

        int time = 0;

        while (q.isEmpty() == false && freshOranges > 0) {

            int size = q.size();

            for (int k = 0; k < size; k++) {

                Pair currPair = q.poll();

                for (int i = 0; i < 4; i++) {
                    int xNew = currPair.x + x[i];
                    int yNew = currPair.y + y[i];

                    if (xNew >= 0 && xNew < n && yNew >= 0 && yNew < m && visited[xNew][yNew] == false && grid[xNew][yNew] == 1) {
                        q.offer(new Pair(xNew, yNew));
                        visited[xNew][yNew] = true;
                        freshOranges--;
                    }
                }

            }
            time++;

        }

        return freshOranges == 0 ? time : -1;
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
