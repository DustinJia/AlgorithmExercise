package LintCode;

// http://www.lintcode.com/en/problem/3sum/

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Notice
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 */

/**
 * Example
 * For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_57 {

    public List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> results = new ArrayList<>();

        if (numbers == null || numbers.length < 3) {
            return results;
        }

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int target = -numbers[i];
            twoSum(numbers, i + 1, numbers.length - 1, target, results);
        }

        return results;
    }

    private List<List<Integer>> twoSum(int[] sortedNums, int left, int right, int target, List<List<Integer>> results) {
        while (left < right) {
            if (sortedNums[left] + sortedNums[right] == target) {
                List<Integer> result = Arrays.asList(-target, sortedNums[left], sortedNums[right]);
                results.add(result);

                left++;
                right--;

                while (left < right && sortedNums[left] == sortedNums[left - 1]) {
                    left++;
                }
                while (left < right && sortedNums[right] == sortedNums[right + 1]) {
                    right--;
                }
            } else if (sortedNums[left] + sortedNums[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        return results;
    }
}
