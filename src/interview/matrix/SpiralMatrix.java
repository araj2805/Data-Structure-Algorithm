package interview.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        List<Integer> result = spiralMatrix(mat);

        for (int i : result)
            System.out.print(i + " ");
    }

    private static List<Integer> spiralMatrix(int[][] mat) {

        int n = mat.length, m = mat[0].length;

        List<Integer> res = new ArrayList<>();

        if (mat == null || n == 0)
            return res;

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;

//        int i = 0, j = 0;

        while (top <= bottom && left <= right) {

//            Moving from left to right in row
            for (int i = left; i <= right; i++) {
                res.add(mat[top][i]);
            }
//            we are done with one layer now move to next layer
            top++;

//            Moving from top to bottom in column
            for (int i = top; i <= bottom; i++) {
                res.add(mat[i][right]);
            }
//            we are done with one column,now moving inwards
            right--;

//            Checking if we overshoot out of bound
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(mat[bottom][i]);
                }
            }
//                we are done with one bottom layer now move inwards
            bottom--;

//            Checking if we overshoot out of bound
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(mat[i][left]);
                }
            }
//            Now moving inwards
            left++;

        }

        return res;
    }


}
