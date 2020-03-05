/**
 * Runtime: 22 ms, faster than 89.08% of Java online submissions for Sentence Similarity II.
 * Memory Usage: 42.3 MB, less than 100.00% of Java online submissions for Sentence Similarity II.
 */
class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        DisjointSet ds = new DisjointSet(2 * pairs.size());
        for (List<String> pair: pairs) {
            for (String str: pair) {
                if (!map.containsKey(str)) {
                    map.put(str, index++);
                }
            }
            ds.union(map.get(pair.get(0)), map.get(pair.get(1)));
        }
        for (int i = 0; i < words1.length; i++) {
            if (!words1[i].equals(words2[i])) {
                if (!map.containsKey(words1[i]) || !map.containsKey(words2[i]) || ds.find(map.get(words1[i])) != ds.find(map.get(words2[i]))) {
                    return false;
                }
            }
        }
        return true;
    }

    class DisjointSet {
        int[] parent;

        public DisjointSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }
}