/**
 * Runtime: 47 ms, faster than 47.50% of Java online submissions for Add and Search Word - Data structure design.
 * Memory Usage: 55.2 MB, less than 81.82% of Java online submissions for Add and Search Word - Data structure design.
 */
class WordDictionary {
    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode current = root;
        for (char c: word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }
        current.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return find(root, word, 0);
    }

    private boolean find(TrieNode root, String word, int index) {
        if (word.length() == index) {
            return root.isWord;
        }

        if (word.charAt(index) != '.') {
            if (root.children.containsKey(word.charAt(index)) ){
                return find(root.children.get(word.charAt(index)), word, index + 1);
            } else  {
                return false;
            }
        }

        for(Character ch : root.children.keySet()){
            TrieNode n = root.children.get(ch);
            if(find(n, word, index + 1)){
                return true;
            }
        }
        return false;
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;

        public TrieNode() {}
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */