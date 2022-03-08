package unacademy.TreesAndGraph;

public class GraphClient {

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");
        graph.addVertex("e");

        graph.addVertex("f");
        graph.addVertex("g");

        graph.addEdge("a", "b", 5);
        graph.addEdge("a", "c", 7);

        graph.addEdge("b", "e", 2);
        graph.addEdge("b", "d", 4);

        graph.addEdge("c", "d", 8);

        graph.addEdge("d", "e", 13);

        graph.addEdge("e", "d", 11);

        graph.addEdge("f", "g", 11);

        graph.printGraph();

        /*graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");

        graph.addEdge("a","b",1);
        graph.addEdge("a","c",1);
        graph.addEdge("b","c",1);
        graph.addEdge("c","a",1);
        graph.addEdge("c","d",1);
        graph.addEdge("d","d",1);*/


//    graph.removeEdge("e","d");
//    graph.printGraph();


//    graph.deleteVertex("e");

//    graph.printGraph();

    /*graph.dfs();
        System.out.println();
    graph.bfs();
        System.out.println();
        System.out.println(graph.isConnected());
        System.out.println();*/

        /*List<List<String>> connectedComponent = graph.getConnectedComponent();

        for (List<String> s : connectedComponent)
            System.out.println(s);*/

        graph.getConnectedComponent().stream().forEach(strings -> System.out.println(strings));


    }
}
