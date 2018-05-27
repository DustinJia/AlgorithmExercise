package LintCode;

// https://www.lintcode.com/problem/next-permutation/description

/**
 * Given a list of integers, which denote a permutation, find the next permutation in ascending order.
 * Notice
 *   The list may contains duplicate integers.
 */

/**
 * Example
 * For [1,3,2,3], the next permutation is [1,3,3,2]
 * For [4,3,2,1], the next permutation is [1,2,3,4]
 */

public class NextPermutation_52 {

    public int[] nextPermutation(int[] nums) {
        int length = nums.length;

        if (length < 2) {
            return nums;
        }

        int i = length - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }

        if (i > 0) {
            int j = length - 1;
            while (nums[j] <= nums[i - 1]) {
                j--;
            }
            swapItem(nums, i - 1, j);
        }
        swapList(nums, i);

        return nums;
    }

    private void swapItem(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void swapList(int[] nums, int i) {
        int j = nums.length - 1;
        while (i < j) {
            swapItem(nums, i, j);
            i++;
            j--;
        }
    }
}
