package unacademy.TreesAndGraph.TopologicalSort;

import java.util.HashMap;
import java.util.Map;

public class CycleDetectionDirected {

    public static class Vertex {
        Map<Integer, Integer> neighbourVertex = new HashMap<>();
    }

    public static class DirectedGraph {
        Map<Integer, Vertex> nodes;

        public DirectedGraph() {
            this.nodes = new HashMap<>();
        }

        public static void main(String[] args) {

            DirectedGraph graph = new DirectedGraph();

            graph.addVertex(0);
            graph.addVertex(1);
            graph.addVertex(2);
            graph.addVertex(3);
            graph.addVertex(4);

            graph.addEdge(0, 1);
            graph.addEdge(0, 2);
            graph.addEdge(1, 2);
            graph.addEdge(2, 0);
            graph.addEdge(2, 3);
            graph.addEdge(3, 3);
            graph.addEdge(4, 4);

            graph.printGraph();

            System.out.println(cycleDetection(graph, graph.nodes.size()));
        }

        private static boolean cycleDetection(DirectedGraph graph, int V) {

            boolean[] visited = new boolean[V];

            for (int i = 0; i < V; i++) {

                visited[i] = true;

                for (int neighBourVertex : graph.nodes.get(i).neighbourVertex.keySet()) {
                    if (isCyclic(graph, neighBourVertex, visited))
                        return true;
                }
                visited[i] = false;
            }
            return false;
        }

        private static boolean isCyclic(DirectedGraph graph, int vertex, boolean[] visited) {

            if (visited[vertex] == true)
                return true;

            visited[vertex] = true;

            for (Integer neighnourVertex : graph.nodes.get(vertex).neighbourVertex.keySet()) {

                if (isCyclic(graph, neighnourVertex, visited) == true)
                    return true;
            }
            return false;
        }

        public void addVertex(Integer newVertex) {
            if (nodes.containsKey(newVertex))
                return;

            Vertex vertex = new Vertex();
            nodes.put(newVertex, vertex);
        }

        public void addEdge(Integer vertexA, Integer vertexB) {
            Vertex vertex1 = nodes.get(vertexA);
            Vertex vertex2 = nodes.get(vertexB);

            if (vertex1 == null || vertex2 == null || vertex1.neighbourVertex.containsKey(vertexB) == true)
                return;

            vertex1.neighbourVertex.put(vertexB, 0);
        }

        void printGraph() {
            for (Integer vertex : nodes.keySet()) {
                System.out.println(vertex + " => " + "{ " + nodes.get(vertex).neighbourVertex.keySet() + " }");
            }
        }
    }

}
