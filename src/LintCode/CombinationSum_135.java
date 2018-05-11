package LintCode;

// https://www.lintcode.com/problem/combination-sum/description

/**
 * Given a set of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Notice
 *   All numbers (including target) will be positive integers.
 *   Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 *   The solution set must not contain duplicate combinations.
 */

/**
 * Example
 * Given candidate set [2,3,6,7] and target 7, a solution set is:
 * [7]
 * [2, 2, 3]
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum_135 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();

        if (candidates == null) {
            return result;
        }

        Arrays.sort(candidates);

        dsp(candidates, 0, target, new LinkedList<Integer>(), result);

        return result;
    }

    private void dsp(int[] candidates,
                     int startIndex,
                     int target,
                     LinkedList<Integer> subset,
                     List<List<Integer>> result) {
        if (target == 0) {
            result.add(new LinkedList<>(subset));
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                // Remove duplicates
                if (i > 0 && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                subset.add(candidates[i]);
                dsp(candidates, i, target - candidates[i], subset, result);
                subset.remove(subset.size() - 1);
            }
        }
    }
}
