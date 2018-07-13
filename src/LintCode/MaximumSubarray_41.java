package LintCode;

// https://www.lintcode.com/problem/maximum-subarray/description

/**
 * Given an array of integers, find a contiguous subarray which has the largest sum.
 * Notice
 *   The subarray should contain at least one number.
 */

/**
 * Example
 * Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */

public class MaximumSubarray_41 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int minSum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }

        return max;
    }
}
