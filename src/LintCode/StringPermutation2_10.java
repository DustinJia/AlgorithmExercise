package LintCode;

// https://www.lintcode.com/problem/string-permutation-ii/description

/**
 * Given a string, find all permutations of it without duplicates.
 */

/**
 * Example
 * 
 * Given "abb", return ["abb", "bab", "bba"].
 * Given "aabb", return ["aabb", "abab", "baba", "bbaa", "abba", "baab"].
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutation2_10 {

    public List<String> stringPermutation2(String str) {
        List<String> result = new ArrayList<>();
        
        if (str == null) {
            return result;
        }

        char[] characters = str.toCharArray();
        Arrays.sort(characters);

        String string = String.valueOf(characters);
        boolean[] visited = new boolean[string.length()];

        dfs(string, visited, "", result);
        
        return result;
    }

    private void dfs(String string, boolean[] visited, String permutation, List<String> result) {
        if (permutation.length() == string.length()) {
            result.add(permutation);
            return;
        }

        for (int i = 0; i < string.length(); i++) {
            if (visited[i]) {
                continue;
            }

            if (i > 0 && string.charAt(i) == string.charAt(i - 1) && !visited[i - 1]) {
                continue;
            }

            permutation += string.charAt(i);
            visited[i] = true;
            dfs(string, visited, permutation, result);
            visited[i] = false;
            permutation = permutation.substring(0, permutation.length() - 1);
        }
    }
}
