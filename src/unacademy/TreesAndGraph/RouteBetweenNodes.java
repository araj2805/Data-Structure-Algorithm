package unacademy.TreesAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RouteBetweenNodes {
    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        int u = 1, v = 3;

        System.out.println(isReachable(g, u, v));
    }

    private static boolean isReachable(Graph g, int source, int destination) {

        boolean[] visited = new boolean[g.nodes];

        Queue<Integer> q = new LinkedList<>();
        visited[source] = true;
        q.add(source);

        while (q.isEmpty() == false) {

            int node = q.poll();

            if (node == destination)
                return true;

            for (int neigh : g.adjList.get(node)) {
                if (visited[neigh] == false) {
                    q.add(neigh);
                    visited[neigh] = true;
                }
            }

        }

        return false;
    }

    static class Graph {
        int nodes;
        List<List<Integer>> adjList;

        public Graph(int nodes) {
            this.nodes = nodes;
            this.adjList = new ArrayList<>();

            for (int i = 0; i < nodes; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        void addEdge(int node1, int node2) {
            adjList.get(node1).add(node2);
        }
    }
}
