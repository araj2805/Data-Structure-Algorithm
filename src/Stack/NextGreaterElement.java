package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{11, 13, 21, 3};

        nextGreaterElementSol(arr);

    }

    private static void nextGreaterElementSol(Integer[] arr) {

        Stack<Integer> stack = new Stack<>();
        stack.push(arr.length - 1);
        List<Integer> output = new ArrayList<>();
        output.add(-1);
        for (int i = arr.length - 2; i >= 0; i--) {

            while (stack.isEmpty() == false && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            int nge = stack.isEmpty() ? -1 : arr[stack.peek()];
            output.add(nge);
            stack.push(i);
        }

        for (int i = output.size() - 1; i >= 0; i--) {
            System.out.print(output.get(i) + " ");
        }
    }
}
