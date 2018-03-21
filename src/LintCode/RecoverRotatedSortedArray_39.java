package LintCode;

// http://www.lintcode.com/en/problem/recover-rotated-sorted-array/

/**
 * Given a rotated sorted array, recover it to sorted array in-place.
 *
 * Clarification: What is rotated array?
 * For example,
 * the original array is [1,2,3,4], The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
 */

/**
 * Example
 * [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
 */

import java.util.Arrays;
import java.util.List;

public class RecoverRotatedSortedArray_39 {

    public static void recoverRotatedSortedArray(List<Integer> nums) {
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i+1)) {
                reverse(nums, 0, i);
                reverse(nums, i + 1, nums.size() - 1);
                reverse(nums, 0, nums.size() - 1);
                break;
            }
        }
    }

    static void reverse(List<Integer> list, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }

}