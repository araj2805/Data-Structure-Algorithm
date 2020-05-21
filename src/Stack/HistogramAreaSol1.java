package Stack;

import java.util.Stack;

public class HistogramAreaSol1 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{6, 2, 5, 4, 1, 5, 6};

        System.out.println(calHistogramArea(arr));
    }

    private static int calHistogramArea(Integer[] arr) {

        Integer[] preSmallerArr = getPreviousSmaller(arr);
        Integer[] nextSmallerArr = getNextSmaller(arr);
        for (Integer i : preSmallerArr)
            System.out.print(i + " ");

        System.out.println();

        for (Integer i : nextSmallerArr)
            System.out.print(i + " ");

        System.out.println();

        int area = 0;

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            curr += (i - preSmallerArr[i] - 1) * arr[i];
            curr += (nextSmallerArr[i] - i - 1) * arr[i];

            area = Math.max(area, curr);

        }

        return area;
    }

    private static Integer[] getNextSmaller(Integer[] arr) {
        Integer[] nextGreaterArr = new Integer[arr.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(arr.length - 1);

        nextGreaterArr[arr.length - 1] = arr.length;

        for (int i = arr.length - 2; i >= 0; i--) {
            while (stack.isEmpty() == false && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            int nextSmaller = stack.isEmpty() ? arr.length : stack.peek();
//            System.out.print(nextSmaller + " ");
            nextGreaterArr[i] = nextSmaller;
            stack.push(i);
        }


        return nextGreaterArr;
    }

    private static Integer[] getPreviousSmaller(Integer[] arr) {
        Integer[] preSmallerArr = new Integer[arr.length];

        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        preSmallerArr[0] = -1;

        for (int i = 1; i < arr.length; i++) {
            while (stack.isEmpty() == false && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            int prevSmall = stack.isEmpty() ? -1 : stack.peek();
//            System.out.print(prevSmall + " ");
            preSmallerArr[i] = prevSmall;

            stack.push(i);
        }


        return preSmallerArr;
    }
}
