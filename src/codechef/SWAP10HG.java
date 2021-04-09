package codechef;

import java.util.Scanner;

public class SWAP10HG {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int tt = sc.nextInt();

            while (tt-- > 0) {
                int n = sc.nextInt();

                String s = sc.next(), p = sc.next();

                System.out.println(solve(s, p, n));
            }
        }
    }

    private static String solve(String s, String p, int n) {

        if (s.equals(p))
            return "Yes";

        int i = 0, j = n - 1;
        char[] arr = s.toCharArray();

        while (i < j && i < n && j >= 0) {
            while (arr[i] != '1')
                i++;
            while (arr[j] != '0')
                j--;

            char ch = arr[i];
            arr[i] = arr[j];
            arr[j] = ch;

            if (String.valueOf(arr).equals(p))
                return "Yes";

        }


        return "No";
    }
}
