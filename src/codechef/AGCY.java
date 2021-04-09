package codechef;

import java.util.Scanner;

class AGCY {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int tt = sc.nextInt();

            while (tt-- > 0) {
                int n = sc.nextInt(), q = sc.nextInt();
                int[] nums = new int[n + 1];

                while (q-- > 0) {
                    int l = sc.nextInt(), r = sc.nextInt();

                    int count = 1;

                    while (l <= r) {
                        nums[l] += count;
                        count++;
                        if (l == r)
                            break;
                        l++;

                    }
                }

                for (int i = 1; i <= n; i++)
                    System.out.print(nums[i] + " ");
                System.out.println();

            }


        }
    }
}
