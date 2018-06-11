package LintCode;

// https://www.lintcode.com/problem/word-ladder-ii/description

/**
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end,
 * such that:
 *   1. Only one letter can be changed at a time
 *   2. Each intermediate word must exist in the dictionary
 * Notice:
 *   All words have the same length.
 *   All words contain only lowercase alphabetic characters.
 */

/**
 * Example
 *
 * Given
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 *
 * Return
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 */

import java.util.*;

public class WordLadder2_121 {

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<>();
        Map<String, ArrayList<String>> nextWordsMap = new HashMap<>();
        Map<String, Integer> wordDistanceMap = new HashMap<>();
        List<String> path = new ArrayList<>();

        dict.add(start);
        dict.add(end);

        bfs(start, end, nextWordsMap, wordDistanceMap, dict);
        dfs(end, start, path, nextWordsMap, wordDistanceMap, result);

        return result;
    }

    private void dfs(String current, String start, List<String> path, Map<String, ArrayList<String>> nextWordsMap, Map<String, Integer> wordDistanceMap, List<List<String>> result) {
        path.add(current);

        if (current.equals(start)) {
            Collections.reverse(path);
            result.add(new ArrayList<>(path));
            Collections.reverse(path);
        } else {
            for (String next : nextWordsMap.get(current)) {
                if (wordDistanceMap.containsKey(next) && wordDistanceMap.get(current) == wordDistanceMap.get(next) + 1) {
                    dfs(next, start, path, nextWordsMap, wordDistanceMap, result);
                }
            }
        }

        path.remove(path.size() - 1);
    }

    private void bfs(String start, String end, Map<String, ArrayList<String>> nextWordsMap, Map<String, Integer> wordDistanceMap, Set<String> dict) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        wordDistanceMap.put(start, 0);

        for (String str : dict) {
            nextWordsMap.put(str, new ArrayList<String>());
        }

        while (!queue.isEmpty()) {
            String current = queue.poll();

            List<String> nextStrings = getNextStrings(current, dict);

            for (String next : nextStrings) {
                nextWordsMap.get(next).add(current);  // The order will be reversed in dfs

                if (!wordDistanceMap.containsKey(next)) {
                    wordDistanceMap.put(next, wordDistanceMap.get(current) + 1);
                    queue.offer(next);
                }
            }
        }
    }

    private List<String> getNextStrings(String current, Set<String> dict) {
        List<String> nextStrings = new ArrayList<>();

        for (int i = 0; i < current.length(); i++) {
            for (char character = 'a'; character <= 'z' ; character++) {
                if (character != current.charAt(i)) {
                    String next = current.substring(0, i) + character + current.substring(i + 1);
                    if (dict.contains(next)) {
                        nextStrings.add(next);
                    }
                }
            }
        }

        return nextStrings;
    }
}
