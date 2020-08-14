package dp;

public class KadanesAlgorithm {
    public static void main(String[] args) {
        int[] arr = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};

        System.out.println(solveKadanes(arr));
    }

    private static int solveKadanes(int[] arr) {

        int maxSoFar = 0;
        int maxOverAll = 0;

        for (int i : arr) {
            /*
             *  T[i] = { MAX(adding current Element with existing result , currentElement)
             * */
            maxSoFar = Math.max(maxSoFar + i, i);
            maxOverAll = Math.max(maxOverAll, maxSoFar);
        }

        return maxOverAll;
    }
}
