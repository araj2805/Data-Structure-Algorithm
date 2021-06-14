package unacademy.TreesAndGraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {

    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length, m = mat[0].length;
        int[][] ans = new int[n][m];

        Queue<Pair> q = new LinkedList<>();

        Arrays.stream(ans).forEach(ints -> Arrays.fill(ints, Integer.MAX_VALUE));


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 0)
                    q.offer(new Pair(i, j, 0));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 0)
                    ans[i][j] = 0;
            }
        }

        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};

        while (q.isEmpty() == false) {

            Pair currPair = q.poll();

            for (int i = 0; i < 4; i++) {
                int xNew = currPair.x + x[i];
                int yNew = currPair.y + y[i];

                if (xNew >= 0 && xNew < n && yNew >= 0 && yNew < m && mat[xNew][yNew] == 1) {
                    if (ans[xNew][yNew] > ans[currPair.x][currPair.y] + 1) {
                        ans[xNew][yNew] = ans[currPair.x][currPair.y] + 1;
                        q.offer(new Pair(xNew, yNew, 1));
                    }
                }
            }
        }
        return ans;
    }

    private class Pair {
        int x;
        int y;
        int dist;

        public Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
