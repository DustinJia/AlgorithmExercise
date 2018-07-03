package Execute;

public class Main {

    static class QueueNode {
        public int val;
        public QueueNode next;
        public QueueNode(int value) {
            val = value;
        }
    }

    public static void main(String[] args) {
        QueueNode dummy = new QueueNode(-1);
        int ele = dummy.next.val;
        System.out.println(ele);
    }
}
