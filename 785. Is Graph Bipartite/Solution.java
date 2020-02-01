/**
 * Runtime: 1 ms, faster than 70.64% of Java online submissions for Is Graph Bipartite.
 * Memory Usage: 42.2 MB, less than 65.85% of Java online submissions for Is Graph Bipartite
 */
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                color[i] = 0;

                while(!stack.isEmpty()) {
                    Integer pop = stack.pop();
                    for (int nei: graph[pop]) {
                        if (color[nei] == -1) {
                            stack.push(nei);
                            color[nei] = color[pop] ^ 1;
                        } else if (color[nei] == color[pop]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}