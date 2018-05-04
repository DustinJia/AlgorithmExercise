package LintCode;

// https://www.lintcode.com/problem/binary-search-tree-iterator/description

/**
 * Design an iterator over a binary search tree with the following rules:
 *   Elements are visited in ascending order (i.e. an in-order traversal)
 *   next() and hasNext() queries run in O(1) time in average.
 */

import java.util.Stack;

/**
 * Example
 * For the following binary search tree, in-order traversal by using iterator is [1, 6, 10, 11, 12]
 *    10
 *  /    \
 * 1      11
 *  \       \
 *   6       12
 */

public class BinarySearchTreeIterator_86 {

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    Stack<TreeNode> stack = new Stack<>();

    public BinarySearchTreeIterator_86(TreeNode root) {
        TreeNode node = root;

        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public TreeNode next() {
        TreeNode cur = stack.peek();
        TreeNode node = cur;

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

        return cur;
    }
}
