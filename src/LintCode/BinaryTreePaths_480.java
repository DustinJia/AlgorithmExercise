package LintCode;

// https://www.lintcode.com/en/problem/binary-tree-paths/

/**
 * Given a binary tree, return all root-to-leaf paths.
 */

/**
 * Example
 *
 * Given the following binary tree:
 *    1
 *  /  \
 * 2    3
 *  \
 *   5
 * All root-to-leaf paths are:
 * [
 *  "1->2->5",
 *  "1->3"
 * ]
 */

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths_480 {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();

        if (root != null) {
            traverseBinaryTree(root, String.valueOf(root.val), result);
        }

        return result;
    }

    private void traverseBinaryTree(TreeNode root, String path, List<String> result) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        if (root.left != null) {
            traverseBinaryTree(root.left, path + "->" + String.valueOf(root.left.val), result);
        }
        if (root.right != null) {
            traverseBinaryTree(root.right, path + "->" + String.valueOf(root.right.val), result);
        }
    }
}
