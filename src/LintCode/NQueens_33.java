package LintCode;

// https://www.lintcode.com/problem/n-queens/description

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 */

/**
 * Example
 *
 * There exist two distinct solutions to the 4-queens puzzle:
 * [
 *   // Solution 1
 *   [".Q..",
 *    "...Q",
 *    "Q...",
 *    "..Q."
 *   ],
 *   // Solution 2
 *   ["..Q.",
 *    "Q...",
 *    "...Q",
 *    ".Q.."
 *   ]
 * ]
 */

import java.util.ArrayList;
import java.util.List;

public class NQueens_33 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        if (n == 0) {
            return result;
        }

        dfs(n, new ArrayList<Integer>(), result);

        return result;
    }

    /*
     * @param columnIndices: The queens' column indices of each row
     */
    private void dfs(int n, ArrayList<Integer> columnIndices, List<List<String>> result) {
        if (columnIndices.size() == n) {
            result.add(drawResult(columnIndices));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isValid(i, columnIndices)) {
                continue;
            }

            columnIndices.add(i);
            dfs(n, columnIndices, result);
            columnIndices.remove(columnIndices.size() - 1);
        }
    }

    private boolean isValid(int columnIndex, ArrayList<Integer> columnIndices) {
        int currentRowIndex = columnIndices.size();

        for (int rowIndex = 0; rowIndex < columnIndices.size(); rowIndex++) {
            // Check along vertical line
            if (columnIndices.get(rowIndex) == columnIndex) {
                return false;
            }

            // Check along bias line, direction: /
            if (rowIndex + columnIndices.get(rowIndex) == currentRowIndex + columnIndex) {
                return false;
            }

            // Check along bias line, direction: \
            if (rowIndex - columnIndices.get(rowIndex) == currentRowIndex - columnIndex) {
                return false;
            }
        }

        return true;
    }

    private List<String> drawResult(ArrayList<Integer> columnIndices) {
        List<String> result = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < columnIndices.size(); rowIndex++) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int columnIndex = 0; columnIndex < columnIndices.size(); columnIndex++) {
                char mark = columnIndices.get(rowIndex) == columnIndex ? 'Q' : '.';
                stringBuilder.append(mark);
            }

            result.add(stringBuilder.toString());
        }

        return result;
    }
}
