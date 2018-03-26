package LintCode;

// http://www.lintcode.com/en/problem/two-sum-difference-equals-to-target/

/**
 * Given an array of integers, find two numbers that their difference equals to a target value.
 * where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2) are NOT zero-based.
 *
 * Notice
 * It's guaranteed there is only one available solution
 */

/**
 * Example
 * Given nums = [2, 7, 15, 24], target = 5
 * return [1, 2] (7 - 2 = 5)
 */

import java.util.Arrays;

public class TwoSum_DifferenceEqualsToTarget_610 {

    public static int[] twoSum7(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(nums[i], i);
        }
        Arrays.sort(pairs, Pair::compareTo);

        int j = 1;
        int absTarget = Math.abs(target);

        for (int i = 0; i < nums.length - 1; i++) {
            while (j < nums.length && pairs[j].value - pairs[i].value < absTarget || i == j) {
                ++j;
            }
            if (pairs[j].value - pairs[i].value == absTarget) {
                int minIndex = Math.min(pairs[i].index, pairs[j].index);
                int maxIndex = Math.max(pairs[i].index, pairs[j].index);
                return new int[]{minIndex + 1, maxIndex + 1};
            }
        }

        return null;
    }


    static class Pair implements Comparable<Pair> {

        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            if (value < o.value) {
                return -1;
            } else if (value == o.value) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
