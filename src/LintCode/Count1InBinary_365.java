package LintCode;

// https://www.lintcode.com/problem/count-1-in-binary/description

/**
 * Count how many 1 in binary representation of a 32-bit integer.
 */

/**
 * Example
 * Given 32, return 1
 * Given 5, return 2
 * Given 1023, return 9
 */

public class Count1InBinary_365 {

    public int countOnes(int num) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            if ((num & (1<<i)) != 0) {
                count++;
            }
        }

        return count;
    }
}
