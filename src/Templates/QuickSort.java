package Templates;

/**
 * Created by dustin.jia on 3/26/18.
 */
public class QuickSort {

    public void sortIntegers(int[] A) {
        quickSort(A, 0, A.length - 1);
    }

    private void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start, right = end;
        int pivot = A[(start + end) / 2];  // 1. Pivot is the value, not index

        while (left <= right) {  // 2. Every time compare left & right use <= not <
            while (left <= right && A[left] < pivot) {  // 3. Every time compare with pivot use < or >
                ++left;
            }
            while (left <= right && A[right] > pivot) {
                --right;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                ++left;
                --right;
            }
        }

        quickSort(A, start, right);  // 4. Right & Left already been swapped, right < left
        quickSort(A, left, end);
    }
}
