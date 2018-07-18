package LintCode;

// https://www.lintcode.com/problem/range-sum-query-mutable/description

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * Notice
 *   1.The array is only modifiable by the update function.
 *   2.You may assume the number of calls to update and sumRange function is distributed evenly.
 */

/**
 * Example
 * Given nums = [1, 3, 5]
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 */

public class RangeSumQuery_840 {

    class SegmentTreeNode {
        int start, end, sum;
        SegmentTreeNode left, right;

        SegmentTreeNode (int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            left = null;
            right = null;
        }
    }

    SegmentTreeNode root;

    public RangeSumQuery_840(int[] nums) {
        root = build(nums, 0, nums.length - 1);
    }

    public void update(int i, int val) {
        modifySegmentTree(root, i, val);
    }

    public int sumRange(int i, int j) {
        return querySegmentTree(root, i, j);
    }

    //region Segment Tree
    SegmentTreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new SegmentTreeNode(start, end, nums[start]);
        }

        SegmentTreeNode node = new SegmentTreeNode(start, end, 0);

        int mid = start + (end - start) / 2;
        node.left = build(nums, start, mid);
        node.right = build(nums, mid + 1, end);
        node.sum = node.left.sum + node.right.sum;

        return node;
    }

    int querySegmentTree(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end) {
            return root.sum;
        }

        int mid = root.start + (root.end - root.start) / 2;
        int sum = 0;

        if (start <= mid) {
            sum += querySegmentTree(root.left, start, Integer.min(mid, end));
        }
        if (mid + 1 <= end) {
            sum += querySegmentTree(root.right, Integer.max(start, mid + 1), end);
        }

        return sum;
    }

    void modifySegmentTree(SegmentTreeNode root, int index, int value) {
        if (root.start == index && root.end == index) {
            root.sum = value;
            return;
        }

        int mid = root.start + (root.end - root.start) / 2;
        if (index <= mid) {
            modifySegmentTree(root.left, index, value);
        } else {
            modifySegmentTree(root.right, index, value);
        }

        root.sum = root.left.sum + root.right.sum;
    }
    //endregion
}
