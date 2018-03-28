package LintCode;

// http://www.lintcode.com/en/problem/two-sum-input-array-is-sorted/

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * Notice
 * You may assume that each input would have exactly one solution.
 */

/**
 * Example
 * Given nums = [2, 7, 11, 15], target = 9
 * return [1, 2]
 */


public class TwoSum_InputArrayIsSorted_608 {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        int start = 0, end = nums.length - 1;

        while (start < end) {
            if (nums[start] + nums[end] == target) {
                return new int[]{ start + 1, end + 1 };
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else {
                end--;
            }
        }

        return null;
    }
}
