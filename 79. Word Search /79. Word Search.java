/**
 * Runtime: 182 ms, faster than 21.89% of Java online submissions for Word Search.
 * Memory Usage: 39.1 MB, less than 24.47% of Java online submissions for Word Search.
 */

class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (exists(board, word, 0, i, j, visited))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean exists(char[][] board, String word, int wordIndex, int row, int col, boolean[][] visited) {
        if (wordIndex == word.length()) {
            return true;
        }

        if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1
                || visited[row][col] || word.charAt(wordIndex) != board[row][col]) {
            return false;
        }
        visited[row][col] = true;
        boolean result = exists(board, word, wordIndex + 1, row + 1, col, visited) ||
                exists(board, word, wordIndex + 1, row - 1, col, visited) ||
                exists(board, word, wordIndex + 1, row, col + 1, visited) ||
                exists(board, word, wordIndex + 1, row, col - 1, visited);
        visited[row][col] = false;
        return result;
    }
}