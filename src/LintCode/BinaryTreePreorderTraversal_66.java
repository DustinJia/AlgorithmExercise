package LintCode;

// http://www.lintcode.com/en/problem/binary-tree-preorder-traversal/

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 */

/**
 * Example
 * Given:
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * return [1,2,4,5,3].
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal_66 {

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }

}
