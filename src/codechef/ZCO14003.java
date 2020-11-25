package codechef;

import java.util.Arrays;
import java.util.Scanner;

public class ZCO14003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int n = sc.nextInt();

            long[] nums = new long[n];
            for (int i = 0; i < n; i++)
                nums[i] = sc.nextLong();

            // Naive Solution
            /*long revenue = 0,max = 0;

            for(int i = 0; i < n; i++)
            {
                int curr = nums[i];
                revenue = 0;
                for(int j = 0; j < n; j++)
                {
                    if(nums[j] >= curr)
                    {
                        revenue += curr;
                        max = Math.max(revenue,max);
                    }
                }
            }

            System.out.println(max);
            */


            // Optimised solution

            Arrays.sort(nums);
            long max = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                max = Math.max(max, nums[i] * (n - i));
            }

            System.out.println(max);

        }
    }
}
