package LintCode;

// http://www.lintcode.com/en/problem/kth-largest-element/

/**
 * Find K-th largest element in an array.
 *
 * Notice
 * You can swap elements in the array
 */

/**
 * Example
 * In array [9,3,2,4,8], the 3rd largest element is 4.
 * In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.
 */

public class KthLargestElement_5 {

    public int kthLargestElement(int k, int[] nums) {
        if (nums == null || k > nums.length) {
            return -1;
        }

        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }

        int left = start, right = end;
        int pivot = nums[(start + end) / 2];

        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                ++left;
            }
            while (left <= right && nums[right] < pivot) {
                --right;
            }

            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                ++left;
                --right;
            }
        }

        if (start + k - 1 <= right) {
            return quickSelect(nums, start, right, k);
        }
        if (start + k - 1 >= left) {
            return quickSelect(nums, left, end, k - (left - start));
        }
        return nums[right + 1];
    }
}
