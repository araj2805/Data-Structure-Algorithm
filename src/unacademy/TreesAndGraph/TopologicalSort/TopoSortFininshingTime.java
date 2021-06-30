package unacademy.TreesAndGraph.TopologicalSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopoSortFininshingTime {
    public static void main(String[] args) {

        int[][] adjMat = new int[8][8];

        adjMat[0][3] = 1;
        adjMat[0][1] = 1;
        adjMat[3][1] = 1;
        adjMat[3][2] = 1;
        adjMat[2][1] = 1;
        adjMat[4][1] = 1;
        adjMat[2][4] = 1;
        adjMat[7][1] = 1;
        adjMat[7][5] = 1;


        List<Integer> result = new ArrayList<>();

        if (cycleDetection(adjMat)) {
            System.out.println("Cycle Detected");
            return;
        }

        boolean[] visited = new boolean[adjMat.length];


        for (int i = 0; i < adjMat.length; i++) {
            if (visited[i] == false)
                topological_sort(adjMat, result, visited, i);
        }

        Collections.reverse(result);
        result.stream().forEach(a -> System.out.print(a + " "));
    }


    private static void topological_sort(int[][] adjMat, List<Integer> result, boolean[] visited, int vertex) {

        visited[vertex] = true;

        for (int i = 0; i < adjMat.length; i++) {
            if (adjMat[vertex][i] == 1 && visited[i] == false) {
                topological_sort(adjMat, result, visited, i);
            }
        }

        result.add(vertex);
    }

    private static boolean cycleDetection(int[][] adjMat) {

        boolean[] visited = new boolean[adjMat.length];

        for (int vertex = 0; vertex < adjMat.length; vertex++) {

            visited[vertex] = true;

            for (int neighbour = 0; neighbour < adjMat[0].length; neighbour++) {

                if (isCyclic(adjMat, neighbour, visited) == true) {
                    return true;
                }
            }

            visited[vertex] = false;

        }
        return false;
    }

    private static boolean isCyclic(int[][] adjMat, int vertex, boolean[] visited) {

        if (visited[vertex] == true)
            return true;

        visited[vertex] = true;

        for (int i = 0; i < adjMat[vertex].length; i++) {
            if (adjMat[vertex][i] == 1 && visited[i] == false)
                if (isCyclic(adjMat, i, visited) == true)
                    return true;
        }
        return false;
    }
}
