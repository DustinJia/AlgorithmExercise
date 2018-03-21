package LintCode;

// http://www.lintcode.com/en/problem/rotate-string/

/**
 * Given a string and an offset, rotate string by offset. (rotate from left to right)
 */

/**
 * Example
 * Given "abcdefg"
 * offset=0 => "abcdefg"
 * offset=1 => "gabcdef"
 * offset=2 => "fgabcde"
 * offset=3 => "efgabcd"
 */


public class RotateString_8 {

    public static void rotateString(char[] str, int offset) {
        if (str == null || str.length < 2) {
            return;
        }

        offset %= str.length;
        reverse(str, 0, str.length - 1 - offset);
        reverse(str, str.length - offset, str.length - 1);
        reverse(str, 0, str.length - 1);
    }

    private static void reverse(char[] str, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }
}
