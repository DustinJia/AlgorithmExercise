package LintCode;

// https://www.lintcode.com/problem/merge-k-sorted-interval-lists/description

/**
 * Merge K sorted interval lists into one sorted interval list. You need to merge overlapping intervals too.
 */

/**
 * Example
 * Given
 *     [
 *      [(1,3),(4,7),(6,8)],
 *      [(1,2),(9,10)]
 *     ]
 * Return
 *     [(1,3),(4,8),(9,10)]
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedIntervalLists_577 {

    class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    class Pair {
        int row, column;
        Pair(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        if (intervals == null) {
            return null;
        }

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(intervals.size(), new Comparator<Pair>() {
            @Override
            public int compare(Pair pair1, Pair pair2) {
                return intervals.get(pair1.row).get(pair1.column).start -
                        intervals.get(pair2.row).get(pair2.column).start;
            }
        });

        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).isEmpty()) {
                continue;
            }
            priorityQueue.offer(new Pair(i, 0));
        }

        List<Interval> sortedIntervals = new ArrayList<>();

        while (!priorityQueue.isEmpty()) {
            Pair pair = priorityQueue.poll();
            sortedIntervals.add(intervals.get(pair.row).get(pair.column));
            pair.column++;

            if (pair.column < intervals.get(pair.row).size()) {
                priorityQueue.offer(pair);
            }
        }

        return mergeIntervals(sortedIntervals);
    }

    private List<Interval> mergeIntervals(List<Interval> sortedIntervals) {
        if (sortedIntervals.size() < 2) {
            return sortedIntervals;
        }

        List<Interval> mergedIntervals = new ArrayList<>();
        int start = sortedIntervals.get(0).start;
        int end = sortedIntervals.get(0).end;

        for (Interval interval : sortedIntervals) {
            if (interval.start > end) {
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            } else {
                end = Math.max(end, interval.end);
            }
        }

        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }
}
