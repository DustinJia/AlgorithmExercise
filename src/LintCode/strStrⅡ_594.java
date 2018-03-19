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

    static final int SYSTEM_BASE = 31;
    static final int MODULE_BASE = (int) 1e6;

    public static int strStr2(String source, String target) {

        if (source == null || target == null) {
            return -1;
        }
        if (target.isEmpty()) {
            return 0;
        }

        int targetLength = target.length();

        int powerTarget = 1;
        for (int i = 0; i < target.length(); i++) {
            powerTarget = (powerTarget * SYSTEM_BASE) % MODULE_BASE;
        }

        int targetHashCode = 0;
        for (int i = 0; i < target.length(); i++) {
            targetHashCode = (targetHashCode * SYSTEM_BASE + target.charAt(i)) % MODULE_BASE;
        }

        int sourceHashCode = 0;
        for (int i = 0; i < source.length(); i++) {
            sourceHashCode = (sourceHashCode * SYSTEM_BASE + source.charAt(i)) % MODULE_BASE;

            if (i < targetLength - 1) {
                continue;
            }

            if (i >= targetLength) {
                sourceHashCode = sourceHashCode - (source.charAt(i - targetLength) * powerTarget) % MODULE_BASE;
                if (sourceHashCode < 0) {
                    sourceHashCode += MODULE_BASE;
                }
            }

            if (sourceHashCode == targetHashCode) {
                if (source.substring(i - targetLength + 1, i + 1).equals(target)) {
                    return i - targetLength + 1;
                }
            }
        }

        return -1;
    }
}
