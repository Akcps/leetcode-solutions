class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node current = root;
        for (char ch: word.toCharArray()) {
            if (current.children[ch - 'a'] == null) {
                current.children[ch - 'a'] = new Node();
            }
            current = current.children[ch - 'a'];
        }
        current.isWord = true;
    }
    
    public boolean search(String word) {
        return searchWord(word, 0, root);
    }
    
    private boolean searchWord (String word, int index, Node current) {
        if (index == word.length()) {
            if (current.isWord) {
                return true;
            }
            else {
                return false;
            }
        }

        char ch = word.charAt(index);
        boolean flag = false;
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (current.children[i] != null) {
                    flag = flag || searchWord(word, index + 1, current.children[i]);
                }
            }
        } else {
            if (current.children[ch - 'a'] == null) {
                return false;
            } else {
                return searchWord(word, index + 1, current.children[ch - 'a']);
            }
        }
        return flag;
    }
    
    
    class Node {
        Node[] children;
        boolean isWord;
        
        public Node() {
            children = new Node[26];
            isWord = false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */