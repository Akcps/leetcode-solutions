/**
 * Runtime: 1 ms, faster than 99.92% of Java online submissions for Min Cost Climbing Stairs.
 * Memory Usage: 40.6 MB, less than 14.29% of Java online submissions for Min Cost Climbing Stairs.
 */
class Solution {
     public int minCostClimbingStairs(int[] cost) {
         if (cost == null || cost.length == 0)
             return 0;
         int[] dp = new int[cost.length];
         dp[0] = cost[0];
         dp[1] = cost[1];
         for (int i = 2; i < cost.length; i++) {
             dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
         }
         return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
     }
 }

/**
 * Runtime: 1 ms, faster than 99.92% of Java online submissions for Min Cost Climbing Stairs.
 * Memory Usage: 39.5 MB, less than 41.07% of Java online submissions for Min Cost Climbing Stairs.
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0)
            return 0;
        int f1 = cost[0];
        int f2 = cost[1];
        int f3 = 0;
        for (int i = 2; i < cost.length; i++) {
            f3 = Math.min(f1, f2) + cost[i];
            f1 = f2;
            f2 = f3;
        }
        return Math.min(f1, f2);
    }
}