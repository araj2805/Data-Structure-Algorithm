package codechef;


import java.util.Scanner;

public class HRSCPMTR {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int tt = sc.nextInt();

            while (tt-- > 0) {
                int n = sc.nextInt(), m = sc.nextInt();

                long[][] mat = new long[n][m];

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        mat[i][j] = sc.nextLong();
                    }
                }

                int count = 0; // Precomputed the number of degree matrix is not good.

                for (int i = 1; i < n; i++) {
                    for (int j = 1; j < m; j++) {
                        if (mat[i][j] != mat[i - 1][j - 1])
                            count++;
                    }
                }


                int q = sc.nextInt();

                while (q-- > 0) {

                    int x = sc.nextInt(), y = sc.nextInt();
                    long v = sc.nextLong();
                    x--;
                    y--;

                    long old = mat[x][y];
                    mat[x][y] = v;

                    if (x - 1 >= 0 && y - 1 >= 0) {
                        if (mat[x - 1][y - 1] == mat[x][y] && mat[x][y] != old)
                            count--;
                    }

                    if (x + 1 < n && y + 1 < m) {
                        if (mat[x][y] == mat[x + 1][y + 1] && mat[x][y] != old)
                            count--;
                    }

                    if (x - 1 >= 0 && y - 1 >= 0) {
                        if (mat[x - 1][y - 1] != mat[x][y] && mat[x - 1][y - 1] == old)
                            count++;
                    }

                    if (x + 1 < n && y + 1 < m) {
                        if (mat[x][y] != mat[x + 1][y + 1] && mat[x + 1][y + 1] == old)
                            count++;
                    }

                    System.out.println(count == 0 ? "Yes" : "No");
                }
            }
        }
    }


}
