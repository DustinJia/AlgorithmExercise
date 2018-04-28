package LintCode;

// https://www.lintcode.com/en/problem/knight-shortest-path/

/**
 * Given a knight in a chessboard (a binary matrix with 0 as empty and 1 as barrier) with a source position,
 * find the shortest path to a destination position, return the length of the route.
 * Return -1 if knight can not reached.
 *
 * Notice
 * source and destination must be empty.
 * Knight can not enter the barrier.
 */

/**
 * Clarification
 *
 * If the knight is at (x, y), he can get to the following positions in one step:
 * (x + 1, y + 2)
 * (x + 1, y - 2)
 * (x - 1, y + 2)
 * (x - 1, y - 2)
 * (x + 2, y + 1)
 * (x + 2, y - 1)
 * (x - 2, y + 1)
 * (x - 2, y - 1)
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Example
 *
 * [[0,0,0],
 *  [0,0,0],
 *  [0,0,0]]
 * source = [2, 0] destination = [2, 2] return 2
 *
 * [[0,1,0],
 *  [0,0,0],
 *  [0,0,0]]
 * source = [2, 0] destination = [2, 2] return 6
 *
 * [[0,1,0],
 *  [0,0,1],
 *  [0,0,0]]
 * source = [2, 0] destination = [2, 2] return -1
 */

public class KnightShortestPath_611 {

    class Point {
        int x;
        int y;
        public Point() { x = 0; y = 0; }
        public Point(int x, int y) { this.x = x; this.y = y; }
    }

    int[] deltaX = {1, 1, 2, 2, -1, -1, -2, -2};
    int[] deltaY = {2, -2, 1, -1, 2, -2, 1, -1};

    int m, n;

    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        m = grid.length;
        n = grid[0].length;

        Queue queue = new LinkedList();
        queue.offer(source);

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point curPoint = (Point) queue.poll();

                if (curPoint.x == destination.x && curPoint.y == destination.y) {
                    return steps;
                }

                for (int j = 0; j < 8; j++) {
                    int delX = deltaX[j];
                    int delY = deltaY[j];

                    Point nextPoint = new Point(curPoint.x + delX, curPoint.y + delY);

                    if (isValid(nextPoint, grid)) {
                        queue.offer(nextPoint);
                        grid[nextPoint.x][nextPoint.y] = true;
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    private boolean isValid(Point nextPoint, boolean[][] grid) {
        if (nextPoint.x >= 0 && nextPoint.x < m && nextPoint.y >= 0 && nextPoint.y < n) {
            return !grid[nextPoint.x][nextPoint.y];
        }
        return false;
    }
}
