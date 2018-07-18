package LintCode;

// https://www.lintcode.com/problem/merge-k-sorted-arrays/description

/**
 * Given k sorted integer arrays, merge them into one sorted array.
 */

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Example
 * Given 3 sorted arrays:
 *     [
 *      [1, 3, 5, 7],
 *      [2, 4, 6],
 *      [0, 8, 9, 10, 11]
 *     ]
 * return [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].
 */

public class MergeKSortedArrays_486 {

    class Element {
        int row, column, value;

        Element(int row, int column, int value) {
            this.row = row;
            this.column = column;
            this.value = value;
        }
    }

    public int[] mergekSortedArrays(int[][] arrays) {
        if (arrays == null) {
            return null;
        }

        PriorityQueue<Element> priorityQueue = new PriorityQueue<>(arrays.length, new Comparator<Element>() {
            @Override
            public int compare(Element element1, Element element2) {
                return element1.value - element2.value;
            }
        });

        int elementCount = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == null || arrays[i].length == 0) {
                continue;
            }
            Element element = new Element(i, 0, arrays[i][0]);
            priorityQueue.offer(element);
            elementCount += arrays[i].length;
        }

        int[] mergedArray = new int[elementCount];
        int index = 0;

        while (!priorityQueue.isEmpty()) {
            Element element = priorityQueue.poll();
            mergedArray[index++] = element.value;

            if (arrays[element.row] != null && element.column + 1 < arrays[element.row].length) {
                element.column++;
                element.value = arrays[element.row][element.column];
                priorityQueue.offer(element);
            }
        }

        return mergedArray;
    }
}
