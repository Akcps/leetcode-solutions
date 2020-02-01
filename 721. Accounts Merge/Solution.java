/**
 * Runtime: 32 ms, faster than 87.71% of Java online submissions for Accounts Merge.
 * Memory Usage: 44.7 MB, less than 100.00% of Java online submissions for Accounts Merge.
 */
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> emailToId = new HashMap<>();

        DisjointSet ds = new DisjointSet(10000);
        int index = 0;
        for (List<String> account: accounts) {
            String name = null;
            for(String s: account) {
                if (name == null) {
                    name = s;
                } else {
                    emailToName.put(s, name);
                    if (!emailToId.containsKey(s)) {
                        emailToId.put(s, index++);
                    }
                    ds.union(emailToId.get(account.get(1)), emailToId.get(s));
                }
            }
        }
        Map<Integer, List<String>> result = new HashMap();
        for (String email: emailToName.keySet()) {
            int ind = ds.find(emailToId.get(email));
            result.computeIfAbsent(ind, x-> new ArrayList()).add(email);
        }

        for (List<String> component: result.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
        }
        return new ArrayList(result.values());
    }

    class DisjointSet {
        int[] parent;

        public DisjointSet(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
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