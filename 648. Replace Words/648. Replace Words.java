/**
 * Runtime: 20 ms, faster than 51.50% of Java online submissions for Replace Words.
 * Memory Usage: 55.4 MB, less than 15.74% of Java online submissions for Replace Words.
 */

class Solution {

    TrieNode root = new TrieNode();

    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder res = new StringBuilder();

        for (String word: dictionary) {
            insert(word);
        }


        for (String word: sentence.split("\\s+")) {
            if (res.length() > 0) {
                res.append(" ");
            }

            TrieNode current = root;
            for (char ch: word.toCharArray()) {
                if (!current.children.containsKey(ch) || current.word != null) {
                    break;
                }
                current = current.children.get(ch);
            }
            res.append(current.word != null? current.word : word);
        }
        return res.toString();
    }


    private void insert(String word) {
        TrieNode current = root;
        for (char c: word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }
        current.word = word;
    }

    class TrieNode {
        Map<Character, TrieNode> children;
        String word;

        public TrieNode() {
            children = new HashMap<>();
        }
    }
}