package Algorithm;

public class insertionSort {

    public static int[] sorted(int[] a) {
        for (int j = 1; j < a.length; j++) {
            int key = a[j];
            int i = j - 1;
            while (i >= 0 && a[i] < key) {
                a[i + 1] = a[i];
                i = i - 1;
            }
            a[i + 1] = key;
        }
        return a;
    }

    public static void main(String[] args) {
        int a[] = sorted(new int[]{5, 2, 4, 6, 1, 3});
        for (int i = 0; i < 6; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
