package LintCode;

// http://www.lintcode.com/en/problem/longest-palindromic-subsequence/

/**
 * Given a string s, find the longest palindromic subsequence's length in s.
 * You may assume that the maximum length of s is 1000.
 */

/**
 * Example
 * Given s = "bbbab" return 4
 * One possible longest palindromic subsequence is "bbbb".
 */


public class LongestPalindromicSubsequence_667 {

    public static int longestPalindromeSubseq(String s) {
        if (s == null || s.isEmpty()) return 0;
        int n = s.length();

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = 1;
            }
        }

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i < n; i++) {
                int j = i + len - 1;
                if (j >= 0 && j < n) {
                    if (i == j) {
                        dp[i][j] = 1;
                    } else if (j == i + 1) {
                        dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                        if (s.charAt(i) == s.charAt(j)) {
                            dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 2);
                        }
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}
