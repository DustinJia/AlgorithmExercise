package LintCode;

// http://www.lintcode.com/en/problem/search-range-in-binary-search-tree/

/**
 * Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree.
 * Find all the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST.
 * Return all the keys in ascending order.
 */

/**
 * Example
 * If k1 = 10 and k2 = 22, then your function should return [12, 20, 22].
 *     20
 *    /  \
 *   8   22
 *  / \
 * 4   12
 */

import java.util.ArrayList;
import java.util.List;

public class SearchRangeInBinarySearchTree_11 {

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private List<Integer> results = new ArrayList<>();

    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        if (root == null) {
            return results;
        }

        traverse(root, k1, k2);
        return results;
    }

    private void traverse(TreeNode root, int k1, int k2) {
        if (root == null) {
            return;
        }

        if (k1 < root.val) {
            traverse(root.left, k1, k2);
        }

        if (k1 <= root.val && root.val <= k2) {
            results.add(root.val);
        }

        if (root.val < k2) {
            traverse(root.right, k1, k2);
        }
    }

}
