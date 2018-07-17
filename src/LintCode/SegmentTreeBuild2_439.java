package LintCode;

// https://www.lintcode.com/problem/segment-tree-build-ii/description

/**
 * The structure of Segment Tree is a binary tree which each node has two attributes start and end denote an segment / interval.
 * start and end are both integers, they should be assigned in following rules:
 *   The root's start and end is given by build method.
 *   The left child of node A has start=A.left, end=(A.left + A.right) / 2.
 *   The right child of node A has start=(A.left + A.right) / 2 + 1, end=A.right.
 *   if start equals to end, there will be no children for this node.
 * Implement a build method with a given array, so that we can create a corresponding segment tree with every
 * node value represent the corresponding interval max value in the array, return the root of this segment tree.
 */

/**
 * Example
 * Given [3,2,1,4]. The segment tree will be:
 *                   [0,  3] (max = 4)
 *                    /            \
 *          [0,  1] (max = 3)      [2, 3]  (max = 4)
 *          /        \               /             \
 * [0, 0](max = 3)  [1, 1](max = 2)[2, 2](max = 1) [3, 3] (max = 4)
 */

public class SegmentTreeBuild2_439 {

    public class SegmentTreeNode {
        public int start, end, max;
        public SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end, int max) {
            this.start = start;
            this.end = end;
            this.max = max;
            this.left = null;
            this.right = null;
        }
    }

    public SegmentTreeNode build(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }

        return buildHelper(A, 0, A.length - 1);
    }

    private SegmentTreeNode buildHelper(int[] array, int start, int end) {
        if (start == end) {
            return new SegmentTreeNode(start, end, array[start]);
        }

        SegmentTreeNode node = new SegmentTreeNode(start, end, array[start]);

        int mid = start + (end - start) / 2;
        node.left = buildHelper(array, start, mid);
        node.right = buildHelper(array, mid + 1, end);

        if (node.left != null) {
            node.max = Integer.max(node.max, node.left.max);
        }
        if (node.right != null) {
            node.max = Integer.max(node.max, node.right.max);
        }

        return node;
    }
}
