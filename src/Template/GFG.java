package Template;

/*package whatever //do not write package name here */

import java.util.Scanner;

class GFG {
    public static void main(String[] args) {
        //code

        Scanner sc = new Scanner(System.in);

        int tt = sc.nextInt();

        while (tt-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt();
            int nums[] = new int[n];

            while (k-- > 0) {
                int j = sc.nextInt();

                for (int i = j - 1; i < n; i++)
                    nums[i] += 1;
            }

            for (int i = 0; i < n; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
        }
    }
}

/*
  1
 3 4
1 1 2 3
* */
