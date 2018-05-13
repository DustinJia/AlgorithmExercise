package LintCode;

// https://www.lintcode.com/problem/wildcard-matching/description

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 *   '?' Matches any single character.
 *   '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 */

/**
 * Example
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 */

public class WildcardMatching_192 {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        boolean[][] memo = new boolean[s.length()][p.length()];
        boolean[][] visited = new boolean[s.length()][p.length()];
        return matchHelper(s, 0, p, 0, memo, visited);
    }

    private boolean matchHelper(String s, int sIndex,
                                String p, int pIndex,
                                boolean[][] memo,
                                boolean[][] visited) {
        if (pIndex == p.length()) {
            return sIndex == s.length();
        }

        if (sIndex == s.length()) {
            return allStar(p, pIndex);
        }

        if (visited[sIndex][pIndex]) {
            return memo[sIndex][pIndex];
        }

        char sChar = s.charAt(sIndex);
        char pChar = p.charAt(pIndex);
        boolean match;

        if (pChar == '*') {
            match = matchHelper(s, sIndex, p, pIndex + 1, memo, visited) ||
                    matchHelper(s, sIndex + 1, p, pIndex, memo, visited);
        } else {
            match = charMatch(sChar, pChar) &&
                    matchHelper(s, sIndex + 1, p, pIndex + 1, memo, visited);
        }

        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = match;
        return match;
    }

    private boolean charMatch(char sChar, char pChar) {
        return (sChar == pChar || pChar == '?');
    }

    private boolean allStar(String p, int pIndex) {
        for (int i = pIndex; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
}
