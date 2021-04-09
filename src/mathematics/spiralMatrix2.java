package mathematics;

import java.util.Scanner;

public class spiralMatrix2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] mat = generateMatrix(sc.nextInt());

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] generateMatrix(int n) {

        int[][] mat = new int[n][n];

        int rowBegin = 0, rowEnd = n - 1;
        int columnBegin = 0, columnEnd = n - 1;

        int x = 1;


        while (rowBegin <= rowEnd && columnBegin <= columnEnd) {
            for (int i = columnBegin; i <= columnEnd; i++)
                mat[rowBegin][i] = x++;

            rowBegin++;

            for (int i = rowBegin; i <= rowEnd; i++)
                mat[i][columnEnd] = x++;

            columnEnd--;

            if (columnBegin <= columnEnd) {
                for (int i = columnEnd; i >= columnBegin; i--)
                    mat[rowEnd][i] = x++;
            }

            rowEnd--;

            if (rowBegin <= rowEnd) {
                for (int i = rowEnd; i >= rowBegin; i--)
                    mat[i][columnBegin] = x++;
            }
            columnBegin++;
        }

        return mat;
    }
}
