package unacademy.TreesAndGraph;


import java.util.*;

public class Graph {

    public HashMap<String, Vertex> nodes;

    public Graph() {
        this.nodes = new HashMap<>();
    }

    public void addVertex(String vertexName) {
        if (nodes.containsKey(vertexName))
            return;

        Vertex vertex = new Vertex();
        nodes.put(vertexName, vertex);
    }

    public void addEdge(String v1Name, String v2Name, int cost) {
        Vertex vertex1 = nodes.get(v1Name);
        Vertex vertex2 = nodes.get(v2Name);

        if (vertex1 == null || vertex2 == null || vertex1.neighbourVertex.containsKey(v2Name) || vertex2.neighbourVertex.containsKey(v1Name))
            return;

        vertex1.neighbourVertex.put(v2Name, cost);
        vertex2.neighbourVertex.put(v1Name, cost);
    }

    public void deleteVertex(String vertexName) {
        Vertex vertex = nodes.get(vertexName);

        ArrayList<String> neighbourKeys = new ArrayList<>(vertex.neighbourVertex.keySet());

        for (String key : neighbourKeys) {
            Vertex nBrVertex = nodes.get(key);
            nBrVertex.neighbourVertex.remove(vertexName);
        }

        nodes.remove(vertexName);
    }

    public void removeEdge(String ver1Name, String ver2Name) {
        Vertex vertex1 = nodes.get(ver1Name);
        Vertex vertex2 = nodes.get(ver2Name);

        if (vertex1 == null || vertex2 == null || vertex1.neighbourVertex.containsKey(ver2Name) == false || vertex2.neighbourVertex.containsKey(ver1Name) == false)
            return;

        vertex1.neighbourVertex.remove(ver2Name);
        vertex2.neighbourVertex.remove(ver1Name);
    }

    public void printGraph() {
        System.out.println("_______________________________________________________");

        ArrayList<String> vnames = new ArrayList<>(nodes.keySet());

        for (String vertex : vnames) {
            String str = vertex + " => ";
            Vertex vtx = nodes.get(vertex);
            str += vtx.neighbourVertex;

            System.out.println(str);
        }


        System.out.println("_______________________________________________________");
    }

    public void dfs() {

        HashMap<String, Boolean> visited = new HashMap<>();
        Stack<String> stack = new Stack<>();


        for (String vertex : nodes.keySet()) {

            if (visited.containsKey(vertex))
                continue;

            stack.push(vertex);

            while (stack.isEmpty() == false) {
                String vtx = stack.pop();

                if (visited.containsKey(vtx))
                    continue;

                System.out.print(vtx + " ");
                visited.put(vtx, true);

                Vertex currVertex = nodes.get(vtx);

                for (String nbr : currVertex.neighbourVertex.keySet()) {
                    if (visited.containsKey(nbr) == false)
                        stack.push(nbr);
                }
            }
        }
    }

    /*
     *
     * DEPTH FIRST SEARCH Traversal
     *
     * */

    /*
     *
     * BREADTH FIRST SEARCH
     *
     * */
    public void bfs() {

        HashMap<String, Boolean> visited = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        for (String vertex : nodes.keySet()) {

            if (visited.containsKey(vertex))
                continue;

            queue.add(vertex);

            while (queue.isEmpty() == false) {

                String currVertex = queue.poll();

                if (visited.containsKey(currVertex))
                    continue;

                System.out.print(currVertex + " ");
                visited.put(currVertex, true);

                Vertex vtx = nodes.get(currVertex);

                for (String nbr : vtx.neighbourVertex.keySet()) {
                    if (visited.containsKey(nbr) == false)
                        queue.offer(nbr);
                }
            }
        }


    }

    public boolean isConnected() {

        Map<String, Boolean> visited = new HashMap<>();
        Stack<String> stack = new Stack<>();

        int connectedComponent = 0;

        for (String vertex : nodes.keySet()) {

            if (visited.containsKey(vertex))
                continue;

            connectedComponent++;
            stack.push(vertex);

            while (stack.isEmpty() == false) {

                String currVtx = stack.pop();

                if (visited.containsKey(currVtx))
                    continue;

                visited.put(currVtx, true);

                Vertex vtx = nodes.get(currVtx);

                for (String nbr : vtx.neighbourVertex.keySet()) {
                    if (visited.containsKey(nbr) == false)
                        stack.push(nbr);
                }
            }
        }

        return connectedComponent >= 2 ? false : true;
    }

    public List<List<String>> getConnectedComponent() {

        List<List<String>> res = new ArrayList<>();
        Map<String, Boolean> visited = new HashMap<>();
        Stack<String> stack = new Stack<>();

        for (String vertex : nodes.keySet()) {

            if (visited.containsKey(vertex))
                continue;

            stack.push(vertex);
            List<String> ans = new ArrayList<>();

            while (stack.isEmpty() == false) {
                String currVertex = stack.pop();

                if (visited.containsKey((currVertex)))
                    continue;

                ans.add(currVertex);
                visited.put(currVertex, true);

                Vertex vtx = nodes.get(currVertex);

                for (String nbr : vtx.neighbourVertex.keySet())
                    if (visited.containsKey(nbr) == false)
                        stack.push(nbr);
            }

            res.add(ans);

        }

        return res;
    }

    public boolean isCyclic() {
        HashMap<String, Boolean> visited = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        for (String vertex : nodes.keySet()) {

            if (visited.containsKey(vertex))
                continue;

            queue.add(vertex);

            while (queue.isEmpty() == false) {

                String currVertex = queue.poll();

                if (visited.containsKey(currVertex))
                    return true;

                visited.put(currVertex, true);

                Vertex vtx = nodes.get(currVertex);

                for (String nbr : vtx.neighbourVertex.keySet()) {
                    if (visited.containsKey(nbr) == false)
                        queue.offer(nbr);
                }
            }
        }
        return false;
    }

    public boolean isTree() {
        return isConnected() == true && isCyclic() == false;
    }

    public class Vertex {
        HashMap<String, Integer> neighbourVertex = new HashMap<>();
    }


}
