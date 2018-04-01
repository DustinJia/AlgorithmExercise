package LintCode;

// http://www.lintcode.com/en/problem/balanced-binary-tree/

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 */

/**
 * Example
 * Given binary tree A = {3,9,20,#,#,15,7}, B = {3,#,20,15,7}
 *    A)  3            B)    3
 *       / \                  \
 *      9  20                 20
 *        /  \                / \
 *       15   7              15  7
 * The binary tree A is a height-balanced binary tree, but B is not.
 */


public class BalancedBinaryTree_93 {

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private int NOT_BALANCED = -1;

    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != NOT_BALANCED;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        if (left == NOT_BALANCED || right == NOT_BALANCED) {
            return NOT_BALANCED;
        }

        if (Math.abs(left - right) > 1) {
            return NOT_BALANCED;
        }

        return Math.max(left, right) + 1;
    }
}
