package LintCode;

// https://www.lintcode.com/problem/top-k-largest-numbers/description

/**
 * Given an integer array, find the top k largest numbers in it.
 */

/**
 * Example
 * Given [3,10,1000,-99,4,100] and k = 3.
 * Return [1000, 100, 10].
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class TopKLargestNumbers_544 {

    public int[] topk(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                return num1 - num2;
            }
        });

        for (int num : nums) {
            priorityQueue.offer(num);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        int[] result = new int[k];
        while (!priorityQueue.isEmpty()) {
            result[--k] = priorityQueue.poll();
        }

        return result;
    }
}
