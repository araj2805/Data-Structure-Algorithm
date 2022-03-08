package unacademy.TreesAndGraph.TopologicalSort;

import unacademy.TreesAndGraph.Graph;

import java.util.HashMap;
import java.util.Map;

public class CycleDetectionUndirectedGraph {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");
        graph.addVertex("e");

        graph.addEdge("a", "b", 0);
        graph.addEdge("b", "c", 0);
        graph.addEdge("c", "a", 0);
        graph.addEdge("a", "d", 0);
        graph.addEdge("d", "e", 0);

        Map<String, Boolean> visited = new HashMap<>();

//        System.out.println(cycleDetection(graph));

    }

    /*private static boolean cycleDetection(Graph graph) {

        Map<String, Boolean> visited = new HashMap<>();

        for (String vertex : graph.nodes.keySet())
            if (visited.containsKey(vertex) == false)
                if (isCyclic(graph, vertex, visited, "+"))
                    return true;

        return false;
    }

    private static boolean isCyclic(Graph graph, String vertex, Map<String, Boolean> visited, String parent) {

        visited.put(vertex, true);

        for (String neighbourVertex : graph.nodes.get(vertex).neighbourVertex.keySet()) {
            if (visited.containsKey(neighbourVertex) == false) {
                if (isCyclic(graph, neighbourVertex, visited, vertex) == true)
                    return true;
            } else if (visited.containsKey(neighbourVertex) == true && parent.equals(neighbourVertex) == false) { // parent != neighbourVertex
                return true;
            }
        }

        return false;
    }*/
}
