package LintCode;

// http://www.lintcode.com/en/problem/window-sum/

/**
 * Given an array of n integer, and a moving window(size k), move the window at each iteration from the start of the array,
 * find the sum of the element inside the window at each moving.
 */

/**
 * Example
 * For array [1,2,7,8,5], moving window size k = 3.
 * 1 + 2 + 7 = 10
 * 2 + 7 + 8 = 17
 * 7 + 8 + 5 = 20
 * return [10,17,20]
 */


public class WindowSum_604 {

    public int[] winSum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        if (nums.length < k) {
            return null;
        }

        int[] sumArray = new int[nums.length - k + 1];
        int firstSum = 0;
        for (int i = 0; i < k; i++) {
            firstSum += nums[i];
        }
        sumArray[0] = firstSum;

        if (nums.length > k) {
            for (int i = 1; i <= nums.length - k; i++) {
                firstSum -= nums[i - 1];
                firstSum += nums[i + k - 1];
                sumArray[i] = firstSum;
            }
        }

        return sumArray;
    }
}
