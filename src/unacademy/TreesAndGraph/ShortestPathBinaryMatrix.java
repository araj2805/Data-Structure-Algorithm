package unacademy.TreesAndGraph;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/shortest-path-in-binary-matrix/
public class ShortestPathBinaryMatrix {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println(new ShortestPathBinaryMatrix().shortestPathBinaryMatrix(grid));
    }


    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if (grid[0][0] != 0)
            return -1;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0, 1));

        int[] x = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] y = {0, 1, 1, 1, 0, -1, -1, -1};

        boolean[][] visited = new boolean[n][n];

        int step = 0;

        while (q.isEmpty() == false) {

            int size = q.size();


            for (int k = 0; k < size; k++) {

                Pair currPair = q.poll();

                if (currPair.x == n - 1 && currPair.y == n - 1) {
                    return step;
                }

                for (int i = 0; i < 8; i++) {

                    int xNew = currPair.x + x[i];
                    int yNew = currPair.y + y[i];

                    if (xNew >= 0 && xNew < n && yNew >= 0 && yNew < n && grid[xNew][yNew] == 0 && visited[xNew][yNew] == false) {
                        q.offer(new Pair(xNew, yNew, currPair.dist + 1));
                        visited[xNew][yNew] = true;
                    }

                }
            }
            step++;

        }

        return -1;
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
