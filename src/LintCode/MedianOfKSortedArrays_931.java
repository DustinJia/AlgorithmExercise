package LintCode;

// https://www.lintcode.com/problem/median-of-k-sorted-arrays/description

/**
 * There are k sorted arrays nums. Find the median of the given k sorted arrays.
 * Notice
 *   The length of the given arrays may not equal to each other.
 *   The elements of the given arrays are all positive number.
 *   Return 0 if there are no elements in the array.
 */

/**
 * Example
 * Given nums = [[1],[2],[3]], return 2.00.
 */

public class MedianOfKSortedArrays_931 {

    public double findMedian(int[][] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Get the total numbers count
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i].length;
        }

        if (count == 0) {
            return 0;
        }

        if (count % 2 == 0) {
            return (findKthLargest(nums, count / 2) + findKthLargest(nums, count / 2 + 1)) / 2.0;
        } else {
            return findKthLargest(nums, count / 2 + 1);
        }
    }

    private int findKthLargest(int[][] nums, int k) {  // k starts from 1
        int start = 0, end = Integer.MAX_VALUE;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (getGTECount(nums, mid) >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (getGTECount(nums, start) >= k) {
            return start;
        } else {
            return end;
        }
    }

    // Calculate how many numbers in nums are greater or equal to target
    private int getGTECount(int[][] nums, int target) {
        int sum = 0;

        for (int row = 0; row < nums.length; row++) {
            int[] numbers = nums[row];

            if (numbers == null || numbers.length == 0) {
                continue;
            }

            // Get the first position that its value is greater or equal to target
            int start = 0, end = numbers.length - 1;

            while (start + 1 < end) {
                int mid = start + (end - start) / 2;

                if (numbers[mid] >= target) {
                    end = mid;
                } else {
                    start = mid;
                }
            }

            if (numbers[start] >= target) {
                sum += numbers.length - start;
                continue;
            }
            if (numbers[end] >= target) {
                sum += numbers.length - end;
                continue;
            }
        }

        return sum;
    }
}
