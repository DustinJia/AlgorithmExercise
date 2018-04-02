package LintCode;

// http://www.lintcode.com/en/problem/binary-tree-inorder-traversal/

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 */

/**
 * Example
 * Given binary tree {1,#,2,3},
 *     1
 *      \
 *       2
 *      /
 *     3
 * return [1,3,2].
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_67 {

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            result.add(node.val);

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

        return result;
    }

}
