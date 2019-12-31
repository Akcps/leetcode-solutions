/**
 * Runtime: 13 ms, faster than 51.38% of Java online submissions for Coin Change.
 * Memory Usage: 35.8 MB, less than 97.63% of Java online submissions for Coin Change.
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i- coins[j]] + 1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE - 1)
            return -1;
        return dp[amount];
    }
}
