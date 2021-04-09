package interview.matrix;

import java.util.Scanner;

public class RowWithMaxm1s {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();
        int[][] mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println(rowWithMaxmNumberOnes(mat, n, m));
    }


    private static int rowWithMaxmNumberOnes(int[][] mat, int n, int m) {

        int count = 0, overAllCount = 0, res = -1;
        for (int i = 0; i < n; i++) {

            int indexOfFirstOne = binarySearchMatrix(mat[i]);

            if (indexOfFirstOne != -1)
                count = m - indexOfFirstOne;

            if (count > overAllCount) {
                count = overAllCount;
                res = i;
            }
        }

        return res;
    }

    private static int binarySearchMatrix(int[] nums) {

        int low = 0, high = nums.length - 1, ans = -1;


        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == 1 && (mid == 0 || nums[mid] != nums[mid - 1]))
                return mid;

            if (nums[mid] < 1)
                low = mid + 1;
            else
                high = mid - 1;

        }


        return ans;
    }
}
