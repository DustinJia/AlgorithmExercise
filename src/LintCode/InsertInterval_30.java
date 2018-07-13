package LintCode;

// https://www.lintcode.com/problem/insert-interval/description

/**
 * Given a non-overlapping interval list which is sorted by start point.
 * Insert a new interval into it, make sure the list is still in order and non-overlapping (merge intervals if necessary).
 */

/**
 * Example
 * Insert (2, 5) into [(1,2), (5,9)], we get [(1,9)].
 * Insert (3, 4) into [(1,2), (5,9)], we get [(1,2), (3,4), (5,9)].
 */

import java.util.ArrayList;
import java.util.List;

public class InsertInterval_30 {

    class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null) {
            return intervals;
        }

        int index = 0;
        while (index < intervals.size() && intervals.get(index).start < newInterval.start) {
            index++;
        }
        intervals.add(index, newInterval);

        List<Interval> results = new ArrayList<>();
        Interval last = null;

        for (Interval interval : intervals) {
            if (last == null || last.end < interval.start) {
                results.add(interval);
                last = interval;
            } else {
                last.end = Math.max(last.end, interval.end);
            }
        }

        return results;
    }
}
