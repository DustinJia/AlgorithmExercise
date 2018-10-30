package LintCode;

// https://www.lintcode.com/problem/permutation-index/description

/**
 * Given a permutation which contains no repeated number, find its index in all the permutations of these numbers,
 * which are ordered in lexicographical order.
 * The index begins at 1.
 */

/**
 * Example
 *
 * Given [1,2,4], return 1.
 */
// 1 4 2 3 , 1234 1243 1324 1342
public class PermutationIndex_197 {

    public long permutationIndex(int[] A) {
        long permutation = 1;
        long result = 0;

        for (int i = A.length - 2; i >= 0; i--) {
            int smaller = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[i]) {
                    smaller++;
                }
            }
            result += smaller * permutation;
            permutation *= A.length - i;
        }

        return result + 1;
    }
}
