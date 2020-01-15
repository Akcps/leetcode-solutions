/**
 * Runtime: 2 ms, faster than 99.75% of Java online submissions for All Paths From Source to Target.
 * Memory Usage: 42.1 MB, less than 58.33% of Java online submissions for All Paths From Source to Target
 */
class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        Map<Integer, int[]> g = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            g.put(i, graph[i]);
        }
        List<Integer> path = new ArrayList<>();
        path.add(0);
        findPaths(g, 0, path, paths);
        return paths;
    }

    private void findPaths(Map<Integer, int[]> g, int n, List<Integer> path, List<List<Integer>> paths) {
        if (n == g.size() - 1) {
            paths.add(new ArrayList<>(path));
            return;
        }

        for (int i: g.get(n)) {
            path.add(i);
            findPaths(g, i, path, paths);
            path.remove(path.size() - 1);
        }
    }
}