package Template;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int shortestPathBinaryMatrix(List<List<Integer>> grid) {

        if (grid == null || grid.size() == 0)
            return -1;

        int n = grid.size(), m = grid.get(0).size();

        if (grid.get(0).get(0) == 1)
            return -1;

        boolean[][] visited = new boolean[n][m];

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}};

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0});

        visited[0][0] = true;

        int ans = 0;
        while (q.isEmpty() == false) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] corrd = q.poll();

                if (grid.get(corrd[0]).get(corrd[1]) == 9)
                    return ans + 1;

                for (int k = 0; k < 8; k++) {
                    int nextX = dir[k][0] + corrd[0];
                    int nextY = dir[k][1] + corrd[1];

                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && visited[nextX][nextY] == false && grid.get(nextX).get(nextY) == 0) {
                        q.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}