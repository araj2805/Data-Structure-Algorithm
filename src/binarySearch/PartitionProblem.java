package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PartitionProblem {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] info = br.readLine().split(" ");
            int k = Integer.parseInt(info[0]);
            int n = Integer.parseInt(info[1]);

            String[] array = br.readLine().split(" ");

            int[] nums = new int[n];

            for (int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(array[i].trim());

            System.out.println(painterPartition(nums, n, k));
        }
    }

    private static long painterPartition(int[] nums, int n, int k) {

        if (k > n)
            return -1l;

        long res = -1;

        long low = 0, high = 0;

        for (int i = 0; i < n; i++) {
            low = Math.max(nums[i], low);
            high += nums[i];
        }

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (isValid(nums, n, k, mid) == true) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }

    private static boolean isValid(int[] nums, int n, int k, long mid) {

        long painter = 1, sum = 0l;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sum > mid) {
                painter++;
                sum = nums[i];

                if (painter > k)
                    return false;
            }
        }


        return true;
    }
}
