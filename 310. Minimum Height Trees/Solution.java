/**
 * Runtime: 28 ms, faster than 31.20% of Java online submissions for Minimum Height Trees.
 * Memory Usage: 48.7 MB, less than 94.44% of Java online submissions for Minimum Height Trees.
 */
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> leaves = new LinkedList<>();

        if (n <= 0) {
            return leaves;
        }

        if (n == 1 && edges.length == 0) {
            leaves.add(0);
            return leaves;
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n];

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            Set<Integer> adjSetFrom = graph.getOrDefault(from, new HashSet<>());
            Set<Integer> adjSetTo = graph.getOrDefault(to, new HashSet<>());

            adjSetFrom.add(to);
            adjSetTo.add(from);

            graph.put(from, adjSetFrom);
            graph.put(to, adjSetTo);

            indegree[from]++;
            indegree[to]++;
        }

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                leaves.add(i);
            }
        }

        List<Integer> newLeaves = new LinkedList<>();

        while (n > 2) {
            n -= leaves.size();
            int m = leaves.size();
            for(int i = 0; i < m; i++) {
                int current = leaves.remove(0);
                indegree[current] = 0;
                Set<Integer> neighbors = graph.get(current);
                for (int neighbor: neighbors) {
                    indegree[neighbor]--;
                    graph.get(neighbor).remove(current);
                    if (indegree[neighbor] == 1) {
                        newLeaves.add(neighbor);
                    }
                }
            }
            leaves = newLeaves;
            newLeaves = new LinkedList<>();
        }
        return leaves;
    }
}