package LintCode;

// https://www.lintcode.com/problem/permutations/description

/**
 * Given a list of numbers, return all possible permutations.
 * Notice
 *   You can assume that there is no duplicate numbers in the list.
 */

/**
 * Example
 *
 * For nums = [1,2,3], the permutations are:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 *  ]
 */

import java.util.LinkedList;
import java.util.List;

public class Permutations_15 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();

        if (nums == null) {
            return result;
        }

        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, new LinkedList<Integer>(), result);

        return result;
    }

    private void dfs(int[] nums, boolean[] visited, LinkedList<Integer> permutation, List<List<Integer>> result) {
        if (permutation.size() == nums.length) {
            result.add(new LinkedList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, permutation, result);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
    }
}
