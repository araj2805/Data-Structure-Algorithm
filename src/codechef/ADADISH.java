package codechef;

import java.util.Scanner;

public class ADADISH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int t = sc.nextInt();

            while (t-- > 0) {
                int n = sc.nextInt();

                Integer nums[] = new Integer[n];

                for (int i = 0; i < n; i++)
                    nums[i] = sc.nextInt();

                boolean flag = true;

                for (int i = 1; i < n; i++) {
                    if (nums[i] != nums[i - 1])
                        flag = false;
                }

                if (flag == true) {
                    System.out.println(calculateAllEqual(nums));
                } else {
                    System.out.println(calculateNotSame(nums, nums.length));
                }
            }
        }
    }

    private static int calculateNotSame(Integer[] nums, int n) {
//        Arrays.sort(nums, Collections.reverseOrder());

        int time = 0, i = n - 1 - 2;
        int a = nums[n - 1], b = nums[n - 2];

        while (true) {


            if (a == 0 && b == 0)
                break;


            if (a == 0 && i >= 0) {
                a = nums[i];
                i = i - 1;
            } else if (b == 0 && i >= 0) {
                b = nums[i];
                i = i - 1;
            }

            a--;
            b--;
            time++;
        }

        return time;
    }

    private static int calculateAllEqual(Integer[] nums) {

        return (nums.length - 1) * nums[0];
    }
}
