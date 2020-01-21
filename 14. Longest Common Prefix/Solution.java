/**
 * Runtime: 4 ms, faster than 8.39% of Java online submissions for Longest Common Prefix.
 * Memory Usage: 40.9 MB, less than 5.26% of Java online submissions for Longest Common Prefix.
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        Trie trie = new Trie();
        for (String w: strs) {
            trie.addWord(w);
        }
        return trie.findPrefix(strs[0]);
    }


    public class TrieNode {
        private Map<Character, TrieNode> children;
        private boolean isEnd;

        public TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        }

    }

    public class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode current = root;
            for (char ch: word.toCharArray()) {
                if (!current.children.containsKey(ch)) {
                    current.children.put(ch, new TrieNode());
                }
                current = current.children.get(ch);
            }
            current.isEnd = true;
        }

        public String findPrefix(String searchWord) {
            TrieNode current = root;
            StringBuilder sb = new StringBuilder();
            for (char ch: searchWord.toCharArray()) {
                if (current.children.containsKey(ch) && current.children.keySet().size() == 1 && !current.isEnd) {
                    sb.append(ch);
                    current = current.children.get(ch);
                } else {
                    return sb.toString();
                }
            }
            return sb.toString();
        }
    }
}