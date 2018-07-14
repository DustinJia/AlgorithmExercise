package LintCode;

// https://www.lintcode.com/problem/merge-two-sorted-interval-lists/description

/**
 * Merge two sorted (ascending) lists of interval and return it as a new sorted list.
 * The new sorted list should be made by splicing together the intervals of the two lists and sorted in ascending order.
 * Notice
 *   The intervals in the given list do not overlap.
 *   The intervals in different lists may overlap.
 */

/**
 * Example
 * Given list1 = [(1,2),(3,4)] and list2 = [(2,3),(5,6)], return [(1,4),(5,6)].
 */

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedIntervalLists_839 {

    class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        List<Interval> result = new ArrayList<>();

        int index1 = 0;
        int index2 = 0;
        Interval prev = null;
        Interval currentMinInterval = null;

        while (index1 < list1.size() && index2 < list2.size()) {
            if (list1.get(index1).start < list2.get(index2).start) {
                currentMinInterval = list1.get(index1);
                index1++;
            } else {
                currentMinInterval = list2.get(index2);
                index2++;
            }

            prev = merge(result, prev, currentMinInterval);
        }

        while (index1 < list1.size()) {
            prev = merge(result, prev, list1.get(index1));
            index1++;
        }
        while (index2 < list2.size()) {
            prev = merge(result, prev, list2.get(index2));
            index2++;
        }
        if (prev != null) {
            result.add(prev);
        }

        return result;
    }

    private Interval merge(List<Interval> result, Interval prev, Interval current) {
        if (prev == null) {
            return current;
        }

        if (prev.end < current.start) {
            result.add(prev);
            return current;
        }

        prev.end = Math.max(prev.end, current.end);
        return prev;
    }
}
