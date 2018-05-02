package LintCode;

// https://www.lintcode.com/en/problem/minimum-subtree/

/**
 * Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.
 *
 *  Notice
 *    LintCode will print the subtree which root is your return node.
 *    It's guaranteed that there is only one subtree with minimum sum and the given binary tree is not an empty tree.
 */

/**
 * Example
 *
 * Given a binary tree:
 *      1
 *    /   \
 *  -5     2
 *  / \   / \
 * 0  2 -4  -5
 * return the node 1.
 */

public class MinimumSubtree_596 {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    TreeNode targetNode = null;
    int minSum = Integer.MAX_VALUE;

    public TreeNode findSubtree(TreeNode root) {
        minSum = traverseHelper(root);
        return targetNode;
    }

    private int traverseHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = traverseHelper(root.left);
        int rightSum = traverseHelper(root.right);
        int sum = leftSum + rightSum + root.val;

        if (sum < minSum) {
            minSum = sum;
            targetNode = root;
        }

        return sum;
    }
}
