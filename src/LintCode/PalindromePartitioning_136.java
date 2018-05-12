package LintCode;

// https://www.lintcode.com/problem/palindrome-partitioning/description

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 */

/**
 * Example
 * Given s = "aab", return:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */

import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning_136 {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();

        if (s == null || s.length() == 0) {
            return result;
        }

        dfs(s, 0, new LinkedList<String>(), result);

        return result;
    }

    private void dfs(String s, int startIndex, LinkedList<String> subSet, List<List<String>> result) {
        if (startIndex == s.length()) {
            result.add(new LinkedList<>(subSet));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String subString = s.substring(startIndex, i + 1);
            if (isPalindrome(subString)) {
                subSet.add(subString);
                dfs(s, i + 1, subSet, result);
                subSet.remove(subSet.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String subString) {
        for (int i = 0, j = subString.length() - 1; i < j; i++, j--) {
            if (subString.charAt(i) != subString.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}
