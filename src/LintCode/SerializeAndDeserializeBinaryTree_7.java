package LintCode;

// https://www.lintcode.com/en/problem/serialize-and-deserialize-binary-tree/

/**
 * Design an algorithm and write code to serialize and deserialize a binary tree.
 * Writing the tree to a file is called 'serialization' and reading back from the file to reconstruct
 * the exact same binary tree is 'deserialization'.
 *
 *  Notice
 *    There is no limit of how you deserialize or serialize a binary tree,
 *    LintCode will take your output of serialize as the input of deserialize,
 *    it won't check the result of serialize.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Example
 *
 * An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * Our data serialization use bfs traversal. This is just for when you got wrong answer and want to debug the input.
 * You can use other method to do serializaiton and deserialization.
 */

public class SerializeAndDeserializeBinaryTree_7 {

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        ArrayList<String> serialized = new ArrayList<>();

        Queue queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = (TreeNode) queue.poll();

                if (node != null) {
                    serialized.add(String.valueOf(node.val));
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    serialized.add("#");
                }
            }
        }

        return serialized.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        // The string is automatically bounded with [ ], we have to remove them first
        String serialized = data.substring(1, data.length() - 1);
        String[] valueStrings = serialized.split(", ");  // Don't forget the white space

        Queue queue = new LinkedList();

        int strIndex = 0;

        Integer value0 = new Integer(valueStrings[strIndex++]);
        TreeNode node = new TreeNode(value0);
        queue.offer(node);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = (TreeNode) queue.poll();

                // Left sub node
                if (strIndex >= valueStrings.length) {
                    return node;
                }
                String strLeft = valueStrings[strIndex++];
                if (!strLeft.equals("#")) {
                    Integer valueLeft = new Integer(strLeft);
                    TreeNode leftNode = new TreeNode(valueLeft);
                    queue.offer(leftNode);
                    curNode.left = leftNode;
                }

                // Right sub node
                if (strIndex >= valueStrings.length) {
                    return node;
                }
                String strRight = valueStrings[strIndex++];
                if (!strRight.equals("#")) {
                    Integer valueRight = new Integer(strRight);
                    TreeNode rightNode = new TreeNode(valueRight);
                    queue.offer(rightNode);
                    curNode.right = rightNode;
                }
            }
        }

        return node;
    }
}
