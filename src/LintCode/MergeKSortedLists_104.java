package LintCode;

// https://www.lintcode.com/problem/merge-k-sorted-lists/description

/**
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 */

/**
 * Example
 * Given lists:
 *   [
 *     2->4->null,
 *     null,
 *     -1->null
 *   ],
 * return -1->2->4->null.
 */

import java.util.List;

public class MergeKSortedLists_104 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.isEmpty()) {
            return null;
        }

        return mergeHelper(lists, 0, lists.size() - 1);
    }

    private ListNode mergeHelper(List<ListNode> lists, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return lists.get(startIndex);
        }

        int midIndex = startIndex + (endIndex - startIndex) / 2;
        ListNode left = mergeHelper(lists, startIndex, midIndex);
        ListNode right = mergeHelper(lists, midIndex + 1, endIndex);

        return merge(left, right);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                tail = tail.next;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = tail.next;
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            tail.next = list1;
        }
        if (list2 != null) {
            tail.next = list2;
        }

        return dummy.next;
    }
}
