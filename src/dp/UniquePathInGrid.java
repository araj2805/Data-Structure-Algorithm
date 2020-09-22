package dp;

public class UniquePathInGrid {
    public static void main(String[] args) {
        System.out.println(path(3, 2));
    }

    private static int path(int m, int n) {

        if (m < 0 || n < 0)
            return 0;
        if (m == 0 && n == 0)
            return 1;


        return path(m - 1, n) + path(m, n - 1);
    }
}
