/**
 * Runtime: 13 ms, faster than 51.38% of Java online submissions for Coin Change.
 * Memory Usage: 35.8 MB, less than 97.63% of Java online submissions for Coin Change.
 * Time Complexity: O (N ^ 2)
 * Space Complexity: O (N)
 */
class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }
}