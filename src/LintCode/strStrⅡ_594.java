package LintCode;

// http://www.lintcode.com/en/problem/strstr-ii/

/**
 * Implement strStr function in O(n + m) time.
 *
 * strStr return the first index of the target string in a source string. The length of the target string is m and the length of the source string is n.
 * If target does not exist in source, just return -1.
 */

/**
 * Example
 * Given source = abcdef, target = bcd, return 1.
 */


public class strStrⅡ_594 {

    // Rabin Karp: http://www.jiuzhang.com/video/rabin-karp

    static final int kSystemBase = 31;
    static final int kModelBase = (int) 1e6;

    public static int strStr2(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        if (target.isEmpty()) {
            return 0;
        }

        int m = target.length();

        // Power of M
        int powerM = 1;
        for (int i = 0; i < m; i++) {
            powerM = (powerM * kSystemBase) % kModelBase;
        }

        // Target code
        int targetCode = 0;
        for (int i = 0; i < m; i++) {
            targetCode = (targetCode * kSystemBase + target.charAt(i)) % kModelBase;
        }

        // Source code
        int sourceCode = 0;
        for (int i = 0; i < source.length(); i++) {
            sourceCode = (sourceCode * kSystemBase + source.charAt(i)) % kModelBase;

            if (i < m - 1) {
                continue;
            }

            if (i >= m) {
                sourceCode = sourceCode - (source.charAt(i - m) * powerM) % kModelBase;
                if (sourceCode < 0) {
                    sourceCode += kModelBase;
                }
            }

            if (sourceCode == targetCode) {
                if (source.substring(i - m + 1, i + 1).equals(target)) {
                    return i - m + 1;
                }
            }
        }

        return -1;
    }
}
