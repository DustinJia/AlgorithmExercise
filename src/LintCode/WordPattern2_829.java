package LintCode;

// https://www.lintcode.com/problem/word-pattern-ii/description

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
 * (i.e if a corresponds to s, then b cannot correspond to s.
 * For example, given pattern = "ab", str = "ss", return false.)
 *
 *  Notice
 *    You may assume both pattern and str contains only lowercase letters.
 */

/**
 * Example
 * Given pattern = "abab", str = "redblueredblue", return true.
 * Given pattern = "aaaa", str = "asdasdasdasd", return true.
 * Given pattern = "aabb", str = "xyzabcxzyabc", return false.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class WordPattern2_829 {

    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null || pattern.length() > str.length()) {
            return false;
        }

        Map<Character, String> wordsMap = new HashMap<Character, String>();

        return matchPattern(pattern, str, new HashSet<String>(), wordsMap);
    }

    private boolean matchPattern(String pattern, String str, HashSet<String> wordsSet, Map<Character, String> wordsMap) {
        if (pattern.isEmpty()) {
            return str.isEmpty();
        }

        Character character = pattern.charAt(0);

        if (wordsMap.containsKey(character)) {
            String word = wordsMap.get(character);

            if (!str.startsWith(word)) {
                return false;
            }

            return matchPattern(pattern.substring(1), str.substring(word.length()), wordsSet, wordsMap);
        }

        for (int i = 0; i < str.length(); i++) {
            String word = str.substring(0, i + 1);
            if (wordsSet.contains(word)) {
                continue;
            }

            wordsMap.put(character, word);
            wordsSet.add(word);
            if (matchPattern(pattern.substring(1), str.substring(i + 1), wordsSet, wordsMap)) {
                return true;
            }
            wordsSet.remove(word);
            wordsMap.remove(character);
        }

        return false;
    }
}
