package LintCode;

// https://www.lintcode.com/problem/remove-invalid-parentheses/description

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * Notice
 *   The input string may contain letters other than the parentheses ( and ).
 */

/**
 * Example
 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 */

import java.util.LinkedList;
import java.util.List;

public class RemoveInvalidParentheses_780 {

    class ParenthesesDifference {
        int left;
        int right;

        public ParenthesesDifference(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new LinkedList<>();

        ParenthesesDifference difference = getDifference(s);
        dsp(s, 0, difference.left, difference.right, result);

        return result;
    }

    private ParenthesesDifference getDifference(String s) {
        ParenthesesDifference difference = new ParenthesesDifference(0, 0);

        for (char character : s.toCharArray()) {
            if (character == '(') {
                difference.left++;
            }
            if (character == ')') {
                if (difference.left > 0) {
                    difference.left--;
                } else {
                    difference.right++;
                }
            }
        }

        return difference;
    }

    private void dsp(String s, int startIndex, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            if (validateString(s)) {
                result.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

            if (left > 0 && s.charAt(i) == '(') {
                dsp(s.substring(0, i) + s.substring(i + 1), i, left - 1, right, result);
            }
            if (right > 0 && s.charAt(i) == ')') {
                dsp(s.substring(0, i) + s.substring(i + 1), i, left, right - 1, result);
            }
        }
    }

    private boolean validateString(String s) {
        ParenthesesDifference difference = getDifference(s);
        // left == right is not enough, in the case of ")(" left == right == 1
        return difference.left == 0 && difference.right == 0;
    }
}
