package LintCode;

// https://www.lintcode.com/problem/subarray-sum-closest/description

/**
 * Given an integer array, find a subarray with sum closest to zero.
 * Return the indexes of the first number and last number.
 * Notice
 *   There is at least one subarray that it's sum equals to zero.
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * Example
 * Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].
 */

public class SunarraySumClosest_139 {

    class Pair {
        int sum;
        int index;

        Pair(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }

    public int[] subarraySumClosest(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        if (nums.length == 1) {
            return new int[] { 0, 0 };
        }

        Pair[] sumPairs = new Pair[nums.length + 1];
        sumPairs[0] = new Pair(0, 0);

        for (int i = 1; i < nums.length + 1; i++) {
            sumPairs[i] = new Pair(sumPairs[i - 1].sum + nums[i - 1], i);
        }

        Arrays.sort(sumPairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair pair1, Pair pair2) {
                return pair1.sum - pair2.sum;
            }
        });

        int[] result = new int[2];
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < sumPairs.length; i++) {
            if (minDiff > sumPairs[i].sum - sumPairs[i - 1].sum) {
                minDiff = sumPairs[i].sum - sumPairs[i - 1].sum;

                int[] indices = new int[] { sumPairs[i - 1].index - 1, sumPairs[i].index - 1 };
                Arrays.sort(indices);
                result[0] = indices[0] + 1;
                result[1] = indices[1];
            }
        }

        return result;
    }
}
