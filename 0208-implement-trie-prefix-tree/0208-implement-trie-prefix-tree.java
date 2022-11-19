class Trie {
    TrieNode root;
    
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = root;
        for (char ch: word.toCharArray()) {
            if (current.children[ch - 'a'] == null) {
                 current.children[ch - 'a'] = new TrieNode();
            }
            current =  current.children[ch - 'a'];
        }
        current.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        for (char ch: word.toCharArray()) {
            if (current.children[ch - 'a'] == null) {
                return false;
            }
            current = current.children[ch - 'a'];
        }
        return current.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char ch: prefix.toCharArray()) {
            if (current.children[ch - 'a'] == null) {
                return false;
            }
            current = current.children[ch - 'a'];
        }
        return true;
        
    }
    
    
     class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */