class Solution {
    TrieNode root = new TrieNode();
    
    public List<String> findWords(char[][] board, String[] words) {
        addWords(words);
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> matchedWords = new HashSet();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                findWords(board, i, j, matchedWords, visited, root);
            }
        }
        return new ArrayList<>(matchedWords);
    }
    
    private void findWords(char[][] board, int row, int col, Set<String> matchedWords, boolean[][] visited, TrieNode node) {
        if (node.isWord) {
            matchedWords.add(node.word);
        }

        if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1 || visited[row][col] || node.children[board[row][col] - 'a'] == null) {
            return;
        }

        visited[row][col] = true;
        findWords(board, row + 1, col, matchedWords, visited, node.children[board[row][col] - 'a']);
        findWords(board, row - 1, col, matchedWords, visited, node.children[board[row][col] - 'a']);
        findWords(board, row, col + 1, matchedWords, visited, node.children[board[row][col] - 'a']);
        findWords(board, row, col - 1, matchedWords, visited, node.children[board[row][col] - 'a']);
        visited[row][col] = false;
    }
    
    private void addWords(String[] words){
        for (String word: words){
            addWord(word);
        }
    }
    
    private void addWord(String word) {
        TrieNode current = root;
        for (char ch: word.toCharArray()) {
            if (current.children[ch - 'a'] == null) {
                current.children[ch - 'a'] = new TrieNode();
            }
            current = current.children[ch - 'a'];
        }
        current.isWord = true;
        current.word = word;
    }
    
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        String word;
        
        public TrieNode(){
            children = new TrieNode[26];
            word = "";
        }
    }
}