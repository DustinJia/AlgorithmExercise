package LintCode;

// https://www.lintcode.com/problem/k-closest-points/description

/**
 * Given some points and a point origin in two dimensional space,
 * find k points out of the points which are nearest to origin.
 * Return these points sorted by distance, if they are same with distance,
 * sorted by x-axis, otherwise sorted by y-axis.
 */

/**
 * Example
 * Given points = [[4,6],[4,7],[4,4],[2,5],[1,1]], origin = [0, 0], k = 3
 * return [[1,1],[2,5],[4,4]]
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoints_612 {

    class Point {
        int x, y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    public Point[] kClosest(Point[] points, Point origin, int k) {
        Comparator<Point> comparator = new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                int difference = distance(p2, origin) - distance(p1, origin);

                if (difference == 0) {
                    difference = p2.x - p1.x;
                }
                if (difference == 0) {
                    difference = p2.y - p1.y;
                }

                return difference;
            }
        };

        PriorityQueue<Point> priorityQueue = new PriorityQueue<>(k, comparator);

        for (Point point : points) {
            priorityQueue.offer(point);

            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        Point[] result = new Point[k];
        while (!priorityQueue.isEmpty()) {
            result[--k] = priorityQueue.poll();
        }

        return result;
    }

    private int distance(Point p1, Point p2) {
        return (int)(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
}