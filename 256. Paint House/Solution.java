/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Paint House.
 * Memory Usage: 39 MB, less than 94.12% of Java online submissions for Paint House.
 */
class Solution {
    public int minCost(int[][] costs) {
        int len = costs.length;
        if (costs == null || len == 0) {
            return 0;
        }

        int red = costs[0][0];
        int blue = costs[0][1];
        int green = costs[0][2];
        for (int i = 1; i < len; i++) {
            int newRed = costs[i][0] + Math.min(blue, green);
            int newBlue = costs[i][1] + Math.min(red, green);
            int newGreen = costs[i][2] + Math.min(red, blue);
            red = newRed;
            blue = newBlue;
            green = newGreen;
        }
        return Math.min(red, Math.min(blue, green));
    }
}