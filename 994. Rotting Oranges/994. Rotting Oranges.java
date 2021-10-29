/**
 * Runtime: 2 ms, faster than 97.00% of Java online submissions for Rotting Oranges.
 * Memory Usage: 38.6 MB, less than 63.36% of Java online submissions for Rotting Oranges.
 */

class Solution {
    int freshCount = 0;

    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        if (grid[0].length == 0) {
            return 0;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        if (freshCount == 0) {
            return 0;
        }
        int c = count(q, visited, grid);
        return freshCount != 0 ? -1 : c;
    }

    public int count(Queue<int[]> q, boolean[][] visited, int[][] grid) {
        int count = -1;
        while (!q.isEmpty()) {
            count++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] p = q.poll();
                int x = p[0];
                int y = p[1];
                if (valid(grid, x, y - 1, visited)) {
                    q.add(new int[]{x, y - 1});
                    freshCount--;
                    visited[x][y - 1] = true;
                }
                if (valid(grid, x, y + 1, visited)) {
                    q.add(new int[]{x, y + 1});
                    freshCount--;
                    visited[x][y + 1] = true;
                }
                if (valid(grid, x - 1, y, visited)) {
                    q.add(new int[]{x - 1, y});
                    freshCount--;
                    visited[x - 1][y] = true;
                }
                if (valid(grid, x + 1, y, visited)) {
                    q.add(new int[]{x + 1, y});
                    freshCount--;
                    visited[x + 1][y] = true;
                }
            }
        }
        return count;
    }

    public boolean valid(int[][] grid, int x, int y, boolean[][] visited) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1 && !visited[x][y];
    }

}