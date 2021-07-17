/**
 * Runtime: 5 ms, faster than 70.31% of Java online submissions for Course Schedule II.
 * Memory Usage: 39.8 MB, less than 88.02% of Java online submissions for Course Schedule II.
 * Time Complexity** : O (E + V)
 * Space Complexity**: O (E + V)
 * where |V| is the number of courses, and |E| is the number of dependencies/edges.
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] result = new int[numCourses];

        for (int i=0; i < prerequisites.length; i++) {
            int src = prerequisites[i][1];
            int des = prerequisites[i][0];
            List<Integer> lst = adj.getOrDefault(src, new ArrayList<>());
            lst.add(des);
            adj.put(src, lst);
            indegree[des]++;
        }

        Queue<Integer> q = new LinkedList<Integer>();

        for(int i=0; i<numCourses; i++){
            if (indegree[i] == 0)
                q.add(i);
        }

        int i = 0;
        while(!q.isEmpty()) {
            int n = q.poll();
            result[i++] = n;

            if (adj.containsKey(n)) {
                for (Integer neigh: adj.get(n)) {
                    indegree[neigh]--;

                    if (indegree[neigh] == 0)
                        q.add(neigh);
                }
            }
        }

        if (i == numCourses)
            return result;
        else
            return new int[0];
    }
}