package LintCode;

// https://www.lintcode.com/problem/implement-stack/description

/**
 * Implement a stack. You can use any data structure inside a stack except stack itself to implement it.
 */

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Example
 * push(1)
 * pop()
 * push(2)
 * top()  // return 2
 * pop()
 * isEmpty() // return true
 * push(3)
 * isEmpty() // return false
 */

public class ImplementStackByTwoQueues_494 {

    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();

    public void push(int x) {
        queue1.offer(x);
    }

    public void pop() {
        moveItems();
        queue1.poll();
        swapQueues();
    }

    public int top() {
        moveItems();
        int last = queue1.poll();
        swapQueues();
        queue1.offer(last);

        return last;
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    private void moveItems() {
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
    }

    private void swapQueues() {
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
}
