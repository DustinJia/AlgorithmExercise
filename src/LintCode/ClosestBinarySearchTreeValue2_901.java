package LintCode;

// https://www.lintcode.com/problem/closest-binary-search-tree-value-ii/description
/**
 * Description
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 *
 * Notice
 *   Given target value is a floating point.
 *   You may assume k is always valid, that is: k ≤ total nodes.
 *   You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 */

/**
 * Example
 * Given root = {1}, target = 0.000000, k = 1, return [1].
 */

import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ClosestBinarySearchTreeValue2_901 {

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> values = new LinkedList<>();

        if (k == 0) {
            return values;
        }

        // Create upper/lower stacks
        Stack<TreeNode> upperStack = getNodeStack(root, target);
        Stack<TreeNode> lowerStack = new Stack<>();
        lowerStack.addAll(upperStack);

        // Initialize the two stacks
        if (target < upperStack.peek().val) {
            moveLower(lowerStack);
        } else {
            moveUpper(upperStack);
        }

        for (int i = 0; i < k; i++) {
            if (lowerStack.isEmpty() ||
                    !upperStack.isEmpty() && (target - lowerStack.peek().val > upperStack.peek().val - target)) {
                values.add(upperStack.peek().val);
                moveUpper(upperStack);
            } else {
                values.add(lowerStack.peek().val);
                moveLower(lowerStack);
            }
        }

        return values;
    }

    Stack<TreeNode> getNodeStack(TreeNode root, double target) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;

        while (node != null) {
            stack.push(node);

            if (target < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return stack;
    }

    void moveUpper(Stack<TreeNode> stack) {
        TreeNode node = stack.peek();

        if (node.right == null) {
            node = stack.pop();
            while (!stack.isEmpty() && stack.peek().right == node) {
                node = stack.pop();
            }
        } else {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }

    void moveLower(Stack<TreeNode> stack) {
        TreeNode node = stack.peek();

        if (node.left == null) {
            node = stack.pop();
            while (!stack.isEmpty() && stack.peek().left == node) {
                node = stack.pop();
            }
        } else {
            node = node.left;
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
        }
    }
}
