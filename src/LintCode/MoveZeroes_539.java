package LintCode;

// http://www.lintcode.com/en/problem/move-zeroes/

/**
 * Given an array nums,
 * write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Notice
 *   1. You must do this in-place without making a copy of the array.
 *   2. Minimize the total number of operations.
 */

/**
 * Example
 * Given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 */

public class MoveZeroes_539 {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                swap(nums, slow, fast);
                slow++;
            }
            fast++;
        }
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
