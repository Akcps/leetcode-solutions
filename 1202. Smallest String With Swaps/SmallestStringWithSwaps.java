/**
 * Runtime: 46 ms, faster than 75.43% of Java online submissions for Smallest String With Swaps.
 * Memory Usage: 89.5 MB, less than 100.00% of Java online submissions for Smallest String With Swaps.
 */
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        DisjointSet ds = new DisjointSet(s.length());
        for (List<Integer> pair: pairs) {
            ds.union(pair.get(0), pair.get(1));
        }

        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int parent = ds.find(i);
            if(!map.containsKey(parent)) {
                map.put(parent, new PriorityQueue<>());
            }
            map.get(parent).add(ch);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(map.get(ds.find(i)).poll());
        }
        return sb.toString();
    }

    class DisjointSet {
        private int[] parent;

        public DisjointSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find (int x) {
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX != parentY) {
                parent[parentX] = parentY;
            }
        }
    }
}