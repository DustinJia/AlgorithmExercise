package LintCode;

// https://www.lintcode.com/problem/lowest-common-ancestor-iii/description

/**
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
 * The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 * Return null if LCA does not exist.
 *
 * Notice
 *   node A or node B may not exist in tree.
 */

/**
 * Example
 * For the following binary tree:
 *
 *   4
 *  / \
 * 3  7
 *   / \
 *  5   6
 * LCA(3, 5) = 4
 * LCA(5, 6) = 7
 * LCA(6, 7) = 7
 */

public class LowestCommonAncestor3_578 {

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    class Result {
        public TreeNode node;
        public boolean aExists;
        public boolean bExists;

        public Result(TreeNode node, boolean aExists, boolean bExists) {
            this.node = node;
            this.aExists = aExists;
            this.bExists = bExists;
        }
    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        Result result = lowestCommonAncestor(root, A, B);

        if (result.aExists && result.bExists) {
            return result.node;
        }
        return null;
    }

    private Result lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new Result(null, false, false);
        }

        Result leftResult = lowestCommonAncestor(root.left, A, B);
        Result rightResult = lowestCommonAncestor(root.right, A, B);

        boolean aExists = root == A || leftResult.aExists || rightResult.aExists;
        boolean bExists = root == B || leftResult.bExists || rightResult.bExists;

        // Root is A or B
        if (root == A || root == B) {
            return new Result(root, aExists, bExists);
        }

        // Root is LCA of sub node A and B
        if (leftResult.node != null && rightResult.node != null) {
            return new Result(root, aExists, bExists);
        }
        // LCA is in the left sub tree
        if (leftResult.node != null) {
            return new Result(leftResult.node, aExists, bExists);
        }
        // LCA is in the right sub tree
        if (rightResult.node != null) {
            return new Result(rightResult.node, aExists, bExists);
        }

        return new Result(null, aExists, bExists);
    }
}
