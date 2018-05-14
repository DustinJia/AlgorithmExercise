package LintCode;

// https://www.lintcode.com/problem/split-string/description

/**
 * Give a string, you can choose to split the string after one character or two adjacent characters,
 * and make the string to be composed of only one character or two characters. Output all possible results.
 */

/**
 * Example
 * Given the string "123"
 * return [["1","2","3"],["12","3"],["1","23"]]
 */

import java.util.LinkedList;
import java.util.List;

public class SplitString_680 {

    public List<List<String>> splitString(String s) {
        List<List<String>> result = new LinkedList<>();

        if (s == null) {
            return result;
        }

        dsp(s, 0, new LinkedList<String>(), result);

        return result;
    }

    private void dsp(String s, int startIndex, LinkedList<String> subSet, List<List<String>> result) {
        if (startIndex >= s.length()) {
            result.add(new LinkedList<>(subSet));
            return;
        }

        if (startIndex < s.length()) {
            String subString = s.substring(startIndex, startIndex + 1);
            subSet.add(subString);
            dsp(s, startIndex + 1, subSet, result);
            subSet.remove(subSet.size() - 1);
        }

        if (startIndex < s.length() - 1) {
            String subString = s.substring(startIndex, startIndex + 2);
            subSet.add(subString);
            dsp(s, startIndex + 2, subSet, result);
            subSet.remove(subSet.size() - 1);
        }
    }
}
