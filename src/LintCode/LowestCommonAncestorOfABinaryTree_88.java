package LintCode;

// https://www.lintcode.com/en/problem/lowest-common-ancestor-of-a-binary-tree/

/**
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
 * The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 *
 * Notice
 *   Assume two nodes are exist in tree.
 */

/**
 * Example
 * For the following binary tree:
 *    4
 *   / \
 *  3   7
 *     / \
 *    5   6
 * LCA(3, 5) = 4
 * LCA(5, 6) = 7
 * LCA(6, 7) = 7
 */

public class LowestCommonAncestorOfABinaryTree_88 {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || root == A || root == B) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }

        return null;
    }
}
