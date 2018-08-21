package LintCode;

// https://www.lintcode.com/problem/binary-search-tree-iterator/description

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 *
 * Notice
 *   Given target value is a floating point.
 *   You are guaranteed to have only one unique value in the BST that is closest to the target.
 */

/**
 * Example
 * Given root = {1}, target = 4.428571, return 1.
 */

public class ClosestBinarySearchTreeValue_900 {

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public int closestValue(TreeNode root, double target) {
        TreeNode lowerNode = lowerBound(root, target);
        TreeNode upperNode = upperBound(root, target);

        if (lowerNode == null) {
            return upperNode.val;
        } else if (upperNode == null) {
            return lowerNode.val;
        }

        if (target - lowerNode.val > upperNode.val - target) {
            return upperNode.val;
        } else {
            return lowerNode.val;
        }
    }

    private TreeNode lowerBound(TreeNode root, double target) {
        if (root == null) {
            return root;
        }

        if (target <= root.val) {
            return lowerBound(root.left, target);
        } else {
            TreeNode lowerNode = lowerBound(root.right, target);
            if (lowerNode != null) {
                return lowerNode;
            }
        }

        return root;
    }

    private TreeNode upperBound(TreeNode root, double target) {
        if (root == null) {
            return root;
        }

        if (target >= root.val) {
            return upperBound(root.right, target);
        } else {
            TreeNode uppderNode = upperBound(root.left, target);
            if (uppderNode != null) {
                return uppderNode;
            }
        }

        return root;
    }
}
