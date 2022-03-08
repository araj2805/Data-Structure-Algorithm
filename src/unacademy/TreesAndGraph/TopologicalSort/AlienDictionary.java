package unacademy.TreesAndGraph.TopologicalSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AlienDictionary {

//    https://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/

    /*

    Input

    5 4
    baa
    abcd
    abca
    cab
    cad



    * */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), characterLimit = sc.nextInt();

        String[] dict = new String[n];

        for (int i = 0; i < n; i++) {
            dict[i] = sc.next();
        }


        List<Character> res = getAlienOrder(dict, characterLimit);

        res.stream().forEach(character -> System.out.print(character + " "));
    }

    private static List<Character> getAlienOrder(String[] dict, int characterLimit) {
        List<Character> res = new ArrayList<>();

        Graph graph = new Graph(characterLimit);

//        Graph Creation
        for (int i = 0; i < dict.length - 1; i++) {

//            Take two word consecutive
            String word1 = dict[i];
            String word2 = dict[i + 1];
//              Iterating each char to make link which comes first i.e (a < b so a -> b in graph)
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {

//                If character is not same meaning word1 char is smaller than word2 char i.e there is direct edge
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.addEdge(word1.charAt(j) - 'a', word2.charAt(j) - 'a');
                    break;
                }
            }
        }

        res = graph.topologicalSort();


        return res;
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

        List<Character> topologicalSort() {

            List<Character> res = new ArrayList<>();

            boolean[] visited = new boolean[nodes];

            for (int i = 0; i < nodes; i++) {
                if (visited[i] == false)
                    topological_sort_util(res, visited, i);
            }

            Collections.reverse(res);

            return res;
        }

        void topological_sort_util(List<Character> res, boolean[] visited, int vertex) {

            visited[vertex] = true;

            for (int neigh : adjList.get(vertex)) {
                if (visited[neigh] == false) {
                    topological_sort_util(res, visited, neigh);
                }

            }

            res.add((char) (vertex + 'a'));
        }
    }


}
