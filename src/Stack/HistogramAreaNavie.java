package Stack;


/*
 * This is naive solution whose time complexity is o(n^2)
 *
 * Algorithm:
 *
 * 1) Consider each element as smallest rectangular bar and create area around it.
 * 2) Area can be calculated by moving left from the element and check while element is greater or equal and then add to area else break
 * 3) Area can be calculated by movinf right from the element and check while element is greater or equal and then add to area else break
 * 4) get the maximum of calculated area and previous area and then return maximum area
 *
 * */

public class HistogramAreaNavie {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{6, 2, 5, 4, 1, 5, 6};

        System.out.print(calHistogramArea(arr));
    }

    private static int calHistogramArea(Integer[] arr) {


        int area = 0;
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];

            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] <= arr[j])
                    curr = curr + arr[i];
                else
                    break;
            }

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] <= arr[j])
                    curr = curr + arr[i];
                else
                    break;
            }

            area = Math.max(area, curr);
        }

        return area;
    }
}
