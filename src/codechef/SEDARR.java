package codechef;

import java.util.Scanner;

public class SEDARR {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int tt = sc.nextInt();

            while (tt-- > 0) {
                int n = sc.nextInt(), k = sc.nextInt();
                int[] nums = new int[n];
                long sum = 0;
                for (int i = 0; i < n; i++) {
                    nums[i] = sc.nextInt();
                    sum += nums[i];
                }

                System.out.println(solve(sum, nums, n, k));


            }

        }


    }

    private static int solve(long sum, int[] nums, int n, int k) {

        if (sum % k == 0)
            return 0;

        int rem = (int) (sum % k);


        return 1;
    }
}
