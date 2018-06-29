package LintCode;

// https://www.lintcode.com/problem/implement-stack/description

/**
 * Implement a stack. You can use any data structure inside a stack except stack itself to implement it.
 */

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

import java.util.ArrayList;

public class ImplementStack_495 {

    private ArrayList<Integer> stackArray = new ArrayList<>();

    /*
     * @param x: An integer
     * @return: nothing
     */
    public void push(int x) {
        stackArray.add(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        if (!stackArray.isEmpty()) {
            stackArray.remove(stackArray.size() - 1);
        }
    }

    /*
     * @return: An integer
     */
    public int top() {
        return stackArray.get(stackArray.size() - 1);
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        return stackArray.isEmpty();
    }
}
