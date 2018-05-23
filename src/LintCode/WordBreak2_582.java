package LintCode;

// https://www.lintcode.com/problem/word-break-ii/description

/**
 * Given a string s and a dictionary of words dict,
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 */

/**
 * Example
 * Given s = lintcode, dict = ["de", "ding", "co", "code", "lint"].
 * A solution is ["lint code", "lint co de"].
 */

import java.util.*;

public class WordBreak2_582 {

    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<String, LinkedList<String>> memory = new HashMap<>();
        return dfs(s, wordDict, memory);
    }

    private List<String> dfs(String s, Set<String> wordDict, Map<String, LinkedList<String>> memory) {
        if (memory.containsKey(s)) {
            return memory.get(s);
        }

        LinkedList<String> result = new LinkedList<>();

        if (s == null || s.length() == 0) {
            return result;
        }

        if (wordDict.contains(s)) {
            result.add(s);
        }

        for (int i = 1; i < s.length(); i++) {
            String word = s.substring(0, i);

            if (wordDict.contains(word)) {
                String leftover = s.substring(i);
                List<String> segmentation = dfs(leftover, wordDict, memory);
                for (String segment : segmentation) {
                    result.add(word + " " + segment);
                }
            }
        }

        memory.put(s, result);
        return result;
    }
}
