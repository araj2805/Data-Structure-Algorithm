package unacademy.TreesAndGraph.TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopoSortKhanAlgo {
    public static void main(String[] args) {

        Graph graph = new Graph(8);

        graph.addEdge(0, 3);
        graph.addEdge(0, 1);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        graph.addEdge(2, 1);
        graph.addEdge(4, 1);
        graph.addEdge(2, 4);
        graph.addEdge(7, 1);
        graph.addEdge(7, 5);

//        graph.printGraph();

        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        g.printGraph();

        List<Integer> topOrder = topological_sort_kahn(g);

        topOrder.stream().forEach(integer -> System.out.print(integer + " "));
    }

    private static List<Integer> topological_sort_kahn(Graph graph) {

        List<Integer> result = new ArrayList<>();

        int[] inDegree = new int[graph.nodes];

        // Calculate inDegree for every Node
        for (int i = 0; i < graph.nodes; i++) {
            for (int neighbour : graph.adjList.get(i)) {
                inDegree[neighbour]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.nodes];

        for (int i = 0; i < graph.nodes; i++)
            if (inDegree[i] == 0) {
                queue.offer(i);
                visited[i] = true;
            }


        while (queue.isEmpty() == false) {

            int node = queue.poll();
            result.add(node);

            for (int neighbourVertex : graph.adjList.get(node)) {
                if (visited[neighbourVertex] == false) {

                    inDegree[neighbourVertex]--;

                    if (inDegree[neighbourVertex] == 0) {
                        queue.offer(neighbourVertex);
                        visited[neighbourVertex] = true;
                    }

                }
            }

        }

        return result;
    }

    public static class Graph {

        int nodes;
        List<List<Integer>> adjList;

        public Graph(int nodes) {
            this.nodes = nodes;
            this.adjList = new ArrayList<>(nodes);

            for (int i = 0; i < nodes; i++)
                adjList.add(new ArrayList<>());

        }

        void addEdge(int node1, int node2) {
            adjList.get(node1).add(node2);
        }

        void printGraph() {
            for (int i = 0; i < nodes; i++) {
                System.out.println(i + " => " + adjList.get(i));
            }
        }
    }

}
