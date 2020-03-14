/*
package Algorithm;

import java.util.Random;

public class KthLargestElement {
    public static void main(String[] args)
    {
        int[] a = new int[]{42,53,1,9,4};
        int k = 2;
        int res = kLargest(a,0,a.length-1,k);

//        for(int i =0 ;i<5;i++)
//        {
            System.out.print(res);
//        }
    }

    private static int kLargest(int[] a, int left, int right, int k) {

        int n = a.length;
        Random random = new Random(0);

        while (left <= right)
        {
            int choosePivotIndex =  random.nextInt(right - left + 1) + left; //Choose any random index starting from left

            int finalIndexOfChosenPivot = partition(a,left,right,choosePivotIndex);

            if(finalIndexOfChosenPivot == n-k)
                return a[finalIndexOfChosenPivot];
            else if(finalIndexOfChosenPivot > n-k)
            {
                right = finalIndexOfChosenPivot - 1;
            }
            else
            {
                left = finalIndexOfChosenPivot +1 ;
            }
        }

    }

    private static int partition(int[] a, int left, int right, int pivotIndex) {

        int pivot = a[pivotIndex];

        int i = left - 1;
        int j = left;

        swap(a,pivotIndex,right);
        while (j < right)
        {
            if(a[j] <= pivot)
            {
                i++;
                swap(a,i,j);
            }
            j++;
        }
         swap(a,right,i);

        return i;

    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
*/
