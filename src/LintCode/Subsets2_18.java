package LintCode;

// https://www.lintcode.com/problem/subsets-ii/description

/**
 * Given a list of numbers that may has duplicate numbers, return all possible subsets
 *
 * Notice
 *   Each element in a subset must be in non-descending order.
 *   The ordering between two subsets is free.
 *   The solution set must not contain duplicate subsets.
 */

/**
 * Example
 * If S = [1,2,2], a solution is:
 * [
 *  [2],
 *  [1],
 *  [1,2,2],
 *  [2,2],
 *  [1,2],
 *  []
 * ]
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets2_18 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();

        if (nums == null) {
            return result;
        }

        Arrays.sort(nums);

        dfs(nums, 0, new LinkedList<Integer>(), result);

        return result;
    }

    private void dfs(int[] nums, int startIndex, LinkedList<Integer> subset, List<List<Integer>> result) {
        result.add(new LinkedList<>(subset));

        for (int i = startIndex; i < nums.length; i++) {
            // Remove duplicates
            if (i > 0 && nums[i] == nums[i - 1] && i > startIndex) {
                continue;
            }
            subset.add(nums[i]);
            dfs(nums, i + 1, subset, result);
            subset.remove(subset.size() - 1);
        }
    }
}
