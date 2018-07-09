package LintCode;

// https://www.lintcode.com/problem/first-unique-character-in-a-string/description

/**
 * Find the first unique character in a given string.
 * You can assume that there is at least one unique character in the string.
 */

/**
 * Example
 * For "abaccdeff", return 'b'.
 */

import java.util.TreeMap;

public class FirstUniqueCharacterInAString_209 {

    public char firstUniqChar(String str) {
        TreeMap<Character, Integer> map = new TreeMap<>();

        for (char character : str.toCharArray()) {
            if (map.containsKey(character)) {
                map.put(character, map.get(character) + 1);
            } else {
                map.put(character, 1);
            }
        }

        for (char key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }

        return '.';
    }
}
