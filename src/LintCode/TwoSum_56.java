package LintCode;

// http://www.lintcode.com/en/problem/two-sum/

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2) are zero-based.
 *
 * Notice
 * You may assume that each input would have exactly one solution.
 */

import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Example
 * numbers=[2, 7, 11, 15], target=9
 * return [0, 1]
 */


public class TwoSum_56 {

    public static int[] twoSum(int[] numbers, int target) {
        Tuple[] tuples = new Tuple[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            tuples[i] = new Tuple(numbers[i], i);
        }
        Arrays.sort(tuples, Tuple::compareTo);

        int start = 0, end = tuples.length - 1;
        while (start < end) {
            if (tuples[start].number + tuples[end].number == target) {
                int[] indexes = new int[2];
                int index1 = tuples[start].index;
                int index2 = tuples[end].index;
                indexes[0] = Math.min(index1, index2);
                indexes[1] = Math.max(index1, index2);
                return indexes;
            } else if (tuples[start].number + tuples[end].number < target) {
                ++start;
            } else {
                --end;
            }
        }

        return null;
    }


    private static class Tuple implements Comparable<Tuple> {

        public int number;
        public int index;

        public Tuple(int number, int index) {
            this.number = number;
            this.index = index;
        }

        @Override
        public int compareTo(Tuple o) {
            if (this.number < o.number) {
                return -1;
            } else if (this.number == o.number) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
