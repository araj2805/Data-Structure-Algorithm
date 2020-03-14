package Algorithm;

public class MergeSort {

    public static void sort(int[] a, int left, int right) {
        if (left < right) {
            int mid = (left + right - 1) / 2;

            sort(a, left, mid);

            sort(a, mid + 1, right);

            merge(a, left, mid, right);
        }
    }

    private static void merge(int[] a, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] l = new int[n1 + 1];
        int[] r = new int[n2 + 1];

//        int i = 0 , j = 0;

        for (int i = 0; i < n1; i++) {
            l[i] = a[left + i];
        }

        for (int j = 0; j < n2; j++) {
            r[j] = a[mid + 1 + j];
        }

        l[n1] = Integer.MAX_VALUE;
        r[n2] = Integer.MAX_VALUE;

        int i = 0, j = 0, k = 0;

        for (k = left; k < right; k++) {
            if (l[i] <= r[j]) {
                a[k] = l[i];
                i++;
            } else {
                a[k] = r[j];
                j++;
            }
        }

        while (i < n1) {
            a[k] = l[i];
            i++;
            k++;
        }
        while ((j < n2)) {
            a[k] = r[j];
            k++;
            j++;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 2, 4, 6, 1, 3};

        int left = 0;
        int right = a.length - 1;


        sort(a, left, right);


        for (int i = 0; i < 6; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
