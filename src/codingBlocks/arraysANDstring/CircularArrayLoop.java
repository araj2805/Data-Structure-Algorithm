package codingBlocks.arraysANDstring;

import java.util.Scanner;

/*
*

You are given an array of positive and negative integers. If a number k at an index is positive, then move forward k steps. Conversely, if it's negative (-k), move backward k steps. Since the array is circular, you may assume that the last element's next element is the first element, and the first element's previous element is the last element.

Determine if there is a loop (or a cycle) in array. A cycle must start and end at the same index and the cycle's length > 1. Furthermore, movements in a cycle must all follow a single direction. In other words, a cycle must not consist of both forward and backward movements. Print 1 if cycle present else print 0.
Input Format

First Line Contains single integer n Second line contains n space separated integers
Constraints

1<=n<=1e6
-1000<=Ai<=1000
Output Format

single digit 1 or 0
Sample Input

5
2 -1 1 2 2

Sample Output

1


* */
public class CircularArrayLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(circularArrayLoop(arr) == true ? 1 : 0);

    }

    public static int next(int[] nums, int i) {
        return (i + nums[i] + nums.length) % nums.length;
    }

    public static boolean circularArrayLoop(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (nums[i] == 0)
                continue;

            int slow = i, fast = i;

            while (nums[slow] * nums[next(nums, slow)] > 0 &&
                    nums[fast] * nums[next(nums, fast)] > 0 &&
                    nums[fast] * nums[next(nums, next(nums, fast))] > 0) {
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));

                if (slow == fast) {
                    // That means cycle is present, but cycle length should be >1
                    if (slow == next(nums, slow)) {
                        break;
                    }
                    return true;
                }
            }

            slow = i;
            int val = nums[slow];
            while (val * nums[slow] > 0) {
                int x = slow;
                slow = next(nums, slow);

                nums[x] = 0;
            }
        }
        return false;
    }
}
