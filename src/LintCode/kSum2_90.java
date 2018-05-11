package LintCode;

// https://www.lintcode.com/problem/k-sum-ii/description

/**
 * Your title here...Given n unique integers, number k (1<=k<=n) and target.
 * Find all possible k integers where their sum is target.
 */

/**
 * Example
 * Given [1,2,3,4], k = 2, target = 5. Return:
 * [
 *  [1,4],
 *  [2,3]
 * ]
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class kSum2_90 {

    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        List<List<Integer>> result = new LinkedList<>();

        if (A == null || target < 1) {
            return result;
        }

        Arrays.sort(A);

        dsp(A, 0, target, k, new LinkedList<Integer>(), result);

        return result;
    }

    private void dsp(int[] A,
                     int startIndex,
                     int target,
                     int k,
                     LinkedList<Integer> subset,
                     List<List<Integer>> result) {
        if (target == 0 && subset.size() == k) {
            result.add(new LinkedList<>(subset));
            return;
        }

        for (int i = startIndex; i < A.length; i++) {
            if (A[i] <= target && subset.size() < k) {
                subset.add(A[i]);
                dsp(A, i + 1, target - A[i], k, subset, result);
                subset.remove(subset.size() - 1);
            }
        }
    }
}
