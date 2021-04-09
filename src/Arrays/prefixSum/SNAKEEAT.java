package Arrays.prefixSum;

import java.util.Arrays;
import java.util.Scanner;

public class SNAKEEAT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int T = sc.nextInt();

            while (T-- > 0) {
                int n = sc.nextInt(), q = sc.nextInt();

                int[] nums = new int[n], prefix = new int[n];

                for (int i = 0; i < n; i++)
                    nums[i] = sc.nextInt();

                Arrays.sort(nums);
                prefix[0] = nums[0];

                for (int i = 1; i < n; i++) {
                    if (prefix[i - 1] <= nums[i])
                        prefix[i] = 1 + nums[i];
                }

                while (q-- > 0) {
                    int k = sc.nextInt();

                    int low = 0, high = n - 1, mid = 0;


                    while (low <= high) {
                        mid = low + (high - low) / 2;

                        if (prefix[mid] < k) {
                            low = mid + 1;
                        } else if (prefix[mid] > k) {
                            high = mid - 1;
                        } else {
                            break;
                        }
                    }

                    if (k <= prefix[mid])
                        System.out.println(n - mid);
                    else
                        System.out.println(0);
                }


            }
        }

    }
}
