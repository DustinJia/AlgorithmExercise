package LintCode;

// http://www.lintcode.com/en/problem/pancake-sorting/

/**
 * Given an an unsorted array, sort the given array. You are allowed to do only following operation on array.
 *   flip(arr, i): Reverse array from 0 to i
 * Unlike a traditional sorting algorithm, which attempts to sort with the fewest comparisons possible,
 * the goal is to sort the sequence in as few reversals as possible.
 *
 * Notice
 * You only call flip function.
 * Don't allow to use any sort function or other sort methods.
 *
 * Java：you can call FlipTool.flip(arr, i)
 * C++： you can call FlipTool::flip(arr, i)
 * Python2&3 you can call FlipTool.flip(arr, i)
 */

/**
 * Example
 * Given array = [6, 7, 10, 11, 12, 20, 23]
 * Use flip(arr, i) function to sort the array.
 */


public class PancakeSorting_894 {

    public void pancakeSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        int last = array.length - 1;

        while (last > 0) {
            int maxIndex = findMaxIndex(array, last);
            if (maxIndex < last) {
                FlipTool.flip(array, maxIndex);
                FlipTool.flip(array, last);
            }
            --last;
        }

        if (array[0] > array[1]) {
            FlipTool.flip(array, 1);
        }
    }

    private int findMaxIndex(int[] array, int end) {
        int index = 0;

        for (int i = 0; i <= end; i++) {
            if (array[i] > array[index]) {
                index = i;
            }
        }

        return index;
    }
}

class FlipTool {

    static void flip(int[] array, int index) {
        int start = 0, end = index;

        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            ++start;
            --end;
        }
    };
}
