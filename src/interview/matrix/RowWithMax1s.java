package interview.matrix;

public class RowWithMax1s {
    public static void main(String[] args) {

        /*int[][] nums =
                {{0, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}};*/

        int[][] nums = {{0, 0, 0, 0}};

        System.out.println(rowWithMax1s(nums, nums.length, nums[0].length));

    }

    static int rowWithMax1s(int nums[][], int n, int m) {
        // code here

        int index = firstRowIndex(nums[0]);

        if (index == -1)
            index = nums[0].length - 1;

        if (index == 0 && nums[0][0] == 1)
            return 0;

        int row_with_max_1 = -1;


        for (int i = 1; i < nums.length; i++) {

            while (index >= 0 && nums[i][index] == 1) {
                index--;
                row_with_max_1 = i;
            }

        }

        return row_with_max_1;

    }

    public static int firstRowIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                return i;
        }

        return -1;
    }
}
