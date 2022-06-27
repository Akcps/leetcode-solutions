class Solution {
    private int count = 0;
    
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] =='1' && !visited[i][j]) {
                    countIslands(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void countIslands(char[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }
        if (grid[row][col] == '1' && !visited[row][col]) {
            visited[row][col] = true;
            countIslands(grid, row, col + 1, visited);
            countIslands(grid, row, col - 1, visited);
            countIslands(grid, row + 1, col, visited);
            countIslands(grid, row - 1, col, visited);
        }
        return;
    }
    
}