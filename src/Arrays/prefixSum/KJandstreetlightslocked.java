package Arrays.prefixSum;

import java.util.Scanner;

public class KJandstreetlightslocked {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), p = sc.nextInt();

        int[] nums = new int[p + 1];
        int temp = n;

        while (temp-- > 0) {
            int x = sc.nextInt(), range = sc.nextInt();

            int l = x - range < 0 ? 0 : x - range;
            int r = x + range > p ? p : x + range;

            for (int i = l; i <= r; i++) {
                if (nums[i] == 1)
                    nums[i] = 0;
                else
                    nums[i] = 1;
            }

        }

        for (int i = 0; i <= p; i++)
            System.out.print(nums[i] + " ");

        System.out.println();

        int count = 0, res = Integer.MIN_VALUE;

        for (int i = 0; i <= p; i++) {
            if (nums[i] == 0) {
                count++;

            } else
                count = 0;
            res = Math.max(res, count);
        }

        System.out.println(res);
    }
}
