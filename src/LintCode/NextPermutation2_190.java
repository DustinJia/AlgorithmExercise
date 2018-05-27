package LintCode;

// https://www.lintcode.com/problem/next-permutation-ii/description

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 */

/**
 * Example
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */

public class NextPermutation2_190 {

    public void nextPermutation(int[] nums) {
        int length = nums.length;

        if (length < 2) {
            return;
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
