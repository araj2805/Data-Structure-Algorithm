package Algorithm;

import java.util.Arrays;

public class InversioCount {

    public static void main(String[] args) {
        int[] a = new int[]{2, 4, 1, 3, 5};
        int count = inverseCount(a, 0, a.length - 1);
        System.out.print(count);
    }

    private static int inverseCount(int[] a, int low, int high) {

        int count = 0;
        if (low < high) {
            int mid = (low + high) / 2;

            count += inverseCount(a, low, mid);

            count += inverseCount(a, mid + 1, high);

            count += mergeAndCount(a, low, mid, high);
        }
        return count;
    }

    private static int mergeAndCount(int[] a, int low, int mid, int high) {

        int mergeCount = 0;
        int n1 = mid - low + 1;
        int n2 = high - mid;

        /*int[] lArr = new int[n1];
        int[] rArr = new int[n2];

        for(int i=0; i<n1; i++)
        {
            lArr[i] = a[low+i-1];
        }

        for(int j=0; j<n2; j++)
        {
            rArr[j] = a[j+high];
        }*/

        int[] lArr = Arrays.copyOfRange(a, low, mid + 1);
        int[] rArr = Arrays.copyOfRange(a, mid + 1, high + 1);

        int i = 0, j = 0, k = low;

        while (i < lArr.length && j < rArr.length) {
            if (lArr[i] <= rArr[j]) {
//                i++;
                a[k++] = lArr[i++];
            } else {
//                j++;
                a[k++] = rArr[j++];
                mergeCount += (mid + 1) - (i + low);
            }
        }
        while (i < lArr.length)
            a[k++] = lArr[i++];

        while (j < rArr.length)
            a[k++] = rArr[j++];

        return mergeCount;
    }
}
