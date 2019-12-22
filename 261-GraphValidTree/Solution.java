/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Graph Valid Tree.
 * Memory Usage: 43.8 MB, less than 67.57% of Java online submissions for Graph Valid Tree.
 */
class Solution {
    private int [] parent;

    private int find(int p) {
        int root = p;
        while (root != parent[root]) {
            root = parent[root];
        }
        return root;
    }

    public boolean validTree(int n, int[][] edges) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int root1 = find(edges[i][0]);
            int root2 = find(edges[i][1]);
            if (root1 == root2)
                return false;

            parent[root2] = root1;
        }

        return edges.length == n - 1;
    }
}