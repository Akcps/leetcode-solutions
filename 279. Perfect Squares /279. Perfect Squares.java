/**
 * Runtime: 49 ms, faster than 50.57% of Java online submissions for Perfect Squares.
 * Memory Usage: 39.5 MB, less than 45.47% of Java online submissions for Perfect Squares.
 */

class Solution {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}