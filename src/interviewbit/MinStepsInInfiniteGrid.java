package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class MinStepsInInfiniteGrid {
    public static void main(String[] args) {
        Solution sol = new Solution();

        ArrayList<Integer> xCord = new ArrayList<>(Arrays.asList(new Integer[]{-1, 2, 3}));
        ArrayList<Integer> yCord = new ArrayList<>(Arrays.asList(new Integer[]{-3, 6, 9}));
        System.out.println(sol.coverPoints(xCord, yCord));
    }

}

class Solution {
    public int coverPoints(ArrayList<Integer> xCord, ArrayList<Integer> yCord) {

        int res = 0;

        for (int i = 0; i < xCord.size() - 1; i++) {


            int x = Math.abs(xCord.get(i) - xCord.get(i + 1));
            int y = Math.abs(yCord.get(i) - yCord.get(i + 1));

            int diagonalMoves = Math.min(x, y);

            res += diagonalMoves;

            x -= diagonalMoves;
            y -= diagonalMoves;

            res += Math.max(x, y);
        }


        return res;
    }
}
