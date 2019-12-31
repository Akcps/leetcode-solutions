/**
 * Runtime: 4 ms, faster than 54.00% of Java online submissions for Number of Connected Components in an Undirected Graph.
 * Memory Usage: 42.4 MB, less than 100.00% of Java online submissions for Number of Connected Components in an Undirected Graph.
 */
class Solution {

    int[] parent;
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int root1 = find(edges[i][0]);
            int root2 = find(edges[i][1]);
            parent[root2] = root1;
        }

        return countConnectedComponent(n);

    }

    private int find(int vertex) {
        int root = vertex;
        while (root != parent[root]) {
            root = parent[root];
        }
        return root;
    }

    private int countConnectedComponent(int n) {
        HashSet<Integer> count = new HashSet<>();
        for (int i = 0; i < n; i++) {
            count.add(find(i));
        }
        return count.size();
    }
}