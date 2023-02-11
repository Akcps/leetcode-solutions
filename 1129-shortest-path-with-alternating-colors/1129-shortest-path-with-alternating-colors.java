class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();
        for (int[] edge : redEdges) {
            List<List<Integer>> val = adj.getOrDefault(edge[0], new ArrayList<>());
            val.add(Arrays.asList(edge[1], 0));
            adj.put(edge[0], val);
        }
        
        for (int[] edge : blueEdges) {
            List<List<Integer>> val = adj.getOrDefault(edge[0], new ArrayList<>());
            val.add(Arrays.asList(edge[1], 1));
            adj.put(edge[0], val);
        }
        
        int[] answer = new int[n];
        
        Arrays.fill(answer, -1);
        
        boolean[][] visit = new boolean[n][2]; // node, color
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0, -1 }); // node, step, color
        
        answer[0] = 0;
        visit[0][1] = true; // node = 0, color = red
        visit[0][0] = true; // node = 0, color = blue
        
         while (!q.isEmpty()) {
             
            int[] element = q.poll();
            int node = element[0];
            int steps = element[1];
            int prevColor = element[2];

            for (List<Integer> nei : adj.getOrDefault(node, new ArrayList<>())) {
                int neighbor = nei.get(0);
                int color = nei.get(1);
                if (!visit[neighbor][color] && color != prevColor) {
                    if (answer[neighbor] == -1) {
                       answer[neighbor] = 1 + steps; 
                    }  
                    visit[neighbor][color] = true;
                    q.add(new int[] { neighbor, 1 + steps, color });
                }
            }
        }
        return answer;
    }
}