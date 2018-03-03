package LintCode;

import java.util.HashMap;

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
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int even = 0, odd = 0;
        boolean hasOdd = false;

        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if (hashMap.get(character) == null) {
                hashMap.put(character, 1);
            } else {
                hashMap.put(character, hashMap.get(character) + 1);
            }
        }

        for (Integer value : hashMap.values()) {
            if (value % 2 == 0) {  // Even
                even += value;
            } else {  // Odd
                odd += value - 1;
                hasOdd = true;
            }
        }

        return even + odd + (hasOdd ? 1 : 0);
    }
}
