package Stack;

public class StackImplArray {

    public static void main(String[] args) {
        Stack sc = new Stack(5);

        sc.push(10);
        sc.push(20);
        sc.push(30);
        sc.push(40);
        sc.push(50);
        sc.push(60);
        System.out.println("peek : " + sc.peek());

        System.out.println("pop : " + sc.pop());
        System.out.println("pop : " + sc.pop());
        System.out.println("peek : " + sc.peek());
        System.out.println("pop : " + sc.pop());
        System.out.println("peek : " + sc.peek());
        System.out.println("pop : " + sc.pop());
        System.out.println("pop : " + sc.pop());
        System.out.println("peek : " + sc.peek());

    }

    static class Stack {

        private int[] st;
        private int top = -1;

        Stack(int n) {
            st = new int[n];
        }

        private void push(int element) {


            if (top >= st.length - 1) {
                System.out.println("Stack overflow");
                return;
            }

            top++;
            st[top] = element;
        }

        private int pop() {

            if (top < 0) {
                System.out.println("Stack underflow");
                return -1;
            }
            int ele = st[top];
            top--;

            return ele;
        }

        private int peek() {
            if (top >= 0)
                return st[top];

            return -1;
        }


    }
}
