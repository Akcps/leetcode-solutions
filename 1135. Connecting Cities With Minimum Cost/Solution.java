/**
 * Runtime: 32 ms, faster than 40.74% of Java online submissions for Connecting Cities With Minimum Cost.
 * Memory Usage: 60.2 MB, less than 100.00% of Java online submissions for Connecting Cities With Minimum Cost.
 */
class Solution {
    public int minimumCost(int N, int[][] connections) {
        int cost = 0;
        int[] parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));

        for (int[] connection: connections) {
            int root1 = find(connection[0], parent);
            int root2 = find(connection[1], parent);
            if (root1 != root2) {
                parent[root2] = root1;
                cost += connection[2];
                N--;
            }
            if (N == 1) {
                return cost;
            }
        }
        return -1;
    }

    private int find(int vertex, int[] parent) {
        int root = vertex;
        while (root != parent[root]) {
            root = parent[root];
        }
        return root;
    }
}