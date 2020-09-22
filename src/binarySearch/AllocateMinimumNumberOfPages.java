package binarySearch;

import java.util.Scanner;

public class AllocateMinimumNumberOfPages {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();

        while (t-- > 0) {
            long n = scan.nextLong();
            long[] nums = new long[(int) n];

            for (int i = 0; i < n; i++)
                nums[i] = scan.nextLong();

            long k = scan.nextLong();

            System.out.println(partition(nums, n, k));
        }
    }

    private static long partition(long[] nums, long n, long k) {

        if (k > n)
            return -1l;

        long res = -1;

        long high = 0, low = 0;


        for (int i = 0; i < n; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (isValid(nums, n, k, mid) == true) {
                res = mid;
                high = mid - 1;
            } else
                low = mid + 1;

        }

        return res;
    }

    private static boolean isValid(long[] nums, long n, long k, long mid) {

        long student = 1;

        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sum > mid) {
                student++;
                sum = nums[i];
            }

            if (student > k)
                return false;
        }
        return true;
    }
}
