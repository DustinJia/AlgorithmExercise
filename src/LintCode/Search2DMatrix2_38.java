package LintCode;

// http://www.lintcode.com/en/problem/search-a-2d-matrix-ii/#

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.
 *
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * Integers in each column are sorted from up to bottom.
 * No duplicate integers in each row or column.
 */

/**
 * Example
 * Consider the following matrix:
 * [
 *   [1, 3, 5, 7],
 *   [2, 4, 7, 8],
 *   [3, 5, 9, 10]
 * ]
 *
 * Given target = 3, return 2.
 */


public class Search2DMatrix2_38 {

    public static int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = m - 1;
        int count = 0;

        while (x < n && y >= 0) {
            if (matrix[y][x] < target) {
                ++x;
            } else if (matrix[y][x] > target) {
                --y;
            } else {
                ++x;
                --y;
                ++count;
            }
        }

        return count;
    }

}
