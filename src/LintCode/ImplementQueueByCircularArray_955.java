package LintCode;

// https://www.lintcode.com/problem/implement-queue-by-circular-array/description

/**
 * Implement queue by circulant array. You need to support the following methods:

 * 1. CircularQueue(n): initialize a circular array with size n to store elements
 * 2. boolean isFull(): return true if the array is full
 * 3. boolean isEmpty(): return true if there is no element in the array
 * 4. void enqueue(element): add an element to the queue
 * 5. int dequeue(): pop an element from the queue
 *
 * Note
 * it's guaranteed in the test cases we won't call enqueue if it's full and we also won't call dequeue if it's empty.
 * So it's ok to raise exception in scenarios described above.
 */

/**
 * Example
 * CircularQueue(5)
 * isFull()   => false
 * isEmpty() => true
 * enqueue(1)
 * dequeue()  => 1
 */

public class ImplementQueueByCircularArray_955 {

    int[] circularArray;
    int front;
    int rear;
    int size;

    public ImplementQueueByCircularArray_955(int n) {
        circularArray = new int[n];
        front = 0;
        rear = 0;
        size = 0;
    }
    /**
     * @return:  return true if the array is full
     */
    public boolean isFull() {
        return size == circularArray.length;
    }

    /**
     * @return: return true if there is no element in the array
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param element: the element given to be added
     * @return: nothing
     */
    public void enqueue(int element) {
        if (isFull()) {
            throw new RuntimeException("Queue is already full");
        }

        rear = (front + size) % circularArray.length;
        circularArray[rear] = element;
        size++;
    }

    /**
     * @return: pop an element from the queue
     */
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is already empty");
        }

        int element = circularArray[front];
        front = (front + 1) % circularArray.length;
        size--;

        return element;
    }
}
