package LintCode;

// http://www.lintcode.com/en/problem/strstr/

/**
 * For a given source string and a target string, you should output the first index(from 0) of target string in source string.
 * If target does not exist in source, just return -1.
 */

/**
 * Example
 * If source = "source" and target = "target", return -1.
 * If source = "abcdabcdefg" and target = "bcd", return 1.
 */


public class strStr_13 {

    // KMP reference: https://www.youtube.com/watch?v=GTJr8OvyEVQ

    private static int[] generateHelperArray(String pattern) {
        int[] helperArray = new int[pattern.length()];
        int i = 0, j = 1;

        while (j < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                helperArray[j] = i + 1;
                i++;
                j++;
            } else {
                if (i > 0) {
                    i = helperArray[i-1];
                } else {
                    helperArray[j] = 0;
                    j++;
                }
            }
        }

        return helperArray;
    }

    public static int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        } else if (target.isEmpty()) {
            return 0;
        }

        int[] helperArray = generateHelperArray(target);
        int indexS = 0, indexT = 0;
        int matchIndex = -1;

        while (indexS < source.length() && indexT < target.length()) {
            if (source.charAt(indexS) == target.charAt(indexT)) {
                indexS++;
                indexT++;

                if (indexT == target.length()) {
                    matchIndex = indexS - target.length();
                    break;
                }
            } else {
                if (indexT > 0) {
                    indexT = helperArray[indexT-1];
                } else {
                    indexS++;
                }
            }
        }

        return matchIndex;
    }

}
