package Arrays;

import java.util.Scanner;

class GFG {
    public static void main(String[] args) {
        //code
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();

            int i = 0, j = s.length() - 1;

            char[] arr = s.toCharArray();

            while (i <= j) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }

            System.out.println(String.valueOf(arr));

        }

    }
}