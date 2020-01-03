/**
 * Runtime: 12 ms, faster than 50.00% of Java online submissions for All Paths from Source Lead to Destination.
 * Memory Usage: 52.5 MB, less than 100.00% of Java online submissions for All Paths from Source Lead to Destination.
 */
class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, Set<Integer>> graph = buildGraph(n, edges);
        if (graph.get(destination).size() > 0) {
            return false;
        }
        return dfs(graph, source, destination, new boolean[n]);
    }

    private boolean dfs(Map<Integer, Set<Integer>> graph, int current, int destination, boolean[] visited) {
        if (current == destination) {
           return true;
        }
        if (visited[current]){
            return false;
        }
        if (graph.get(current).size() == 0) {
            return false;
        }
        visited[current] = true;
        boolean flag = false;
        for (int neigh: graph.get(current)) {
            flag = dfs(graph, neigh, destination, visited);
            if (!flag) {
                return false;
            }
        }
        visited[current] = false;
        return flag;
    }

    private Map<Integer, Set<Integer>> buildGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }

        for (int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            Set<Integer> adjacentSet = graph.get(from);
            adjacentSet.add(to);
        }
        return graph;
    }
}