package LintCode;

// http://www.lintcode.com/en/problem/sort-colors-ii/

/**
 * Given an array of n objects with k different colors (numbered from 1 to k),
 * sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.
 *
 * Notice
 * You are not suppose to use the library's sort function for this problem.
 * k <= n
 */

/**
 * Example
 * Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].
 */


public class SortColors2_143 {

    public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length < 2) {
            return;
        }

        rainbowSort(colors, 0, colors.length - 1, 1, k);  // 1. Recurse positions as long as colors
    }

    private void rainbowSort(int[] colors, int start, int end, int fromColor, int toColor) {
        if (fromColor == toColor || start >= end) {  // 2. Add color checking as a stop condition as well
            return;
        }

        int left = start, right = end;
        int pivot = (fromColor + toColor) / 2;

        while (left <= right) {
            while (left <= right && colors[left] <= pivot) {  // 3. <= pivot
                left++;
            }
            while (left <= right && colors[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int temp = colors[left];
                colors[left] = colors[right];
                colors[right] = temp;
                left++;
                right--;
            }
        }

        rainbowSort(colors, start, right, fromColor, pivot);  // 4. Halve the colors
        rainbowSort(colors, left, end, pivot + 1, toColor);
    }
}
