package Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MergeTwoArray {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int arr1[] = new int[n];
            int arr2[] = new int[m];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                arr2[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().merge(arr1, arr2, n, m);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < n; i++) {
                str.append(arr1[i] + " ");
            }
            for (int i = 0; i < m; i++) {
                str.append(arr2[i] + " ");
            }
            System.out.println(str);
        }
    }

}

/*
* Given two sorted arrays Arr1[] and Arr2[] in non-decreasing order with size N and M. The task is to merge the two sorted arrays into one sorted array (in non-decreasing order).

Note:  DO NOT use extra space. We need to modify existing arrays as following.
*
* */
class Solution {

    private static int nextGap(int gap) {
        if (gap <= 1)
            return 0;
        return (gap / 2) + (gap % 2);
    }

    public void merge(int arr1[], int arr2[], int n, int m) {
        // code here

        int gap = nextGap(n + m);
        int i;
        int j;

        while (gap > 0) {
            for (i = 0; i < n - gap; i++) {
                if (arr1[i] > arr1[i + gap]) {
                    int temp = arr1[i + gap];
                    arr1[i + gap] = arr1[i];
                    arr1[i] = temp;
                }
            }

            j = gap > n ? gap - n : 0;

            while (j < m && i < n) {
                if (arr1[i] > arr2[j]) {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }

                i++;
                j++;
            }

            if (j < m) {
                for (j = 0; j < m - gap; j++) {
                    if (arr2[j] > arr2[j + gap]) {
                        int temp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = temp;
                    }
                }
            }

            gap = nextGap(gap);
        }

    }
}
