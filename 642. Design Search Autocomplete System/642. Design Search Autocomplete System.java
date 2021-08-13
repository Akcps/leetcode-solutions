/**
 * Runtime: 149 ms, faster than 35.78% of Java online submissions for Design Search Autocomplete System.
 * Memory Usage: 48.2 MB, less than 82.11% of Java online submissions for Design Search Autocomplete System.
 */

class AutocompleteSystem {

    Trie trie;
    StringBuilder currentSentence;

    public AutocompleteSystem(String[] sentences, int[] times) {

        trie = new Trie();
        currentSentence = new StringBuilder();

        for (int i = 0; i< sentences.length; i++) {
            trie.addWord(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {

        List<String> result = new ArrayList<>();
        if (c == '#') {

            trie.addWord(currentSentence.toString(), 1);
            currentSentence = new StringBuilder();

        } else {

            currentSentence.append(c);
            PriorityQueue<TrieNode> minHeap = new PriorityQueue<TrieNode>(new Comparator<TrieNode>(){
                public int compare(TrieNode A, TrieNode B) {
                    return A.count == B.count ? B.sentence.compareTo(A.sentence) : A.count - B.count;
                }
            });

            lookup(minHeap, currentSentence.toString());

            List<String> values = new ArrayList<String>();

            while(!minHeap.isEmpty()) {
                values.add(minHeap.poll().sentence);
            }

            for (int i = values.size() - 1; i >= 0; i--) {
                result.add(values.get(i));
            }
        }
        return result;
    }

    private void lookup(PriorityQueue<TrieNode> minHeap, String s) {
        TrieNode curr = trie.root;
        for (char c: s.toCharArray()) {
            if (curr.children[getInt(c)] == null)
                return;
            else
                curr = curr.children[getInt(c)];
        }
        traverse(curr, minHeap);
    }

    private void traverse(TrieNode cur, PriorityQueue<TrieNode> minHeap) {
        if (cur.count > 0) {
            TrieNode node = new TrieNode();
            node.count = cur.count;
            node.sentence = cur.sentence;
            minHeap.add(node);
            if (minHeap.size() > 3) {
                minHeap.poll();
            }
        }
        for (int i = 0 ; i <= 26; i++) {
            if (cur.children[i] != null) {
                traverse(cur.children[i], minHeap);
            }
        }
    }

    private int getInt(char c) {
        return c == ' ' ? 26 : c -'a';
    }

    class TrieNode {

        TrieNode[] children;
        int count;
        String sentence;

        public TrieNode() {
            children = new TrieNode[27];
            count = 0;
            sentence = "";
        }
    }


    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public int getInt(char c) {
            return c == ' ' ? 26 : c -'a';
        }

        public void addWord(String word, int count) {
            TrieNode cur = trie.root;
            for (char c: word.toCharArray()) {
                if (cur.children[getInt(c)] == null) {
                    cur.children[getInt(c)] = new TrieNode();
                }
                cur = cur.children[getInt(c)];
            }
            cur.count += count;
            cur.sentence = word;
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */