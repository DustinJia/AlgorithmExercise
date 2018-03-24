package LintCode;

// http://www.lintcode.com/en/problem/valid-palindrome-ii/

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Notice
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */

/**
 * Example
 * Given s = "aba" return true
 * Given s = "abca" return true // delete c
 */


public class ValidPalindrome2_891 {

    public boolean validPalindrome(String s) {
        int start = 0, end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                boolean isValidL = isPalindrome(s.substring(start + 1, end + 1));
                if (isValidL) {
                    return true;
                }
                boolean isValidR = isPalindrome(s.substring(start, end));
                if (isValidR) {
                    return true;
                }
                return false;
            }
            ++start;
            --end;
        }

        return true;
    }

    boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            ++start;
            --end;
        }

        return true;
    }
}
