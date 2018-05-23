package LintCode;

// https://www.lintcode.com/problem/find-the-missing-number-ii/description

/**
 * Giving a string with number from 1-n in random order, but miss 1 number. Find that number.
 * Notice
 *   n <= 30
 */

/**
 * Example
 * Given n = 20, str = 19201234567891011121314151618

 return 17
 */

public class FindTheMissingNumber2_570 {

    int missingNumber = -1;

    public int findMissing2(int n, String str) {
        boolean[] haveFound = new boolean[n + 1];
        dfs(0, n, str, haveFound);
        return missingNumber;
    }

    private void dfs(int start, int n, String str, boolean[] haveFound) {
        // Have found the number
        if (missingNumber != -1) {
            return;
        }

        // Extract the missing number
        if (start == str.length()) {
            for (int i = 1; i <= n ; i++) {
                if (!haveFound[i]) {
                    missingNumber = i;
                    break;
                }
            }
            return;
        }

        // It's invalid if a number starts with 0
        if (str.charAt(start) == '0') {
            return;
        }

        for (int delta = 1; delta <= 2; delta++) {
            if (start + delta <= str.length()) {
                int number = Integer.parseInt(str.substring(start, start + delta));
                if (number > 0 && number <= n && !haveFound[number]) {
                    haveFound[number] = true;
                    dfs(start + delta, n, str, haveFound);
                    haveFound[number] = false;
                }
            }
        }
    }
}
