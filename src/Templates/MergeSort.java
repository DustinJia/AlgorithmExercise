package Templates;

/**
 * Created by dustin.jia on 3/26/18.
 */
public class MergeSort {

    public void sortIntegers(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }

        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length - 1, temp);
    }

    private void mergeSort(int[] A, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(A, start, mid, temp);
        mergeSort(A, mid + 1, end, temp);
        merge(A, start, end, temp);
    }

    private void merge(int[] A, int start, int end, int[] temp) {
        int mid = (start + end) / 2;
        int left = start, right = mid + 1;
        int tempIndex = start;

        while (left <= mid && right <= end) {
            if (A[left] < A[right]) {
                temp[tempIndex++] = A[left++];
            } else {
                temp[tempIndex++] = A[right++];
            }
        }

        while (left <= mid) {
            temp[tempIndex++] = A[left++];
        }
        while (right <= end) {
            temp[tempIndex++] = A[right++];
        }

        for (int i = start; i <= end; i++) {
            A[i] = temp[i];
        }
    }

}
