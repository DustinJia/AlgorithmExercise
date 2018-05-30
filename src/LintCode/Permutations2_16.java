package LintCode;

// https://www.lintcode.com/problem/permutations-ii/description

/**
 * Given a list of numbers with duplicate number in it. Find all unique permutations.
 */

/**
 * Example
 *
 * For numbers [1,2,2] the unique permutations are:
 * [
 *   [1,2,2],
 *   [2,1,2],
 *   [2,2,1]
 * ]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2_16 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null) {
            return result;
        }

        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, new ArrayList<Integer>(), result);

        return result;
    }

    private void dfs(int[] nums, boolean[] visited, ArrayList<Integer> permutation, List<List<Integer>> result) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
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
