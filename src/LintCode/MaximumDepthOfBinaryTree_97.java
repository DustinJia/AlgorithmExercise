package LintCode;

// http://www.lintcode.com/en/problem/maximum-depth-of-binary-tree/

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

/**
 * Example
 * Given a binary tree as follow:
 *    1
 *   / \
 *  2  3
 *    / \
 *   4  5
 * The maximum depth is 3.
 */


public class MaximumDepthOfBinaryTree_97 {

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    //region Divide & Conquer
    public int maxDepth_DivideConquer(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth_DivideConquer(root.left);
        int right = maxDepth_DivideConquer(root.right);
        return Math.max(left, right) + 1;
    }
    //endregion

    //region Traversal
    private int depth;

    public int maxDepth_Traversal(TreeNode root) {
        depth = 0;
        traverse(root, 1);
        return depth;
    }

    private void traverse(TreeNode node, int curDepth) {
        if (node == null) {
            return;
        }

        depth = Math.max(depth, curDepth);
        traverse(node.left, curDepth + 1);
        traverse(node.right, curDepth + 1);
    }
    //endregion

}
