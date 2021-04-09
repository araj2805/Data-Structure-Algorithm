package codechef.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FROGV {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt(), k = scanner.nextInt(), p = scanner.nextInt();

            int[] nums = new int[n];
            List<pair> frogs = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
                frogs.add(new pair(i, nums[i]));
            }

            frogs.sort((o1, o2) -> o2.index - o1.index);

            int[] dp = new int[n];

            dp[frogs.get(0).index] = frogs.get(0).value + k;

            for (int i = 1; i < n; i++) {
                if (frogs.get(i - 1).value - frogs.get(i).value <= k) {
                    dp[frogs.get(i).index] = dp[frogs.get(i - 1).index];
                } else {
                    dp[frogs.get(i).index] = frogs.get(i).value + k;
                }
            }

            for (int i = 0; i < n; i++)
                System.out.print(dp[i] + " ");

            System.out.println();

            for (pair pq : frogs) {
                System.out.print(pq.index + " " + pq.value);
                System.out.println();
            }
            System.out.println();

            while (p-- > 0) {
                int x = scanner.nextInt(), y = scanner.nextInt();

                if (dp[x - 1] == dp[y - 1])
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }


        }
    }

    static class pair {
        int index, value;

        pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
