package unacademy.TreesAndGraph.TopologicalSort;

import java.util.ArrayList;
import java.util.List;

public class AllTopologicalSortPrint {
    public static void main(String[] args) {

        Graph graph = new Graph(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        System.out.println("All TopoLogical Sort");

        List<List<Integer>> allTopo = getAllTopoSorts(graph);

        allTopo.forEach(System.out::println);
    }

    private static List<List<Integer>> getAllTopoSorts(Graph graph) {

        List<List<Integer>> result = new ArrayList<>();

        boolean[] visited = new boolean[graph.nodes];

        int[] indegree = new int[graph.nodes];

        for (int i = 0; i < graph.nodes; i++) {

            for (int neigh : graph.adjList.get(i))
                indegree[neigh]++;
        }

        List<Integer> ans = new ArrayList<>();

        allTopologicalSortUtil(visited, indegree, graph, ans, result);

        return result;
    }

    private static void allTopologicalSortUtil(boolean[] visited, int[] indegree, Graph graph, List<Integer> ans, List<List<Integer>> result) {

//        To indicate whether all topological are found or not
        boolean flag = false;

        for (int i = 0; i < graph.nodes; i++) {

            // If indegree is 0 and not yet visited then
            // only choose that vertex
            if (visited[i] == false && indegree[i] == 0) {

//                Select in result
                visited[i] = true;
                ans.add(i);

                for (int neigh : graph.adjList.get(i)) {
                    indegree[neigh]--;
                }
//              Explore all paths from selected vertex
                allTopologicalSortUtil(visited, indegree, graph, ans, result);

//              Backracking and unselecting the vertex
                visited[i] = false;
                ans.remove(ans.size() - 1);

                for (int neigh : graph.adjList.get(i)) {
                    indegree[neigh]++;
                }

                flag = true;

            }
        }

        if (flag == false)
            result.add(new ArrayList<>(ans));
    }

    public static class Graph {
        int nodes;
        List<List<Integer>> adjList;

        public Graph(int nodes) {
            this.nodes = nodes;
            this.adjList = new ArrayList<>();
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
