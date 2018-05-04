package LintCode;

// https://www.lintcode.com/en/problem/kth-smallest-element-in-a-bst/

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Notice
 *   You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */

/**
 * Example
 * Given root = {1,#,2}, k = 2, return 2.
 */

public class KthSmallestElementInBST_902 {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    int result = 0;
    int count = 1;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        traverse(root.left, k);

        if (count++ == k) {
            result = root.val;
        }

        traverse(root.right, k);
    }
}
