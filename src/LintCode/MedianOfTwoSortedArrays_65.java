package LintCode;

// https://www.lintcode.com/problem/median-of-two-sorted-arrays/description

/**
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
 */

/**
 * Example
 * Given A=[1,2,3,4,5,6] and B=[2,3,4,5], the median is 3.5.
 * Given A=[1,2,3] and B=[4,5], the median is 3.
 */

public class MedianOfTwoSortedArrays_65 {

    public double findMedianSortedArrays(int[] A, int[] B) {
        int aLength = A.length;
        int bLength = B.length;

        if ((aLength + bLength) % 2 == 0) {
            return (kthSmallest(A, 0, B, 0, (aLength + bLength) / 2) +
                    kthSmallest(A, 0, B, 0, (aLength + bLength) / 2 + 1)) / 2.0;
        } else {
            return kthSmallest(A, 0, B, 0, (aLength + bLength) / 2 + 1);
        }
    }

    private int kthSmallest(int[] A, int aStart,
                            int[] B, int bStart,
                            int k) {
        if (aStart >= A.length) {
            return B[bStart + k - 1];
        }
        if (bStart >= B.length) {
            return A[aStart + k - 1];
        }

        if (k <= 1) {
            return Math.min(A[aStart], B[bStart]);
        }

        int halfA = aStart + k / 2 - 1 < A.length ? A[aStart + k / 2 - 1] : Integer.MAX_VALUE;
        int halfB = bStart + k / 2 - 1 < B.length ? B[bStart + k / 2 - 1] : Integer.MAX_VALUE;

        if (halfA < halfB) {
            return kthSmallest(A, aStart + k / 2,
                               B, bStart,
                               k - k / 2);
        } else {
            return kthSmallest(A, aStart,
                               B, bStart + k / 2,
                               k - k / 2);
        }
    }
}
