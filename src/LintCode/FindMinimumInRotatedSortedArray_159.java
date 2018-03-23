package LintCode;

// http://www.lintcode.com/en/problem/find-minimum-in-rotated-sorted-array/

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 *
 * Notice
 * You may assume no duplicate exists in the array.
 */

/**
 * Example
 * Given [4, 5, 6, 7, 0, 1, 2] return 0
 */


public class FindMinimumInRotatedSortedArray_159 {

    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        int target = nums[end];

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] <= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return Math.min(nums[start], nums[end]);
    }
}
