package LintCode;

// http://www.lintcode.com/en/problem/middle-of-linked-list/

/**
 * Find the middle node of a linked list.
 */

/**
 * Example
 * Given 1->2->3, return the node with value 2.
 * Given 1->2, return the node with value 1.
 */


public class MiddleOfLinkedList_228 {

    public class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
