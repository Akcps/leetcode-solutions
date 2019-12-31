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

/**
 * Runtime: 9 ms, faster than 13.16% of Java online submissions for Graph Valid Tree.
 * Memory Usage: 44.5 MB, less than 54.05% of Java online submissions for Graph Valid Tree.
 */
class Solution {

    Map<Integer, Set<Integer>> graph = new HashMap<>();
    boolean[] visited;

    public boolean validTree(int n, int[][] edges) {

        visited = new boolean[n];
        buildGraph(edges);

        if (hasCycle(0, -1)) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }

    private void buildGraph(int[][] edges) {
        for (int[] edge: edges) {
            Set<Integer> connected = graph.getOrDefault(edge[0], new HashSet<>());
            connected.add(edge[1]);
            graph.put(edge[0], connected);
            connected = graph.getOrDefault(edge[1], new HashSet<>());
            connected.add(edge[0]);
            graph.put(edge[1], connected);
        }
    }

    private boolean hasCycle(int vertex, int parent) {
        visited[vertex] = true;
        for (int i: graph.getOrDefault(vertex, new HashSet<>())) {
            if (!visited[i]) {
                if (hasCycle(i, vertex)) {
                    return true;
                }
            } else if (i != parent) {
                return true;
            }
        }
        return false;
    }
}
