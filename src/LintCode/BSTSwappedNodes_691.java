package LintCode;

// http://www.lintcode.com/en/problem/bst-swapped-nodes/

/**
 * In a binary search tree, (Only) two nodes are swapped.
 * Find out these nodes and swap them. If there no node swapped, return original root of tree.
 */

/**
 * Example
 * Given a binary search tree:
 *     4
 *    / \
 *   5   2
 *  / \
 * 1   3
 * return
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 */

import java.util.ArrayList;

public class BSTSwappedNodes_691 {

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public TreeNode bstSwappedNode(TreeNode root) {
        if (root == null) {
            return root;
        }

        findSwappedNodes(root);
        swapNodes(root);

        return root;
    }

    Integer val1 = null;
    Integer val2 = null;
    ArrayList<Integer> values = new ArrayList<>();

    private void findSwappedNodes(TreeNode root) {
        if (root == null) {
            return;
        }

        getAscendingValues(root);

        Integer index1 = null;
        Integer index2 = null;

        for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i) > values.get(i + 1)) {
                if (index1 == null) {
                    index1 = i;
                } else {
                    index2 = i + 1;
                    break;
                }
            }
        }

        if (index1 != null) {
            val1 = values.get(index1);

            if (index2 != null) {
                val2 = values.get(index2);
            } else {
                val2 = values.get(index1 + 1);  // Should swap the root and a child, not two children
            }
        }
    }

    private void getAscendingValues(TreeNode root) {
        if (root == null) {
            return;
        }

        getAscendingValues(root.left);
        values.add(root.val);
        getAscendingValues(root.right);
    }

    private void swapNodes(TreeNode root) {
        if (root == null || val1 == null || val2 == null) {
            return;
        }

        swapNodes(root.left);

        if (root.val == val1) {
            root.val = val2;
        } else if (root.val == val2) {
            root.val = val1;
        }

        swapNodes(root.right);
    }
}
