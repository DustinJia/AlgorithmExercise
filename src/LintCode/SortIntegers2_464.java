package LintCode;

// http://www.lintcode.com/en/problem/sort-integers-ii/

/**
 * Given an integer array, sort it in ascending order.
 * Use quick sort, merge sort, heap sort or any O(nlogn) algorithm.
 */

/**
 * Example
 * Given [3, 2, 1, 4, 5], return [1, 2, 3, 4, 5].
 */


public class SortIntegers2_464 {

    //region Quick Sort
    public void quickSortIntegers(int[] A) {
        quickSort(A, 0, A.length - 1);
    }

    private void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start, right = end;
        int pivot = A[(start + end) / 2];

        while (left <= right) {
            while (left <= right && A[left] < pivot) {
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

        quickSort(A, start, right);
        quickSort(A, left, end);
    }
    //endregion

    //region Merge Sort
    public void mergeSortIntegers(int[] A) {
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
    //endregion
}
