/**
 * Runtime: 162 ms, faster than 40.37% of Java online submissions for Making A Large Island.
 * Memory Usage: 68.1 MB, less than 89.65% of Java online submissions for Making A Large Island.
 * Time Complexity : O (n ^ 2)
 * Space Complexity: 0 (N ^ 2)
 */

class Solution {
    Map<Integer, Integer> areaMap = new HashMap<>();
    int n = 0;
    public int largestIsland(int[][] grid) {
        n = grid.length;
        areaMap.put(0, 0);
        int gridId = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = getArea(gridId, i, j, grid);
                    areaMap.put(gridId, area);
                }
                gridId++;
            }
        }
        return findMaxArea(grid);
    }

    private int getArea(int gridId, int row, int col, int[][] grid) {
        if (row < 0 || col < 0 || row >= n || col >= n || grid[row][col] != 1) {
            return 0;
        }
        grid[row][col] = gridId;
        return 1 +
                getArea(gridId, row - 1, col, grid) +
                getArea(gridId, row + 1, col, grid) +
                getArea(gridId, row, col - 1, grid) +
                getArea(gridId, row, col + 1, grid);
    }

    private int findMaxArea(int[][] grid) {
        int maxArea = areaMap.getOrDefault(2, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    set.add(i > 0 ? grid[i - 1][j]: 0);
                    set.add(i < n - 1 ? grid[i + 1][j]: 0);
                    set.add(j > 0 ? grid[i][j - 1]: 0);
                    set.add(j < n - 1 ? grid[i][j + 1]: 0);
                    int totalArea = 1;
                    for (int s: set) {
                        totalArea += areaMap.get(s);
                    }
                    maxArea = Math.max(totalArea, maxArea);
                }

            }
        }
        return maxArea;
    }

}