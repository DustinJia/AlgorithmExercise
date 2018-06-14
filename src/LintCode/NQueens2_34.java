package LintCode;

// https://www.lintcode.com/problem/n-queens-ii/description

/**
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 */

/**
 * Example
 * For n=4, there are 2 distinct solutions.
 */

public class NQueens2_34 {

    int result = 0;

    public int totalNQueens(int n) {
        if (n < 1) {
            return 0;
        }

        dsp(new int[n], 0);
        return result;
    }

    private void dsp(int[] columnIndices, int rowIndex) {
        int n = columnIndices.length;

        if (rowIndex == n) {
            result++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isValid(columnIndices, rowIndex, i)) {
                continue;
            }

            columnIndices[rowIndex] = i;
            dsp(columnIndices, rowIndex + 1);
        }
    }

    private boolean isValid(int[] columnIndices, int rowIndex, int columnIndex) {
        for (int i = 0; i < rowIndex; i++) {
            if (columnIndices[i] == columnIndex) {
                return false;
            }

            if (rowIndex - i == Math.abs(columnIndices[i] - columnIndex)) {
                return false;
            }
        }

        return true;
    }
}
