package LintCode;

// http://www.lintcode.com/en/problem/find-k-closest-elements/

/**
 * Given a target number, a non-negative integer target and an integer array A sorted in ascending order,
 * find the k closest numbers to target in A, sorted in ascending order by the difference between the number and target.
 * Otherwise, sorted in ascending order by number if the difference is same.
 */

/**
 * Example
 * Given A = [1, 2, 3], target = 2 and k = 3, return [2, 1, 3].
 * Given A = [1, 4, 6, 8], target = 3 and k = 3, return [4, 1, 6].
 */

import java.util.ArrayList;

public class FindKClosestElements_460 {

    public static int[] kClosestNumbers(int[] A, int target, int k) {
        if (A == null || A.length == 0 || k > A.length) {
            return A;
        }

        int start = 0, end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (Math.abs(A[mid] - target) < Math.abs(A[mid + 1] - target)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        int minIndex = Math.abs(A[start] - target) <= Math.abs(A[end] - target) ? start : end;

        int i = minIndex, j = minIndex;
        ArrayList<Integer> results = new ArrayList<>();

        while (results.size() < k) {
            if (i < 0) {
                results.add(A[j++]);
                continue;
            }
            if (j >= A.length) {
                results.add(A[i--]);
                continue;
            }

            if (Math.abs(A[i] - target) < Math.abs(A[j] - target)) {
                results.add(A[i]);
                --i;
            } else if (Math.abs(A[i] - target) > Math.abs(A[j] - target)) {
                results.add(A[j]);
                ++j;
            } else {
                results.add(A[i]);
                --i;
                if (i + 1 == j) {
                    ++j;
                }
            }
        }

        return results.stream().mapToInt(Integer::intValue).toArray();
    }
}
