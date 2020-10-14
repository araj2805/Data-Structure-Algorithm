package codechef;

import java.util.Scanner;

//CHEFEZQ
public class ChefAndEasyQueriesCHEFEZQ {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        int t = 0;
        if (scanner.hasNextInt())
            t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int[] queries = new int[n];

            for (int i = 0; i < n; i++)
                queries[i] = scanner.nextInt();

            System.out.println(noOfDays(queries, n, k));
        }

        scanner.close();
    }

    private static int noOfDays(int[] queries, int n, int k) {

//        int result = 0;

//        int query = 0, i = 0;

//        while (query == 0 || query >= k || i < n) {
//            if (i < n)
//                query += queries[i++];
//
//            if (query >= k) {
//                query = query - k;
//                result++;
//            } else {
////                result++;
//                return result;
//            }
//        }

        int query = 0;
        int result = 0;

        int i;
        for (i = 0; i < n; i++) {
            query += queries[i];

            if (query >= k) {
                query -= k;
                result++;
            } else {
                result++;
                return result;
            }
        }


        if (i == n && query > k) {
            while (query >= k) {
                query = query - k;
                result++;
            }
            result++;
        }


        return result;
    }
}
