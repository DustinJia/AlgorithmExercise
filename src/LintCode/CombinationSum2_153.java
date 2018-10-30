package LintCode;

// https://www.lintcode.com/problem/combination-sum-ii/description

/**
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.

 *
 * Notice
 *   All numbers (including target) will be positive integers.
 *   Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 *   The solution set must not contain duplicate combinations.
 */

/**
 * Example
 * Given candidate set [10,1,6,7,2,1,5] and target 8,
 * A solution set is:
 * [
 *  [1,7],
 *  [1,2,5],
 *  [2,6],
 *  [1,1,6]
 *  ]
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2_153 {

    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new LinkedList<>();

        if (num == null) {
            return result;
        }

        Arrays.sort(num);

        dsp(num, 0, target, new LinkedList<Integer>(), result);

        return result;
    }

    private void dsp(int[] num,
                     int startIndex,
                     int target,
                     LinkedList<Integer> subset,
                     List<List<Integer>> result) {
        if (target == 0) {
            result.add(new LinkedList<>(subset));
            return;
        }

        for (int i = startIndex; i < num.length; i++) {
            if (num[i] <= target) {
                // Remove duplicates
                if (i > startIndex && num[i] == num[i - 1]) {
                    continue;
                }

                subset.add(num[i]);
                dsp(num, i + 1, target - num[i], subset, result);
                subset.remove(subset.size() - 1);
            }
        }
    }
}
