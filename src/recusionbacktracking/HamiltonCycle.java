package recusionbacktracking;

public class HamiltonCycle {
    public static void main(String[] args) {
        /* Let us create the following graph
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)-------(4)    */
        int graph1[][] = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
        };

        /* Let us create the following graph
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)       (4)    */
        int graph2[][] = {{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
        };

        hamCycle(graph1);
        hamCycle(graph2);

    }

    private static void hamCycle(int[][] graph) {

        // Outout array that can carry list of vertex
        int path[] = new int[graph.length];

        // setting up all path array with -1 as it's not visited yet
        for (int i = 0; i < graph.length; ++i)
            path[i] = -1;

        // adding first vertex to the solution space
        path[0] = 0;

        // passing all required parameter to find hamilton cycle : grapg -> input , path -> to store answer path, 1 -> postion of index in path array : Not staring with zero(0) as we included 0 in starting
        if (solveHamiltonCycle(graph, path, 1) == false) {
            System.out.println("No Solution exist");
        }

    }

    /*
     *  This function will help to solve the hamilton cycle
     * */
    private static boolean solveHamiltonCycle(int[][] graph, int[] path, int indexPosition) {

        /*
         *  Adjency Matrix : Graph[V][V] where  v is number of vertex in the graph.
         *  BASE CONDITION : When last vertex in graph will direct with the first vertex of the graph i.e indexPostion will reach to the number of nodes in graph
         * */
        if (indexPosition == graph.length) {
            // path[indexPosition-1] =  previous node in the answer path :  Here checking if last vertex in anser have path with initial vertex i.e Vertex 0
            if (graph[path[indexPosition - 1]][0] == 1) {
                printPath(path);
                return true;
            } else
                return false;
        }

        // Now will start with first vertex in graph and try rercusively to find hamiltion cycle in graph and if not found then backtrack and try for another vertex
        // Start with vertex 1 because vertex 0 is already present in solution.
        for (int vertex = 1; vertex < graph.length; vertex++) {
            if (isSafe(graph, vertex, path, indexPosition) == true) {
                path[indexPosition] = vertex;

                if (solveHamiltonCycle(graph, path, indexPosition + 1) == true)
                    return true;

                path[indexPosition] = -1;
            }
        }
        return false;
    }

    private static void printPath(int[] path) {
        for (int i : path)
            System.out.print(i + " ");
        System.out.print(" " + 0);
        System.out.println();
    }

    /*
     *  This is constraint function that will check if current vertex have direct path with previous vertex present in path answer array
     * and where current vertex is already present in the path answer array : if already present the return false.
     * */
    private static boolean isSafe(int[][] graph, int vertex, int[] path, int indexPosition) {

        if (graph[path[indexPosition - 1]][vertex] == 0)
            return false;

        for (int i : path)
            if (i == vertex)
                return false;

        return true;
    }
}
