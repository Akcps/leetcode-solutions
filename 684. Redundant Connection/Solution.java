/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Redundant Connection.
 * Memory Usage: 39.5 MB, less than 72.73% of Java online submissions for Redundant Connection.
 */
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for (int[] edge: edges) {
            if(!union(edge, parent)) {
                return edge;
            }
        }
        return new int[] {-1, -1};
    }

    private int find(int[] parent, int node) {
        if (parent[node] == 0) {
            return node;
        }
        parent[node] = find(parent, parent[node]);
        return parent[node];
    }

    private boolean union(int[] edge, int[] parent) {
        int x = find(parent, edge[0]);
        int y = find(parent, edge[1]);
        if (x == y) {
            return false;
        }
        parent[x] = y;
        return true;
    }
}