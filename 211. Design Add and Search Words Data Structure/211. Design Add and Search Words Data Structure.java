/**
 * Runtime: 38 ms, faster than 78.46% of Java online submissions for Design Add and Search Words Data Structure.
 * Memory Usage: 49.5 MB, less than 92.73% of Java online submissions for Design Add and Search Words Data Structure.
 */

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (char ch: word.toCharArray()) {
            if (current.children[ch - 'a'] == null) {
                current.children[ch - 'a'] = new TrieNode();
            }
            current = current.children[ch - 'a'];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        return searchWord(word, 0, root);
    }


    private boolean searchWord (String word, int index, TrieNode current) {
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
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */