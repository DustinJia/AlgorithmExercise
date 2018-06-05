package LintCode;

// https://www.lintcode.com/problem/letter-combinations-of-a-phone-number/description

/**
 * Given a digit string excluded 01, return all possible letter combinations that the number could represent.
 * Notice
 *   Your answer could be in any order you want.
 */

/**
 * Example
 *
 * Given "23"
 * Return ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber_425 {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return result;
        }

        Map<Character, char[]> dictionary = new HashMap<>();
        dictionary.put('0', new char[]{});
        dictionary.put('1', new char[]{});
        dictionary.put('2', new char[]{'a', 'b', 'c'});
        dictionary.put('3', new char[]{'d', 'e', 'f'});
        dictionary.put('4', new char[]{'g', 'h', 'i'});
        dictionary.put('5', new char[]{'j', 'k', 'l'});
        dictionary.put('6', new char[]{'m', 'n', 'o'});
        dictionary.put('7', new char[]{'p', 'q', 'r', 's'});
        dictionary.put('8', new char[]{'t', 'u', 'v'});
        dictionary.put('9', new char[]{'w', 'x', 'y', 'z'});

        StringBuilder stringBuilder = new StringBuilder();

        dfs(digits, dictionary, stringBuilder, result);

        return result;
    }

    private void dfs(String digits, Map<Character, char[]> dictionary, StringBuilder stringBuilder, List<String> result) {
        if (stringBuilder.length() == digits.length()) {
            result.add(stringBuilder.toString());
            return;
        }

        for (char character : dictionary.get(digits.charAt(stringBuilder.length()))) {
            stringBuilder.append(character);
            dfs(digits, dictionary, stringBuilder, result);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
