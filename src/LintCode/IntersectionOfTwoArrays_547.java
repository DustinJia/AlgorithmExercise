package LintCode;

// https://www.lintcode.com/problem/intersection-of-two-arrays/description

/**
 * Given two arrays, write a function to compute their intersection.
 * Notice
 *   Each element in the result must be unique.
 *   The result can be in any order.
 */

/**
 * Example
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2]
 */

import java.util.Arrays;

public class IntersectionOfTwoArrays_547 {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        int k = 0;
        int[] intersections = new int[nums1.length];

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (k == 0 || intersections[k - 1] != nums1[i]) {
                    intersections[k++] = nums1[i];
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] result = new int[k];
        for (int l = 0; l < k; l++) {
            result[l] = intersections[l];
        }

        return result;
    }
}
