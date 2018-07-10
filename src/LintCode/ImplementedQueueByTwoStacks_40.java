package LintCode;

// https://www.lintcode.com/problem/implement-queue-by-two-stacks/description

/**
 * As the title described, you should only use two stacks to implement a queue's actions.
 * The queue should support push(element), pop() and top() where pop is pop the first(a.k.a front) element in the queue.
 * Both pop and top methods should return the value of first element.
 */

/**
 * Example
 * push(1)
 * pop()     // return 1
 * push(2)
 * push(3)
 * top()     // return 2
 * pop()     // return 2
 */

import java.util.Stack;

public class ImplementedQueueByTwoStacks_40 {

    Stack<Integer> stack1, stack2;

    public ImplementedQueueByTwoStacks_40() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int element) {
        stack2.push(element);
    }

    public int pop() {
        if (stack1.isEmpty()) {
            stack2ToStack1();
        }
        return stack1.pop();
    }

    public int top() {
        if (stack1.isEmpty()) {
            stack2ToStack1();
        }
        return stack1.peek();
    }

    private void stack2ToStack1() {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }
}
