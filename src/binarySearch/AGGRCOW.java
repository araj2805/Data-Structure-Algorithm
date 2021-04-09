package binarySearch;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class AGGRCOW {

    /*
     *  Main Method : public static void main
     * */

    public static void main(String args[]) throws IOException {

        Scanner sc = new Scanner(System.in);


        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt(), c = sc.nextInt();

            long[] nums = new long[n];

            for (int i = 0; i < n; i++)
                nums[i] = sc.nextLong();

            System.out.println(solve(nums, n, c));

        }
    }

    private static long solve(long[] nums, int n, int c) {

        Arrays.sort(nums);

        long low = 1, high = nums[n - 1], res = -1;

        if (c > n)
            return res;

        high = high - low;

        while (low <= high) {

            long mid = low + (high - low) / 2;


            if (isValid(nums, c, n, mid) == true) {
                res = Math.max(res, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }


        return res;
    }

    private static boolean isValid(long[] nums, int c, int n, long minimumDistance) {

        int cow = 1;

        long cowFixPosition = nums[0];

        for (int i = 1; i < n; i++) {

            if (nums[i] - cowFixPosition >= minimumDistance) {
                cowFixPosition = nums[i];
                cow++;
            }

            if (cow == c)
                return true;

            if (cow > c)
                return false;
        }

        return false;
    }

}