/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Binary Search Trees.
 * Memory Usage: 36.1 MB, less than 18.70% of Java online submissions for Unique Binary Search Trees.
 */

/**
 * Explanation:
 *  Dynamic programming:
 *
 *    With 1 element, we can create only one tree.
 *    dp[1] = 1
 *
 *    With 2 element [1,2], we can create 2 trees.
 *    Root as 1
 *    Root as 2
 *
 *    dp[2] = 2
 *
 *    With 3 elements [1, 2, 3], we can create 5 trees.
 *  We can create trees with roots as 1, 2 and 3
 *
 *  Root as 1  = 2 trees
 *             1
 *              \
 *             [2,3] = 2 trees
 *
 *  Root as 2 = 1 tree
 *           2
 *          / \
 *         1   3
 *
 *  Root as 3 = 2 trees
 *          3
 *         /
 *       [1,2]  = 2 trees
 *
 *  dp[3]  = dp[1] * dp[2]  + dp[2] * dp[1]
 *  dp[n] = dp[1] * dp[n-1] + dp[2] * dp[n-2] + ..... so on.
 *
 *
 *  Time Complexity = O(n*n)
 *  Space Complexity = O(n)
 */

class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}