package mathematics;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 4, 2};

        System.out.println(stoneGameVII(arr));
    }

    public static int stoneGameVII(int[] stones) {

        int sum = 0;

        for (int i : stones)
            sum += i;

        int n = stones.length;
        int i = 0, j = n - 1;

        int a = 0, b = 0;

        int turn = 1;

        while (i <= j) {
            if (turn % 2 != 0) {
                if (stones[i] < stones[j]) {
                    a += sum - stones[i];
                    sum -= stones[i];
                    i++;
                } else {
                    a += sum - stones[j];
                    sum -= stones[j];
                    j--;
                }
            } else {
                if (stones[i] < stones[j]) {
                    b += sum - stones[j];
                    sum -= stones[j];
                    j--;
                } else {
                    b += sum - stones[i];
                    sum -= stones[i];
                    i++;
                }
            }

            turn++;
        }

        return a - b;

    }
}
