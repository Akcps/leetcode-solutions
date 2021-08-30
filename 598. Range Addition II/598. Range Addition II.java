/**
 * Runtime: 1 ms, faster than 17.11% of Java online submissions for Range Addition II.
 * Memory Usage: 41.4 MB, less than 11.75% of Java online submissions for Range Addition II.
 */

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minX = m;
        int minY = n;
        for (int[] op : ops) {
            minX = Math.min(minX, op[0]);
            minY = Math.min(minY, op[1]);
        }
        return minX * minY;
    }
}