/**
 * Runtime: 11 ms, faster than 93.27% of Java online submissions for Map Sum Pairs.
 * Memory Usage: 38.9 MB, less than 80.39% of Java online submissions for Map Sum Pairs.
 *
 * Time Complexity: Every insert operation is O(K)O(K), where KK is the length of the key. Every sum operation is O(K)O(K).
 * Space Complexity: The space used is linear in the size of the total input.
 */

class MapSum {
    TrieNode root;
    HashMap<String, Integer> words;

    public MapSum() {
        root = new TrieNode();
        words = new HashMap<>();
    }

    public void insert(String word, int count) {
        boolean add = true;
        int newCount = count;
        if (words.containsKey(word)) {
            newCount = count - words.get(word) ;

        }
        TrieNode current = root;
        for (char c: word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
            current.count += newCount;
        }
        words.put(word, count);
    }

    public int sum(String word) {
        TrieNode current = root;
        for (char c: word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return 0;
            }
            current = current.children.get(c);
        }
        return current.count;
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
        int count = 0;

        public TrieNode() {}


    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */