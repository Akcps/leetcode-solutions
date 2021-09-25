/**
 * Runtime: 9 ms, faster than 77.94% of Java online submissions for Shortest Path in a Grid with Obstacles Elimination.
 * Memory Usage: 40.7 MB, less than 43.25% of Java online submissions for Shortest Path in a Grid with Obstacles Elimination.
 */

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (k >= rows + cols - 2) {
            return rows + cols - 2;
        }

        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        boolean[][][] visited = new boolean[rows][cols][k + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, k});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (current[0] == rows - 1 && current[1] == cols - 1) {
                return current[2];
            }

            for (int i = 0; i < 4; i++) {
                int x1 = current[0] + dx[i];
                int y1 = current[1] + dy[i];
                int steps = current[2] + 1;

                if (x1 < 0 || x1 >= grid.length || y1 < 0 || y1 >= grid[0].length) {
                    continue;
                }

                int eliminations = current[3] - grid[x1][y1];

                if (eliminations >= 0 && !visited[x1][y1][eliminations]) {
                    queue.add(new int[]{x1, y1, steps, eliminations});
                    visited[x1][y1][eliminations] = true;
                }
            }
        }
        return -1;
    }
}