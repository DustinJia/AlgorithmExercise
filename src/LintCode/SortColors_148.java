package LintCode;

// http://www.lintcode.com/en/problem/sort-colors/

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Notice
 * You are not suppose to use the library's sort function for this problem.
 * You should do it in-place (sort numbers in the original array).
 */

/**
 * Example
 * Given [1, 0, 1, 2], sort it in-place to [0, 1, 1, 2].
 */


public class SortColors_148 {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int left = 0, right = nums.length - 1;
        int index = 0;

        while (index <= right) {
            if (nums[index] == 0) {
                swap(nums, left, index);
                ++left;
                ++index;
            } else if (nums[index] == 1) {
                ++index;
            } else {
                swap(nums, right, index);
                --right;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
