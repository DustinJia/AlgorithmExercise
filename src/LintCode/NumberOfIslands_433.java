package LintCode;

// http://www.lintcode.com/en/problem/number-of-islands/

/**
 * Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island.
 * If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.
 *
 * Find the number of islands.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Example
 * Given graph:
 * [
 *   [1, 1, 0, 0, 0],
 *   [0, 1, 0, 0, 1],
 *   [0, 0, 0, 1, 1],
 *   [0, 0, 0, 0, 0],
 *   [0, 0, 0, 0, 1]
 * ]
 * return 3.
 */

public class NumberOfIslands_433 {

    class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(boolean[][] grid) {
        int m = grid[0].length;
        int n = grid.length;

        if (grid == null || m == 0 || n == 0) {
            return 0;
        }

        int numIslands = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    markWithBFS(grid, i, j);
                    numIslands++;
                }
            }
        }

        return numIslands;
    }

    int[] directionX = new int[] { 0, 1, -1, 0 };
    int[] directionY = new int[] { 1, 0, 0, -1 };

    private void markWithBFS(boolean[][] grid, int x, int y) {
        Queue<Coordinate> queue = new LinkedList<>();
        
        queue.offer(new Coordinate(x, y));
        grid[x][y] = false;
        
        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            for (int i = 0; i < 4; i++) {
                Coordinate adjacent = new Coordinate(coordinate.x + directionX[i], coordinate.y + directionY[i]);

                if (inBound(adjacent, grid) && grid[adjacent.x][adjacent.y]) {
                    grid[adjacent.x][adjacent.y] = false;
                    queue.offer(adjacent);
                }
            }
        }
    }

    private boolean inBound(Coordinate coordinate, boolean[][] grid) {
        int m = grid[0].length;
        int n = grid.length;

        return coordinate.x >= 0 && coordinate.x < n && coordinate.y >= 0 && coordinate.y < m;
    }
}
