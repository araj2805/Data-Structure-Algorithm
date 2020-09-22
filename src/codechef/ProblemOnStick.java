package codechef;

import java.util.HashSet;
import java.util.Scanner;

// A Problem on Sticks Problem Code: TREE2
public class ProblemOnStick {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];

            for (int i = 0; i < n; i++)
                nums[i] = sc.nextInt();

            HashSet<Integer> set = new HashSet<>();

            for (int i : nums) {
                if (i != 0)
                    set.add(i);
            }

            System.out.println(set.size());
        }
    }
}
