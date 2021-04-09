package Arrays.prefixSum;

import java.util.Scanner;

public class CSUMQ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n], prefix = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            if (i == 0)
                prefix[i] = nums[i];
            else
                prefix[i] = prefix[i - 1] + nums[i];
        }

        int q = sc.nextInt();

        while (q-- > 0) {
            int i = sc.nextInt(), j = sc.nextInt();

            if (i == 0)
                System.out.println(prefix[j]);
            else
                System.out.println(prefix[j] - prefix[i - 1]);

        }


    }
}
