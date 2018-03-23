package LintCode;

// http://www.lintcode.com/en/problem/search-in-rotated-sorted-array/

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 */

/**
 * Example
 * For [4, 5, 1, 2, 3] and target=1, return 2.
 * For [4, 5, 1, 2, 3] and target=0, return -1.
 */


public class SearchInRotatedSortedArray_62 {

    public static int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0, end = A.length - 1;
        int tempTarget = A[end];
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < tempTarget) {
                end = mid;
            } else {
                start = mid;
            }
        }

        int pivot = A[start] < tempTarget ? start : end;

        if (pivot > 0 && A[A.length - 1] < target) {
            start = 0;
            end = pivot - 1;
        } else {
            start = pivot;
            end = A.length - 1;
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }

        return -1;
    }
}
