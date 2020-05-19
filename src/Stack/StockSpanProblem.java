package Stack;

import java.util.Stack;

public class StockSpanProblem {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{15, 13, 12, 14, 16, 8, 6, 4, 10, 30};

        stockSpan(arr);
    }

    private static void stockSpan(Integer[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 0; i < arr.length; i++) {
            while (stack.isEmpty() == false && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            int span = stack.isEmpty() ? i + 1 : i - stack.peek();
            System.out.print(span + " ");
            stack.push(i);
        }
    }


}
