package LintCode;

// https://www.lintcode.com/problem/lru-cache/description

import java.util.HashMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 */

public class LRUCache_134 {

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }

    int capacity;
    Node head;
    Node tail;
    HashMap<Integer, Node> hashMap;

    public LRUCache_134(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        hashMap = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (!hashMap.containsKey(key)) {
            return -1;
        }

        Node target = hashMap.get(key);

        // Remove target from linked list
        target.prev.next = target.next;
        target.next.prev = target.prev;

        // Add the target node back to tail
        addToTail(target);

        return target.value;
    }

    public void set(int key, int value) {
        if (get(key) != -1) {
            hashMap.get(key).value = value;  // This node has already been moved to tail
            return;
        }

        if (hashMap.size() == capacity) {
            // Delete the first node
            hashMap.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        Node newNode = new Node(key, value);
        hashMap.put(key, newNode);
        addToTail(newNode);
    }

    private void addToTail(Node target) {
        tail.prev.next = target;
        target.next = tail;
        target.prev = tail.prev;
        tail.prev = target;
    }
}
