package LintCode;

// http://www.lintcode.com/en/problem/valid-palindrome/

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Notice: Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 */

/**
 * Example
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 */


public class ValidPalindrome_415 {

    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;

        String alphanumericString = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(alphanumericString).reverse().toString();

        return alphanumericString.equals(reversed);
    }

}
