/**
 * Runtime: 2 ms, faster than 94.61% of Java online submissions for Paint House II.
 * Memory Usage: 41.1 MB, less than 32.00% of Java online submissions for Paint House II.
 */
class Solution {
    public int minCostII(int[][] costs) {
        int len = costs.length;
        if (costs == null || len == 0) {
            return 0;
        }
        int colors = costs[0].length;
        int[][] minCosts = new int[len] [colors];
        for (int i = 0; i < colors; i++) {
            minCosts[0][i] = costs[0][i];
        }
        int min;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < colors; j++) {
                min = Integer.MAX_VALUE;
                for (int k = 0; k < colors; k++) {
                    if (j == k) continue;
                    min = Math.min(min, minCosts[i - 1][k]);
                }
                minCosts[i][j] = costs[i][j] + min;
            }
        }
        min = Integer.MAX_VALUE;
        for (int c : minCosts[len - 1]) {
            min = Math.min(min, c);
        }
        return min;

    }
}