package codingBlocks.arraysANDstring;

/*
*

In Coding blocks test Kartik bhaiya gave students an array of n non-negative integers a1, a2, …, an ,where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). The task is to find two lines, which together with x-axis forms a container, such that the container contains the most water.
Note: You may not slant the container.
Input Format

First line contains integer n as size of array. Next n lines contains a single integer as elements of array.
Constraints

n>=2
Output Format

Output maximum water the container contains.
Sample Input

9
1 8 6 2 5 4 8 3 7

Sample Output

49


* */

import java.util.Scanner;

public class ContainerContaningMostWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(maxWater(arr, n));
    }

    private static long maxWater(int[] arr, int n) {

        int left = 0, right = n - 1;
        long area = Integer.MIN_VALUE;

        while (left < right) {
            area = Math.max(area, Math.min(arr[left], arr[right]) * (right - left));

            if (arr[left] < arr[right])
                left++;
            else
                right--;
        }

        return area;

    }
}
