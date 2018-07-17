package LintCode;

// https://www.lintcode.com/problem/maximum-submatrix/description

/**
 * Given an n x n matrix of positive and negative integers, find the submatrix with the largest possible sum.
 */

/**
 * Example
 * Given matrix =
 * [
 * [1,3,-1],
 * [2,3,-2],
 * [-1,-2,-3]
 * ]
 * return 9.
 * Explanation:
 * the submatrix with the largest possible sum is:
 * [
 * [1,3],
 * [2,3]
 * ]
 */

public class MaximumSubmatrix_944 {

    public int maxSubmatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        
        int[][] columnSums = getColumSumMatrix(matrix);
        int result = Integer.MIN_VALUE;

        for (int upper = 0; upper < matrix.length; upper++) {
            for (int lower = upper; lower < matrix.length; lower++) {
                int[] compressedArray = compression(columnSums, lower, upper);
                int maximum = maxSubArray(compressedArray);
                result = Integer.max(result, maximum);
            }
        }

        return result;
    }

    private int maxSubArray(int[] compressedArray) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = 0;  // Should not be Integer.MAX_VALUE, 0 means sum up from the start is the largest

        for (int i = 0; i < compressedArray.length; i++) {
            sum += compressedArray[i];
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
        }

        return max;
    }

    private int[] compression(int[][] columnSums, int lower, int upper) {
        int[] compressed = new int[columnSums[0].length];

        for (int column = 0; column < columnSums[0].length; column++) {
            compressed[column] = columnSums[lower + 1][column] - columnSums[upper][column];
        }

        return compressed;
    }

    private int[][] getColumSumMatrix(int[][] matrix) {
        int[][] sumMatrix = new int[matrix.length + 1][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                sumMatrix[row + 1][column] = sumMatrix[row][column] + matrix[row][column];
            }
        }

        return sumMatrix;
    }
}
