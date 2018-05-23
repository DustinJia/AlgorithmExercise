package LintCode;

// https://www.lintcode.com/problem/combinations/description

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * Notice
 *   You don't need to care the order of combinations, but you should make sure the numbers in a combination are sorted.
 */

/**
 * Example
 * Given n = 4 and k = 2, a solution is:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4]
 * ]
 */

import java.util.LinkedList;
import java.util.List;

public class Combinations_152 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        dsp(1, n, k, new LinkedList<Integer>(), result);
        return result;
    }

    private void dsp(int start, int n, int k, LinkedList<Integer> solution, List<List<Integer>> result) {
        if (solution.size() == k) {
            result.add(new LinkedList<>(solution));
            return;
        }

        for (int i = start; i <= n; i++) {
            solution.add(i);
            dsp(i + 1, n, k, solution, result);
            solution.remove(solution.size() - 1);
        }
    }
}
