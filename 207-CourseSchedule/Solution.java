/**
 * Runtime: 11 ms, faster than 43.74% of Java online submissions for Course Schedule.
 * Memory Usage: 44.5 MB, less than 95.38% of Java online submissions for Course Schedule.
 */
class Solution {

    Map<Integer, Set<Integer>> graph = new HashMap<>();
    Map<Integer, Integer> inDegree = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0)
            return true;
        buildGraph(numCourses, prerequisites);
        int count = bfs();
        return count == numCourses;
    }

    private int bfs() {
        int count = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        for (int k: graph.keySet()) {
            if (inDegree.get(k) == null) continue;
            if (inDegree.get(k) == 0)
                q.add(k);
        }

        while(!q.isEmpty()) {
            count++;
            for (int c: graph.get(q.poll())) {
                inDegree.put(c, inDegree.get(c)-1);
                if (inDegree.get(c) == 0)
                    q.add(c);
            }
        }
        return count;
    }

    private void buildGraph(int courses, int[][] prerequisites) {
        for (int i = 0; i < courses; i++) {
            graph.putIfAbsent(i, new HashSet<>());
            inDegree.put(i, 0);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int out = prerequisites[i][0];
            int in = prerequisites[i][1];
            inDegree.put(in, inDegree.get(in) +1);
            graph.get(out).add(in);
        }
    }
}