package LintCode;

// https://www.lintcode.com/problem/sparse-matrix-multiplication/description

/**
 * Given two Sparse Matrix A and B, return the result of AB.
 * You may assume that A's column number is equal to B's row number.
 */

/**
 * Example
 * A = [
 *      [ 1, 0, 0],
 *      [-1, 0, 3]
 *     ]
 * B = [
 *      [ 7, 0, 0 ],
 *      [ 0, 0, 0 ],
 *      [ 0, 0, 1 ]
 *     ]
 *
 *      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 * AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 *                   | 0 0 1 |
 */

public class SparseMatrixMultiplication_654 {

    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || B == null || A.length == 0 || A[0].length == 0 || B[0].length == 0) {
            return null;
        }

        int m = A.length;
        int n = B[0].length;
        int t = A[0].length;

        int[][] C = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int k = 0; k < t; k++) {
                if (A[i][k] == 0) {
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }
}
