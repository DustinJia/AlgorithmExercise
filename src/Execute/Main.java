package Execute;

import java.util.Stack;

public class Main {

    class MinStack {

        Stack<Integer> stack;
        Stack<Integer> helperStack;

        public MinStack() {
            stack = new Stack<>();
            helperStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);

            if (helperStack.isEmpty()) {
                helperStack.push(x);
            } else {
                int min = Integer.min(helperStack.peek(), x);
                helperStack.push(min);
            }
        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
                helperStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return helperStack.peek();
        }
    }

    public static void main(String[] args) {

    }


}
