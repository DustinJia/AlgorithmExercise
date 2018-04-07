package LintCode;

// http://www.lintcode.com/en/problem/insert-node-in-a-binary-search-tree/

/**
 * Given a binary search tree and a new tree node, insert the node into the tree.
 * You should keep the tree still be a valid binary search tree.
 *
 * Notice
 * You can assume there is no duplicate values in this tree + node.
 */

/**
 * Example
 * Given binary search tree as follow, after Insert node 6, the tree should be:
 *     2             2
 *    / \           / \
 *   1   4   -->   1   4
 *      /             / \
 *     3             3   6
 */


public class InsertNodeInABinarySearchTree_85 {

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }

        if (root.val > node.val) {
            root.left = insertNode(root.left, node);
        } else if (root.val < node.val) {
            root.right = insertNode(root.right, node);
        }

        return root;
    }
}
