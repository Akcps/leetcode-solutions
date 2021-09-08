/**
 * Runtime: 7 ms, faster than 29.46% of Java online submissions for Best Meeting Point.
 * Memory Usage: 41.5 MB, less than 6.95% of Java online submissions for Best Meeting Point.
 * Time Complexity: O(N^2)
 * Space Complexity: O(N)
 */

class Solution {
    public int minTotalDistance(int[][] grid) {

        List<Integer> xCords = new ArrayList<>();
        List<Integer> yCords = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    xCords.add(i);
                }
            }
        }

        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1) {
                    yCords.add(j);
                }
            }
        }

        int xMid = xCords.get(xCords.size() / 2);
        int yMid = yCords.get(yCords.size() / 2);

        int distance = 0;

        for (int i = 0; i < xCords.size(); i++) {
            distance += Math.abs(xMid - xCords.get(i)) + Math.abs(yMid - yCords.get(i));
        }

        return distance;
    }

}