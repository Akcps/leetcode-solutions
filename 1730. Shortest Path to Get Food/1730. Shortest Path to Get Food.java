/**
 * Runtime: 21 ms, faster than 17.08% of Java online submissions for Shortest Path to Get Food.
 * Memory Usage: 60 MB, less than 9.66% of Java online submissions for Shortest Path to Get Food.
 */
class Solution {

    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};

    public int getFood(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int steps = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '*') {
                    steps = findPath(grid, i, j, visited);
                }
            }
        }
        return steps;
    }

    private int findPath(char[][] grid, int x, int y, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x1 = current[0] + dx[i];
                int y1 = current[1] + dy[i];
                int steps = current[2] + 1;

                if (x1 < 0 || x1 >= grid.length || y1 < 0 || y1 >= grid[0].length) {
                    continue;
                }
                if (grid[x1][y1] == '#') {
                    return steps;
                }

                if (!visited[x1][y1] && grid[x1][y1] == 'O') {
                    queue.add(new int[]{x1, y1, steps});
                }
                visited[x1][y1] = true;
            }
        }
        return -1;
    }
}