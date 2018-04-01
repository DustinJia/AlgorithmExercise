package LintCode;

// http://www.lintcode.com/en/problem/topological-sorting/

/**
 * Given an directed graph, a topological order of the graph nodes is defined as follow:
 *   For each directed edge A -> B in graph, A must before B in the order list.
 *   The first node in the order can be any node in the graph with no nodes direct to it.
 * Find any topological order for the given graph.
 *
 * Notice
 * You can assume that there is at least one topological order in the graph.
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSorting_127 {

    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        HashMap<DirectedGraphNode, Integer> hashMap = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (hashMap.containsKey(neighbor)) {
                    hashMap.put(neighbor, hashMap.get(neighbor) + 1);
                } else {
                    hashMap.put(neighbor, 1);
                }
            }
        }

        ArrayList<DirectedGraphNode> result = new ArrayList<>();

        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graph) {
            if (!hashMap.containsKey(node)) {
                queue.offer(node);
                result.add(node);
            }
        }

        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode neighbor : node.neighbors) {
                hashMap.put(neighbor, hashMap.get(neighbor) - 1);

                if (hashMap.get(neighbor) == 0) {
                    queue.offer(neighbor);
                    result.add(neighbor);
                }
            }
        }

        if (queue.size() == result.size()) {  // If cycle exists the sizes won't be equal
            return result;
        }

        return null;
    }

    class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;

        DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
    }
}
