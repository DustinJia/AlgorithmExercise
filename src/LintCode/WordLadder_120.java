package LintCode;

// https://www.lintcode.com/en/problem/word-ladder/

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 *  1. Only one letter can be changed at a time
 *  2. Each intermediate word must exist in the dictionary
 *
 *  Notice
 *    Return 0 if there is no such transformation sequence.
 *    All words have the same length.
 *    All words contain only lowercase alphabetic characters.
 */

/**
 * Example
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 */

import java.util.*;

import static jdk.nashorn.internal.objects.NativeString.replace;

public class WordLadder_120 {

    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null) {
            return 0;
        }

        if (start.equals(end)) {
            return 1;
        }

        dict.add(start);
        dict.add(end);

        Queue queue = new ArrayDeque();
        Set<String> hashSet = new HashSet<>();
        queue.offer(start);
        hashSet.add(start);

        int step = 1;
        while (!queue.isEmpty()) {
            step++;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = (String) queue.poll();
                for (String next : getNextWords(word, dict)) {
                    if (hashSet.add(next)) {
                        if (next.equals(end)) {
                            return step;
                        }

                        queue.offer(next);
                    }
                }
            }
        }

        return 0;
    }

    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> words = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (word.charAt(i) != c) {
                    String newWord = replace(word, i, c);
                    if (dict.contains(newWord)) {
                        words.add(newWord);
                    }
                }
            }
        }

        return words;
    }

    private String replace(String word, int position, char c) {
        char[] chars = word.toCharArray();
        chars[position] = c;
        return new String(chars);
    }
}
