package interview.matrix;

import java.util.Scanner;

public class Rotate90ClockWise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        int[][] mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                mat[i][j] = sc.nextInt();
        }

//        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};

        System.out.println();

//        rotateClockWise90(mat);

        System.out.println();

        rotateAntiClockWiseEasy(mat);
        rotateAntiClockWiseEasy(mat);

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
                ;
            }
            System.out.println();
        }
    }

    private static void rotateAntiClockWise(int[][] mat) {
        int n = mat.length, m = mat.length;

        for (int i = 0; i < n; i++) {
            for (int j = m - i - 2; j >= 0; j--) {
                int temp = mat[i][j];
                mat[i][j] = mat[m - j - 1][n - i - 1];
                mat[m - j - 1][n - i - 1] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][m - j - 1];
                mat[i][m - j - 1] = temp;
            }
        }
    }

    private static void rotateAntiClockWiseEasy(int[][] mat) {
        int n = mat.length, m = mat.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[m - i - 1][j];
                mat[m - i - 1][j] = temp;
            }
        }
    }

    private static void rotateClockWise90(int[][] mat) {

        int n = mat.length, m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {

                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][m - j - 1];
                mat[i][m - j - 1] = temp;
            }
        }

    }


}
