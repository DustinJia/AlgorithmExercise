package LintCode;

// https://www.lintcode.com/problem/word-search-ii/description

/**
 * Given a matrix of lower alphabets and a dictionary. Find all words in the dictionary that can be found in the matrix.
 * A word can start from any position in the matrix and go left/right/up/down to the adjacent position.
 */

/**
 * Example
 *
 * Given matrix:
 *   doaf
 *   agai
 *   dcan
 * and dictionary:
 *   {"dog", "dad", "dgdg", "can", "again"}
 * return {"dog", "dad", "can", "again"}
 */

import java.util.*;

public class WordSearch2_132 {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public List<String> wordSearchII(char[][] board, List<String> words) {
        if (board == null || board.length == 0 || board[0].length == 0 || 
                words == null || words.isEmpty()) {
            return new ArrayList<>();
        }
        
        Map<String, Boolean> prefixValidator = constructPrefixValidator(board, words);

        Set<String> validWords = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                visited[i][j] = true;
                dfs(board, i, j, String.valueOf(board[i][j]), prefixValidator, visited, validWords);
                visited[i][j] = false;
            }
        }
        
        return new ArrayList<>(validWords);
    }

    private void dfs(char[][] board, int x, int y, String word, Map<String, Boolean> prefixValidator, boolean[][] visited, Set<String> validWords) {
        if (!prefixValidator.containsKey(word)) {
            return;
        }

        if (prefixValidator.get(word)) {
            validWords.add(word);
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (!isPositionValid(board, nextX, nextY) || visited[nextX][nextY]) {
                continue;
            }

            visited[nextX][nextY] = true;
            dfs(board, nextX, nextY, word + board[nextX][nextY], prefixValidator, visited, validWords);
            visited[nextX][nextY] = false;
        }
    }

    private Map<String,Boolean> constructPrefixValidator(char[][] board, List<String> words) {
        Map<String, Boolean> prefixValidator = new HashMap<>();

        for (String word : words) {
            for (int i = 0; i < word.length() - 1; i++) {
                String targetWord = word.substring(0, i + 1);

                if (!prefixValidator.containsKey(targetWord)) {
                    prefixValidator.put(targetWord, false);
                }
            }
            prefixValidator.put(word, true);
        }

        return prefixValidator;
    }

    private boolean isPositionValid(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }
}
