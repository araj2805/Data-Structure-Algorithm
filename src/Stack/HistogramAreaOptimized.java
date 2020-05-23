package Stack;

import java.util.Stack;
/*
 * This Algorithm is O(n) time complexity with S(n) space complexity.
 *
 * Here area can be calculated by considering each element as smallest bar in histogram and area can be calculated as : processElement*(nextsmallestPos - prevSmallestPos -1)
 * If any element doesn't have next smallest element then consider nextsmallestPos as length of input and then calculate area.
 *
 * */

public class HistogramAreaOptimized {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{6, 2, 5, 4, 1, 5, 6};

        System.out.println(calHistogramArea(arr));
    }

    private static int calHistogramArea(Integer[] arr) {

        Stack<Integer> stack = new Stack<>();

        int area = 0;

        for (int i = 0; i < arr.length; i++) {

            while (stack.isEmpty() == false && arr[stack.peek()] >= arr[i]) {
                int top = stack.pop();
                int curr = arr[top] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
                area = Math.max(area, curr);
            }
            stack.push(i);
        }

        while (stack.isEmpty() == false) {
            int top = stack.pop();
            int curr = arr[top] * (stack.isEmpty() ? arr.length : (arr.length - stack.peek() - 1));
            area = Math.max(curr, area);
        }
        return area;

    }
}
