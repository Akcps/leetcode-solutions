/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Distribute Coins in Binary Tree.
 * Memory Usage: 38 MB, less than 100.00% of Java online submissions for Distribute Coins in Binary Tree.
 */
class Solution {
    int numMoves = 0;
    public int distributeCoins(TreeNode root) {
        calculateMoves(root);
        return numMoves;
    }

    private int calculateMoves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = calculateMoves(root.left);
        int right = calculateMoves(root.right);
        numMoves += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }
}