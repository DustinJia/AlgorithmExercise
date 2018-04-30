package LintCode;

// https://www.lintcode.com/en/problem/sequence-reconstruction/

/**
 * Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs.
 * The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 10^4.
 * Reconstruction means building a shortest common supersequence of the sequences in seqs (i.e., a shortest sequence so that all sequences in seqs are subsequences of it).
 * Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.
 */

/**
 * Example
 *
 * Given org = [1,2,3], seqs = [[1,2],[1,3]]
 * Return false
 * Explanation:
 * [1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence that can be reconstructed.

 * Given org = [1,2,3], seqs = [[1,2]]
 * Return false
 * Explanation:
 * The reconstructed sequence can only be [1,2].

 * Given org = [1,2,3], seqs = [[1,2],[1,3],[2,3]]
 * Return true
 * Explanation:
 * The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].

 * Given org = [4,1,5,2,6,3], seqs = [[5,2,6,3],[4,1,5,2]]
 * Return true
 */

import java.util.*;

public class SequenceReconstruction_605 {

    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        Map<Integer, Set<Integer>> edgesMap = new HashMap<>();
        Map<Integer, Integer> inDegreesMap = new HashMap<>();

        int maxValue = 1;

        // Initialize maps
        for (int value : org) {
            edgesMap.put(value, new HashSet<>());
            inDegreesMap.put(value, 0);
            maxValue = Math.max(value, maxValue);
        }

        // Get edges and in-degrees
        int seqValueCount = 0;
        for (int[] seq : seqs) {
            seqValueCount += seq.length;

            if (seq.length > 0 && (seq[0] < 1 || seq[0] > maxValue)) {
                return false;
            }
            for (int i = 1; i < seq.length; i++) {
                if (seq[i] < 1 || seq[i] > maxValue) {
                    return false;
                }

                if (edgesMap.get(seq[i - 1]).add(seq[i])) {
                    inDegreesMap.put(seq[i], inDegreesMap.get(seq[i]) + 1);
                }
            }
        }

        // Num of values in seqs must not less than org's capacity
        if (org.length > seqValueCount) {
            return false;
        }

        // Topological sorting
        Queue<Integer> queue = new ArrayDeque<>();
        for (int key : inDegreesMap.keySet()) {
            if (inDegreesMap.get(key) == 0) {
                queue.offer(key);
            }
        }

        int sortedValueCount = 0;
        while (queue.size() == 1) {  // The must be only one valid sorting
            int value = queue.poll();
            if (org[sortedValueCount] != value) {
                return false;
            }

            for (int nextValue : edgesMap.get(value)) {
                inDegreesMap.put(nextValue, inDegreesMap.get(nextValue) - 1);
                if (inDegreesMap.get(nextValue) == 0) {
                    queue.offer(nextValue);
                }
            }
            sortedValueCount++;
        }

        return sortedValueCount == org.length;
    }
}

