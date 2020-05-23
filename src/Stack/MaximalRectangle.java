package Stack;

import java.util.Stack;

/*
*
* Given a binary matrix, find the maximum size rectangle binary-sub-matrix with all 1’s.
Example:

Input:
0 1 1 0
1 1 1 1
1 1 1 1
1 1 0 0
Output :
1 1 1 1
1 1 1 1
Explanation :
The largest rectangle with only 1's is from
(1, 0) to (2, 3) which is
1 1 1 1
1 1 1 1

Input:
0 1 1
1 1 1
0 1 1
Output:
1 1
1 1
1 1
Explanation :
The largest rectangle with only 1's is from
(0, 1) to (2, 2) which is
1 1
1 1
1 1
*
* */
public class MaximalRectangle {

    public static void main(String[] args) {
        int mat[][] = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
        };
        System.out.print(maxArea(mat));


    }

    private static int maxArea(int[][] mat) {

        int ROW = mat.length;
        int COL = mat[0].length;


        int area = histArea(mat[0]);

        for (int i = 1; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (mat[i][j] != 0) {
                    mat[i][j] += mat[i - 1][j];
                } else if (mat[i][j] == 0)
                    mat[i][j] = 0;
            }
        }

        for (int i = 1; i < ROW; i++) {
            area = Math.max(histArea(mat[i]), area);
        }

        return area;
    }

    private static int histArea(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            while (stack.isEmpty() == false && arr[stack.peek()] >= arr[i]) {

                int top = stack.pop();
                int curr = arr[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                res = Math.max(curr, res);
            }
            stack.push(i);
        }
        while (stack.isEmpty() == false) {
            int top = stack.pop();
            int curr = arr[top] * (stack.isEmpty() ? arr.length : arr.length - stack.peek() - 1);
            res = Math.max(curr, res);
        }
        return res;
    }
}
