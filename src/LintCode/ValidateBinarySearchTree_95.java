package LintCode;

// http://www.lintcode.com/en/problem/validate-binary-search-tree/

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 *   The left subtree of a node contains only nodes with keys less than the node's key.
 *   The right subtree of a node contains only nodes with keys greater than the node's key.
 *   Both the left and right subtrees must also be binary search trees.
 *   A single node tree is a BST
 */

/**
 * Example
 * An example:
 *    2
 *   / \
 *  1   4
 *     / \
 *    3   5
 * The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).
 */


public class ValidateBinarySearchTree_95 {

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    //region Inorder Traversal
    private TreeNode lastNode;
    private boolean isValid;

    public boolean isValidBST(TreeNode root) {
        lastNode = null;
        isValid = true;
        inorderTraverse(root);

        return isValid;
    }

    private void inorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraverse(root.left);
        if (lastNode != null && lastNode.val >= root.val) {
            isValid = false;
            return;
        }
        lastNode = root;

        inorderTraverse(root.right);
    }
    //endregion

    //region Divide & Conquer
    class ResultType {
        public boolean isBST;
        public TreeNode maxNode, minNode;

        public ResultType(boolean isBST) {
            this.isBST = isBST;
            this.maxNode = null;
            this.minNode = null;
        }
    }

    public boolean isValidBST_DivideConquer(TreeNode root) {
        return divideConquer(root).isBST;
    }

    private ResultType divideConquer(TreeNode root) {
        if (root == null) {
            return new ResultType(true);
        }

        ResultType left = divideConquer(root.left);
        ResultType right = divideConquer(root.right);

        if (!left.isBST || !right.isBST) {
            return new ResultType(false);
        }
        if (left.maxNode != null && left.maxNode.val >= root.val) {
            return new ResultType(false);
        }
        if (right.minNode != null && right.minNode.val <= root.val) {
            return new ResultType(false);
        }

        // Is BST
        ResultType result = new ResultType(true);
        result.minNode = left.minNode != null ? left.minNode : root;
        result.maxNode = right.maxNode != null ? right.maxNode : root;

        return result;
    }
    //endregion
}
