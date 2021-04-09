package Stack;

import java.util.Stack;

public class PreviousGreaterElement {

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{15, 10, 18, 12, 4, 6, 2, 8};

        prevGreaterElementSol(arr);
    }

    private static void prevGreaterElementSol(Integer[] arr) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        System.out.print(-1 + " ");

        for (int i = 1; i < arr.length; i++) {
            while (stack.isEmpty() == false && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            int previousGreater = (stack.isEmpty()) ? -1 : arr[stack.peek()];
            System.out.print(previousGreater + " ");
            stack.push(i);
        }
    }
}
