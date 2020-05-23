package Stack;

import java.util.Stack;

public class MinElementO1 {
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> AuxillaryStack = new Stack<>();


    public static void main(String[] args) {
        String a = "123";
//        (min(A[il],A[ir])-A[bot])*(ir-il-1)


        for (int i = 0; i < a.length(); i++) {
//            System.out.print(a.charAt(i));

            System.out.println(Integer.valueOf(a.charAt(i)) + Integer.valueOf(a.charAt(i)));
        }

    }

}
