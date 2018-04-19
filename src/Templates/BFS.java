package Templates;

import java.util.*;

/**
 * Created by dustin.jia on 3/31/18.
 */
public class BFS {

    class GraphNode {
        int label;
        ArrayList<GraphNode> neighbors;

        GraphNode(int x) {
            label = x;
            neighbors = new ArrayList<GraphNode>();
        }
    }

    // Without level order traversal
    void broadFirstSearch1(GraphNode start) {
        Queue<GraphNode> queue = new LinkedList<>();
        Set<GraphNode> set = new HashSet<>();

        queue.add(start);
        set.add(start);

        while (!queue.isEmpty()) {
            GraphNode head = queue.poll();
            for (GraphNode neighbor : head.neighbors) {
                if (!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
    }

    // Level order traversal
    void broadFirstSearch2(GraphNode start) {
        Queue<GraphNode> queue = new LinkedList<>();
        Set<GraphNode> set = new HashSet<>();

        queue.add(start);
        set.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();  // Getting the queue size before looping
            for (int i = 0; i < size; i++) {
                GraphNode head = queue.poll();
                for (GraphNode neighbor : head.neighbors) {
                    if (!set.contains(neighbor)) {
                        set.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
        }
    }

    //region Bidirectional BFS
    class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int label) {
            this.label = label;
            this.neighbors = neighbors;
        }
    }

    int doubleBFS(UndirectedGraphNode start, UndirectedGraphNode end) {
        if (start.equals(end)) {
            return -1;
        }

        Queue<UndirectedGraphNode> startQueue = new LinkedList<>();
        Queue<UndirectedGraphNode> endQueue = new LinkedList<>();
        startQueue.add(start);
        endQueue.add(end);

        int step = 0;

        Set<UndirectedGraphNode> startVisited = new HashSet<>();
        Set<UndirectedGraphNode> endVisited = new HashSet<>();
        startVisited.add(start);
        endVisited.add(end);

        while (!startQueue.isEmpty() || !endQueue.isEmpty()) {
            int startSize = startQueue.size();
            int endSize = endQueue.size();

            step++;
            for (int i = 0; i < startSize; i++) {
                UndirectedGraphNode current = startQueue.poll();
                for (UndirectedGraphNode neighbor : current.neighbors) {
                    if (startVisited.contains(neighbor)) {
                        continue;
                    } else if (endVisited.contains(neighbor)) {
                        return step;
                    } else {
                        startVisited.add(neighbor);
                        startQueue.add(neighbor);
                    }
                }
            }

            step++;
            for (int i = 0; i < endSize; i++) {
                UndirectedGraphNode current = endQueue.poll();
                for (UndirectedGraphNode neighbor : current.neighbors) {
                    if (endVisited.contains(neighbor)) {
                        continue;
                    } else if (startVisited.contains(neighbor)) {
                        return step;
                    } else {
                        endVisited.add(neighbor);
                        endQueue.add(neighbor);
                    }
                }
            }
        }

        return -1;
    }
    //endregion
}
