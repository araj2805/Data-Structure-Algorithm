/*
package Algorithm;

public class PeakFinding2D {

    public static void main(String...jsfnksjd)
    {
        int n = 4;
        int m = 4;
        int [][] arr = {{ 10, 8, 10, 10 },
                        { 14, 13, 12, 11 },
                        { 15, 9, 11, 21 },
                        { 16, 17, 19, 20 }};

        int result = peak2dArray(arr,m,n/2);
    }

    private static int peak2dArray(int[][] arr, int i, int j) {

        int gobMax = globalMaxColumnValue(arr,i,j);
        int indexJ = globalMaxColumnIndex(arr,i,j);

        if(arr[i][indexJ] >= arr[i][indexJ-1] && arr[i][j] >= arr[i][indexJ+1])
        {
            return arr[i][indexJ];
        }

        if(arr[i][indexJ-1] > arr[i][j])
        {
            return peak2dArray(arr,i,indexJ-1);
        }
        else if(arr[i][indexJ] < arr[i][indexJ+1])
        {
            return peak2dArray(arr,i,indexJ+1);
        }

    }

    private static int globalMaxColumnIndex(int[][] arr, int i, int j) {
        int max = 0 , index = 0;
        for (int k=0; k<j; k++)
        {
            if(max > arr[i][k])
            {
                index =k;
                max = arr[i][k];
            }
        }
        return index;
    }

    private static int globalMaxColumnValue(int[][] arr, int i, int j) {

        int max = 0 , index = 0;
        for (int k=0; k<j; k++)
        {
            if(max > arr[i][k])
            {
                index =k;
                max = arr[i][k];
            }
        }
        return max;
    }
}
*/
