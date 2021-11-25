/**
 * Runtime: 551 ms, faster than 35.50% of Java online submissions for Word Search II.
 * Memory Usage: 40.7 MB, less than 18.45% of Java online submissions for Word Search II.
 */
class Solution {

    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        String str;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
            str = "";
        }
    }

    class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void add(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                if (current.children[c - 'a'] == null) {
                    current.children[c - 'a'] = new TrieNode();
                }
                current = current.children[c - 'a'];
            }
            current.isWord = true;
            current.str = word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> matchedWords = new HashSet();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                findWords(board, i, j, matchedWords, visited, trie.root);
            }
        }
        return new ArrayList<>(matchedWords);
    }

    private void findWords(char[][] board, int row, int col, Set<String> matchedWords, boolean[][] visited, TrieNode node) {
        if (node.isWord) {
            matchedWords.add(node.str);
        }

        if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1 || visited[row][col] ||
                node.children[board[row][col] - 'a'] == null) {
            return;
        }

        visited[row][col] = true;
        findWords(board, row + 1, col, matchedWords, visited, node.children[board[row][col] - 'a']);
        findWords(board, row - 1, col, matchedWords, visited, node.children[board[row][col] - 'a']);
        findWords(board, row, col + 1, matchedWords, visited, node.children[board[row][col] - 'a']);
        findWords(board, row, col - 1, matchedWords, visited, node.children[board[row][col] - 'a']);
        visited[row][col] = false;
    }
}