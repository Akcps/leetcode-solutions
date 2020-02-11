/**
 * Runtime: 1 ms, faster than 94.09% of Java online submissions for Dungeon Game.
 * Memory Usage: 40.8 MB, less than 76.47% of Java online submissions for Dungeon Game.
 */
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[m][n - 1] = 1;
        dp[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int hp = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                if (hp < 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = hp;
                }
            }
        }
        return dp[0][0];
    }
}