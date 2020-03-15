/**
 * Runtime: 1 ms, faster than 99.98% of Java online submissions for Number of Islands.
 * Memory Usage: 42.2 MB, less than 21.86% of Java online submissions for Number of Islands.
 */
class Solution {

    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    visit(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public void visit(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;
        if (grid[i][j] == '1' && !visited[i][j]) {
            visited[i][j] = true;
            visit(grid, i-1, j, visited);
            visit(grid, i+1, j, visited);
            visit(grid, i, j-1, visited);
            visit(grid, i, j+1, visited);
        }
        return;
    }
}


/**
 * Runtime: 1 ms, faster than 99.98% of Java online submissions for Number of Islands.
 * Memory Usage: 42.4 MB, less than 6.98% of Java online submissions for Number of Islands.
 */
class Solution {

    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    visit(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void visit(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            visit(grid, i-1, j);
            visit(grid, i+1, j);
            visit(grid, i, j-1);
            visit(grid, i, j+1);
        }
        return;
    }
}