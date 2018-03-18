package LintCode;

import java.util.HashSet;

// http://www.lintcode.com/en/problem/longest-palindrome/#

/**
 * Given a string which consists of lowercase or uppercase letters,
 * find the length of the longest palindromes that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Notice: Assume the length of given string will not exceed 1010.
 */

/**
 * Example
 * Given s = "abccccdd" return 7
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */


public class LongestPalindrome_627 {

    public static int longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        HashSet<Character> characters = new HashSet<>();
        for (Character character : s.toCharArray()) {
            if (characters.contains(character)) {
                characters.remove(character);
            } else {
                characters.add(character);
            }
        }

        int removable = characters.size();

        return s.length() - removable + (removable > 0 ? 1 : 0);
    }

}
