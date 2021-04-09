package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class KingdomOfDreams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tt = sc.nextInt();

        while (tt-- > 0) {
            int n = sc.nextInt();

            int[] nums = new int[n];

            for (int i = 0; i < n; i++)
                nums[i] = sc.nextInt();

            Arrays.sort(nums);

            long sum = 0;
            while (n > 3) {
                sum += Math.min(nums[n - 1] + nums[n - 2] + 2 * nums[0], 2 * nums[1] + nums[0] + nums[n - 1]);
                n = n - 2;
            }
            if (n == 2)
                sum += nums[1];
            else if (n == 3)
                sum += nums[0] + nums[1] + nums[2];
            else if (n == 1)
                sum += nums[0];

            System.out.println(sum);
        }
    }
}
