/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
 * Memory Usage: 35.8 MB, less than 57.59% of Java online submissions for Climbing Stairs.
 * Time Complexity: O (N)
 * Space Complexity: O (N)
 */
class Solution {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp [i - 2];
        }
        return dp[n];
    }
}
