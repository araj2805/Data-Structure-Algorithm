package Algorithm;

public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[]{42, 53, 1, 9, 4};
        quickSort(a, 0, a.length - 1);
        for (int i = 0; i < 5; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static void quickSort(int[] a, int left, int right) {

        if (left < right) {
            int pivotIndex = partition(a, left, right);
            quickSort(a, left, pivotIndex - 1);
            quickSort(a, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] a, int left, int right) {

        int i = left - 1;
        int j = left;
        int pivot = a[right];

        while (j < right) {
            if (a[j] <= pivot) {
                i++;
                swap(a, i, j);
            }
            j++;
        }

        swap(a, i + 1, right);

        return i + 1;
    }

    private static void swap(int[] a, int i, int j) {

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
