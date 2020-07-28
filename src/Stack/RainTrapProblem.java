package Stack;

import java.util.Stack;

public class RainTrapProblem {
    public static void main(String[] args) {
//        Integer[] arr = new Integer[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Integer[] arr = new Integer[]{1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.print(trapRainWater(arr));
    }

    private static int trapRainWater(Integer[] arr) {

        Stack<Integer> stack = new Stack<>();

        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            while (stack.isEmpty() == false && arr[stack.peek()] < arr[i]) {
                int top = stack.pop();
                if (stack.isEmpty())
                    break;
                int distance = i - stack.peek() - 1;
                int height = Math.min(arr[stack.peek()], arr[i]) - arr[top];
                res += distance * height;
            }
            stack.push(i);
        }

        return res;
    }
}
