package LintCode;

// https://www.lintcode.com/problem/merge-sorted-array/description

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Notice
 *   You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B.
 *   The number of elements initialized in A and B are m and n respectively.
 */

/**
 * Example
 * A = [1, 2, 3, empty, empty], B = [4, 5]
 * After merge, A will be filled as [1, 2, 3, 4, 5]
 */

public class MergeSortedArray_64 {

    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[index--] = A[i--];
            } else {
                A[index--] = B[j--];
            }
        }

        while (i >= 0) {
            A[index--] = A[i--];
        }
        while (j >= 0) {
            A[index--] = B[j--];
        }
    }
}
