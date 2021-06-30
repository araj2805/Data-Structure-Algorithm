package unacademy.TreesAndGraph.TopologicalSort;

import java.util.*;

public class ShortestPathinDirectedAcyclicGraph {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Graph g = new Graph();

//        n -> number of nodes. m = no of edges

        /*
        *
        Input :
            6 9
            0 1 5
            0 2 3
            1 3 6
            1 2 2
            2 4 4
            2 5 2
            2 3 7
            3 4 -1
            4 5 -2
        * */

        int n = sc.nextInt(), m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            g.addVertex(i);
        }

        while (m-- > 0) {
            int x = sc.nextInt(), y = sc.nextInt(), cost = sc.nextInt();
            g.addEdge(x, y, cost);
        }

        int source = sc.nextInt();

        g.printGraph();

        List<Integer> res = getShortestPathDAG(g, source, n);

        res.stream().forEach(a -> System.out.print(a + " "));
    }

    private static List<Integer> getShortestPathDAG(Graph graph, int source, int V) {

        List<Integer> res = new ArrayList<>(V);

        List<Integer> topoOrder = getTopoOrder(graph, V);

        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[source] = 0;

        for (int vertex : topoOrder) {

            if (dist[vertex] != Integer.MAX_VALUE) {
                for (int neighbourNode : graph.nodes.get(vertex).neighbourVertex.keySet()) {
                    if (dist[neighbourNode] > dist[vertex] + graph.nodes.get(vertex).neighbourVertex.get(neighbourNode))
                        dist[neighbourNode] = dist[vertex] + graph.nodes.get(vertex).neighbourVertex.get(neighbourNode);
                }
            }


        }


        Arrays.stream(dist).forEach(value -> res.add(value));
        return res;
    }

    private static List<Integer> getTopoOrder(Graph graph, int v) {

        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[v];
        int[] inDegree = new int[v];

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < v; i++) {
            for (int neiogh : graph.nodes.get(i).neighbourVertex.keySet()) {
                inDegree[neiogh]++;
            }
        }

        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
                visited[i] = true;
            }
        }


        while (q.isEmpty() == false) {
            int node = q.poll();
            res.add(node);

            for (int neigh : graph.nodes.get(node).neighbourVertex.keySet()) {
                if (visited[neigh] == false) {
                    inDegree[neigh]--;

                    if (inDegree[neigh] == 0) {
                        q.add(neigh);
                        visited[neigh] = true;
                    }
                }
            }

        }
        return res;
    }

    public static class Graph {

        Map<Integer, Vertex> nodes;

        public Graph() {
            this.nodes = new HashMap<>();
        }

        void addVertex(int vertex) {
            if (nodes.containsKey(vertex))
                return;
            nodes.put(vertex, new Vertex());
        }

        void addEdge(int node1, int node2, int cost) {
            Vertex vertex1 = nodes.get(node1);
            Vertex vertex2 = nodes.get(node2);

            if (vertex1 == null || vertex2 == null || vertex1.neighbourVertex.containsKey(node2) || vertex2.neighbourVertex.containsKey(node1))
                return;

            vertex1.neighbourVertex.put(node2, cost);
        }

        void printGraph() {
            nodes.keySet().stream().forEach(node -> System.out.println(node + " => " + nodes.get(node).neighbourVertex.keySet()));
        }
    }

    public static class Vertex {
        Map<Integer, Integer> neighbourVertex = new HashMap<>();
    }

}
