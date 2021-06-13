package unacademy.TreesAndGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class GraphBipartite {

//    https://leetcode.com/problems/is-graph-bipartite/
}

class Solution {
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        Map<Integer, String> visited = new HashMap<>();

        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            if (visited.containsKey(i))
                continue;

            Pair pair = new Pair(i, "r");
            q.offer(pair);

            while (q.isEmpty() == false) {
                Pair currPair = q.poll();

                if (visited.containsKey(currPair.node)) {

                    String currColor = currPair.color;
                    String processColor = visited.get(currPair.node);

                    if (currColor.equals(processColor) == false)
                        return false;

                    continue;
                }

                visited.put(currPair.node, currPair.color);


                for (int nbr : graph[currPair.node]) {
                    if (visited.containsKey(nbr) == false) {
                        Pair pair1 = new Pair(nbr, currPair.color.equals("r") ? "g" : "r");
                        q.offer(pair1);
                    }
                }
            }
        }


        return true;
    }

    private class Pair {
        int node;
        String color;

        public Pair(int node, String color) {
            this.node = node;
            this.color = color;
        }
    }

}
