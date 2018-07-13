package LintCode;

// https://www.lintcode.com/problem/minimum-subarray/description

/**
 * Given an array of integers, find the subarray with smallest sum. Return the sum of the subarray.
 * Notice
 *   The subarray should contain at least one number.
 */

/**
 * Example
 * For [1, -1, -2, 1], return -3.
 */

import java.util.List;

public class MinimumSubarray_44 {

    public int minSubArray(List<Integer> nums) {
        if (nums == null || nums.isEmpty()) {
            return 0;
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int maxSum = 0;

        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            min = Math.min(min, sum - maxSum);
            maxSum = Math.max(maxSum, sum);
        }

        return min;
    }
}
