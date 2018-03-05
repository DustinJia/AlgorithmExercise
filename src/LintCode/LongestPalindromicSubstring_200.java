package LintCode;

// http://www.lintcode.com/en/problem/longest-palindromic-substring/

/**
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */

/**
 * Example
 * Given the string = "abcdzdcab", return "cdzdc".
 */


public class LongestPalindromicSubstring_200 {

    // For O(n) solution refer to Manacher's Algorithm: https://www.youtube.com/watch?v=V-sEwsca1ak

    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return s;

        String longestPalindrome = "";
        int range = 0;

        // Odd case
        for (int i = 0; i < s.length(); i++) {

            while (i - range >= 0 && i + range < s.length()) {
                char left = s.charAt(i - range);
                char right = s.charAt(i + range);

                if (left == right) {
                    String palindrome = s.substring(i - range, i + range + 1);
                    if (palindrome.length() > longestPalindrome.length()) {
                        longestPalindrome = palindrome;
                    }
                    range++;
                } else {
                    break;
                }
            }

            range = 0;
        }

        // Even case
        range = 0;
        for (int i = 0; i < s.length() - 1; i++) {

            while (i - range >= 0 && i + range + 1 < s.length()) {
                char left = s.charAt(i - range);
                char right = s.charAt(i + range + 1);

                if (left == right) {
                    String palindrome = s.substring(i - range, i + range + 2);
                    if (palindrome.length() > longestPalindrome.length()) {
                        longestPalindrome = palindrome;
                    }
                    range++;
                } else {
                    break;
                }
            }

            range = 0;
        }

        return longestPalindrome;
    }
}
