package LintCode;

// https://www.lintcode.com/en/problem/clone-graph/

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * How we serialize an undirected graph:
 * Nodes are labeled uniquely.
 * We use # as a separator for each node, and "," as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 *   1. First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 *   2. Second node is labeled as 1. Connect node 1 to node 2.
 *   3. Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:
 *    1
 *   / \
 *  /   \
 * 0 --- 2
 *      / \
 *      \_/
 */

/**
 * Example
 * return a deep copied graph.
 */

import java.util.*;

public class CloneGraph_137 {

    class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }

        // Get all nodes
        Set<UndirectedGraphNode> allNodes = getAllNodes(node);

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

        // Copy all nodes into a hash map {oldNode : newNode}
        for (UndirectedGraphNode curNode : allNodes) {
            map.put(curNode, new UndirectedGraphNode(curNode.label));
        }

        // Copy all edges
        for (UndirectedGraphNode curNode : allNodes) {
            ArrayList<UndirectedGraphNode> neighbors = curNode.neighbors;
            for (UndirectedGraphNode neighbor : neighbors) {
                map.get(curNode).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }

    private Set<UndirectedGraphNode> getAllNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
        Set<UndirectedGraphNode> set = new HashSet<>();

        queue.offer(node);
        set.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode curNode = queue.poll();
            for (UndirectedGraphNode neighbor : curNode.neighbors) {
                if (set.add(neighbor)) {
                    queue.offer(neighbor);
                }
            }
        }

        return set;
    }
}
