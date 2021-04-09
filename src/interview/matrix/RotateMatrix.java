package interview.matrix;

public class RotateMatrix {
    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(), m = sc.nextInt();
//        int[][] mat = new int[n][m];
//
//        for(int i = 0; i < n; i++)
//            for(int j = 0; j < m; j++)
//                mat[i][j] = sc.nextInt();

        int[][] mat = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        rotateMatrix(mat);

        System.out.println();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(" " + mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;

        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;

        int prev, curr;

        while (top <= bottom && left <= right) {

            prev = mat[top + 1][left];

            for (int i = left; i <= right; i++) {
                curr = mat[top][i];
                mat[top][i] = prev;
                prev = curr;
            }

            top++;

            for (int i = top; i <= bottom; i++) {
                curr = mat[i][right];
                mat[i][right] = prev;
                prev = curr;
            }

            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    curr = mat[bottom][i];
                    mat[bottom][i] = prev;
                    prev = curr;
                }
            }

            bottom--;

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    curr = mat[i][left];
                    mat[i][left] = prev;
                    prev = curr;
                }
            }

            left++;

        }

    }
}
