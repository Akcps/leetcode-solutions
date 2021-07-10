/**
 * Runtime: 3 ms, faster than 63.23% of Java online submissions for Max Area of Island.
 * Memory Usage: 39.2 MB, less than 91.13% of Java online submissions for Max Area of Island.
 * Time Complexity = O (R * C)
 * Space Complexity = O (R * C)
 */

class Solution {

    int[] dr = new int [] { 0,  0, -1, 1};
    int[] dc = new int [] {-1,  1,  0, 0};
    int rows = 0;
    int cols = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0;  i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int sum = findArea(grid, visited, i, j);
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
        }
        return max;
    }

    private int findArea(int[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return 0;
        }
        if (visited[row][col] || grid[row][col] == 0) {
            return 0;
        }
        int sum = 1;
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int r = row + dr[i];
            int c = col + dc[i];
            sum += findArea(grid, visited, r, c);
        }
        return sum;
    }
}