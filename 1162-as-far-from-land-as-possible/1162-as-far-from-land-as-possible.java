class Solution {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{-1, 1, 0, 0};
    
    public int maxDistance(int[][] grid) {
        
        int[][] dist = new int[grid.length][grid[0].length];
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        
        
        int distance = -1;
        while (!queue.isEmpty()) {
            
            int qSize = queue.size();

            while (qSize-- > 0) {
                int[] landCell = queue.poll();
                
                for (int k = 0; k < 4; k++) {
                    int x = landCell[0] + dx[k];
                    int y = landCell[1] + dy[k];

                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && !visited[x][y]) {
                        visited[x][y] = true;
                        queue.add(new int[]{x,y});
                    }
                }
            }

            distance++;
        }
        return distance == 0 ? -1 : distance; // all 0's OR all 1's
    }
    
}