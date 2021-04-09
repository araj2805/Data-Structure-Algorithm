package codingBlocks.arraysANDstring;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
*

Given an integer array with even length, where different numbers in this array represent different kinds of candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister. Print the maximum number of kinds of candies the sister could gain.
Input Format

The first line contains an integer N, which denotes the Size of Arrays.and then next line contains n space separated integers representing the values of Arrays
Constraints

1< N <10,001
Output Format

Print a Single Integer A which denotes kinds of candies the sister could gain.
Sample Input

6
1 1 1 2 2 3 3

Sample Output

3
* */
public class DistributeCandies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        System.out.println(helper(nums));
    }

    private static int helper(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        int n = nums.length;
        int limit = n / 2;

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int ans = 0;

        for (Integer key : map.keySet()) {

            if (ans == limit)
                break;

            if (map.get(key) > 0)
                ans++;
        }

        return ans;
    }
}
