package LintCode;

// https://www.lintcode.com/problem/subsets/description

/**
 * Given a set of distinct integers, return all possible subsets.
 *
 * Notice
 *   Elements in a subset must be in non-descending order.
 *   The solution set must not contain duplicate subsets.
 */

/**
 * Example
 * If S = [1,2,3], a solution is:
 * [
 *  [3],
 *  [1],
 *  [2],
 *  [1,2,3],
 *  [1,3],
 *  [2,3],
 *  [1,2],
 *  []
 * ]
 */

import java.util.*;

public class Subsets_17 {

    //region BFS Solution
    public List<List<Integer>> subsets_BFS(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();

        if (nums == null) {
            return result;
        }

        // Sort numbers first
        Arrays.sort(nums);

        // Create queue
        Queue queue = new LinkedList();
        queue.offer(new LinkedList<>());

        // BFS
        while (!queue.isEmpty()) {
            List<Integer> subset = (List<Integer>) queue.poll();
            result.add(subset);

            for (int i = 0; i < nums.length; i++) {
                if (subset.size() == 0 || subset.get(subset.size() - 1) < nums[i]) {
                    List<Integer> set = new LinkedList<>(subset);  // Deep copy
                    set.add(nums[i]);
                    queue.offer(set);
                }
            }
        }

        return result;
    }
    //endregion

    //region DFS Solution
    public List<List<Integer>> subsets_DFS(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();

        // nums.length == 0 has a valid subset
        if (nums == null) {
            return result;
        }

        Arrays.sort(nums);

        dfs(nums, 0, new LinkedList<Integer>(), result);

        return result;
    }

    private void dfs(int[] nums, int index, LinkedList<Integer> subset, List<List<Integer>> result) {
        if (index >= nums.length) {
            result.add(new LinkedList<>(subset));  // Don't forget we need deep copy
            return;
        }

        // Select nums[index]
        subset.add(nums[index]);
        dfs(nums, index + 1, subset, result);

        // Ignore nums[index] -- remove the value we just added
        subset.remove(subset.size() - 1);
        dfs(nums, index + 1, subset, result);
    }
    //endregion

    //region Backtracking Solution
    public List<List<Integer>> subsets_BT(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();

        // nums.length == 0 has a valid subset
        if (nums == null) {
            return result;
        }

        Arrays.sort(nums);

        dfs_bt(nums, 0, new LinkedList<Integer>(), result);
        return result;
    }

    private void dfs_bt(int[] nums, int startIndex, LinkedList<Integer> subset, List<List<Integer>> result) {
        result.add(new LinkedList<>(subset));  // Deep copy

        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(nums, i + 1, subset, result);
            subset.remove(subset.size() - 1);  // Backtracking
        }
    }
    //endregion
}
